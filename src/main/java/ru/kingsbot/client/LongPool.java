package ru.kingsbot.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;
import ru.kingsbot.Bot;
import ru.kingsbot.client.exception.InvalidResponseException;
import ru.kingsbot.client.objects.VkError;
import ru.kingsbot.client.objects.longpool.LongPoolServer;
import ru.kingsbot.client.objects.longpool.response.LongPoolResponse;
import ru.kingsbot.client.objects.longpool.response.LongPoolUpdate;
import ru.kingsbot.client.objects.longpool.response.LongPoolUpdateObject;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.TextCommandParser;
import ru.kingsbot.command.keyboard.Keyboards;
import ru.kingsbot.entity.Player;
import ru.kingsbot.game.Tutorial;
import ru.kingsbot.service.PlayerService;

import java.util.List;
import java.util.Map;

@Log4j2
public class LongPool {

    private static final String MESSAGE_NEW = "message_new";

    private final Bot bot;
    private final TransportClient transportClient;
    private final Integer groupId;

    private TextCommandParser commandParser;
    private PlayerService playerService;

    private JsonParser parser;
    private Gson gson;

    private LongPoolServer longPoolServer;

    public LongPool(Bot bot, TransportClient transportClient, Integer groupId) {
        this.bot = bot;
        this.transportClient = transportClient;
        this.groupId = groupId;
        parser = new JsonParser();
        gson = new Gson();
        playerService = bot.getPlayerService();
        commandParser = new TextCommandParser(bot);
    }

    private void getLongPoolData() throws InvalidResponseException {
        ApiRequest request = ApiRequest.newApiRequest()
                .method("groups.getLongPollServer")
                .param("group_id", groupId)
                .build();
        String response = transportClient.sendVkApiRequest(request);

        JsonObject element = parser.parse(response).getAsJsonObject();
        if(element.has("error")) {
            VkError error = gson.fromJson(element.get("error"), VkError.class);
            throw new InvalidResponseException(error);
        }
        if(element.has("response")) {
            longPoolServer = gson.fromJson(element.get("response"), LongPoolServer.class);
        }
    }

    public void run() {
        try {
            getLongPoolData();
        } catch (InvalidResponseException e) {
            log.error(e.getMessage(), e);
        }

        LongPoolResponse longPoolResponse;

        while(true) {
            String url = longPoolServer.getServer() + "?act=a_check&key=" + longPoolServer.getKey() + "&ts=" + longPoolServer.getTs() + "&wait=5";
            String body = transportClient.sendGetRequest(url);

            JsonObject jsonObject = parser.parse(body).getAsJsonObject();
            if(jsonObject.has("failed")) {
                switch(jsonObject.get("failed").getAsString()) {

                    // История событий устарела или была частично утеряна,
                    // приложение может получать события далее, используя новое значение ts из ответа
                    case "1":
                        longPoolServer.setTs(jsonObject.get("ts").getAsString());
                    break;

                    // Истекло время действия ключа, нужно заново получить key методом groups.getLongPollServer
                    case "2":

                    // Информация утрачена, нужно запросить новые key и ts методом groups.getLongPollServer
                    case "3":
                        try {
                            getLongPoolData();
                        } catch (InvalidResponseException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                continue;
            }

            longPoolResponse = gson.fromJson(jsonObject, LongPoolResponse.class);
            System.out.println(longPoolResponse);
            longPoolServer.setTs(longPoolResponse.getTs());

            List<LongPoolUpdate> updates = longPoolResponse.getUpdates();
            updates.forEach(update -> {
                switch(update.getType()) {
                    case MESSAGE_NEW:
                        LongPoolUpdateObject object = update.getObject();
                        int fromId = object.getFromId();
                        if(fromId == groupId) {
                            return;
                        }
                        int peerId = object.getPeerId();
                        String text = object.getText();
                        Map<String, String> payload = object.getPayload();
                        Player player = playerService.load(fromId);
                        if(payload.isEmpty()) {
                            if(peerId == fromId) {
                                if(!player.isTutorial()) {
                                    Tutorial tutorial = new Tutorial(player);
                                    tutorial.start();
                                    return;
                                }
                            }else{
                                if(!player.isTutorial()) {
                                    playerService.sendMessage(peerId, "Чтобы начать игру напишите в группу vk.me/kingsbot", Keyboards.getChatKeyboard());
                                }
                            }
                            commandParser.parse(peerId, fromId, text);
                            return;
                        }

                        if(peerId == fromId) {
                            if(!player.isTutorial()) {
                                Tutorial tutorial = new Tutorial(player);
                                tutorial.start();
                                return;
                            }
                            if(payload.isEmpty()) {
                                playerService.sendMessage(peerId, "Для игры используйте кнопки", Keyboards.getGroupKeyboard());
                                return;
                            }
                            String commandName = payload.get("command");
                            //payload.remove("command");
                            if(player.isBanned()) {
                                bot.getCommandMap().getCommand("user_banned").execute(player, peerId, payload);
                                return;
                            }
                            Command command = bot.getCommandMap().getCommand(commandName);
                            command.execute(player, peerId, payload);
                        }else{
                            if(!player.isTutorial()) {
                                playerService.sendMessage(peerId, "Чтобы начать игру напишите в группу vk.me/kingsbot", Keyboards.getChatKeyboard());
                                return;
                            }
                            if(player.isBanned()) {
                                return;
                            }
                            String commandName = payload.get("command");
                            Command command = bot.getCommandMap().getChatCommand(commandName);
                            command.execute(player, peerId, payload);
                        }
                    break;
                }
            });

        }
    }

}
