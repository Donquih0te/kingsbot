package ru.kingsbot.api;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import ru.kingsbot.Bot;
import ru.kingsbot.api.keyboard.Keyboards;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.TextCommandParser;
import ru.kingsbot.entity.Player;
import ru.kingsbot.service.PlayerService;
import ru.kingsbot.service.RequestHandler;
import ru.kingsbot.tutorial.Tutorial;
import ru.kingsbot.utils.Utils;

import java.util.Map;
import java.util.Optional;

@Log4j2
public class LongPool {

    private static final String MESSAGE_NEW = "message_new";

    private final Bot bot;
    private final RequestHandler requestHandler;
    private final Integer groupId;

    private TextCommandParser commandParser;
    private PlayerService playerService;

    private JsonParser parser;

    private String key;
    private String server;
    private String ts;

    public LongPool(Bot bot, RequestHandler requestHandler, Integer groupId) {
        this.bot = bot;
        this.requestHandler = requestHandler;
        this.groupId = groupId;
        parser = new JsonParser();
        playerService = bot.getPlayerService();
        commandParser = new TextCommandParser(bot);
        getLongPoolData();
    }

    private void getLongPoolData() {
        ApiRequest request = ApiRequest.newApiRequest()
                .method("groups.getLongPollServer")
                .param("group_id", groupId)
                .build();
        String response = requestHandler.sendVkApiRequest(request);
        if(response == null) {
            return;
        }

        JsonObject element = parser.parse(response).getAsJsonObject();
        if(element.has("error")) {
            log.error("ApiRequest error\n" + element.toString());
            return;
        }
        if(element.has("response")) {
            JsonObject object = element.get("response").getAsJsonObject();
            key = object.get("key").getAsString();
            server = object.get("server").getAsString();
            ts = object.get("ts").getAsString();
        }
    }

    public void run () {
        while(true) {
            String url = server + "?act=a_check&key=" + key + "&ts=" + ts + "&wait=10";
            String body = requestHandler.sendGetRequest(url);

            if(body == null) {
                return;
            }
            JsonObject jsonObject = parser.parse(body).getAsJsonObject();
            if(jsonObject.has("failed")) {
                switch(jsonObject.get("failed").getAsString()) {
                    case "1":
                        ts = jsonObject.get("ts").getAsString();
                    break;
                    case "2":
                    case "3":
                        getLongPoolData();
                    break;
                }
                continue;
            }

            ts = jsonObject.get("ts").getAsString();

            JsonArray updates = jsonObject.get("updates").getAsJsonArray();
            updates.forEach(element -> {
                switch(element.getAsJsonObject().get("type").getAsString()) {
                    case MESSAGE_NEW:
                        JsonObject object = element.getAsJsonObject().get("object").getAsJsonObject();
                        int fromId = object.get("from_id").getAsInt();
                        if(fromId == groupId) {
                            return;
                        }
                        int peerId = object.get("peer_id").getAsInt();
                        String text = object.get("text").getAsString();
                        JsonElement payloadObject = object.get("payload");
                        Player player = playerService.load(fromId);
                        if(payloadObject == null) {
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
                        Map<String, String> payload;
                        try {
                            payload = bot.getGson().fromJson(payloadObject.getAsString(), new TypeToken<Map<String, String>>(){}.getType());
                        }catch(JsonSyntaxException e) {
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
                                bot.getCommandMap().getCommand("user_banned")
                                        .ifPresent(cmd -> cmd.execute(player, peerId, payload));
                                return;
                            }
                            Optional<Command> command = bot.getCommandMap().getCommand(commandName);
                            if(command.isPresent()) {
                                payload.put("key", Utils.encodeSignature(player.getId() + "-" + command.get().getName()));
                                command.get().execute(player, peerId, payload);
                            }else{
                                bot.getCommandMap().getCommand("not_found")
                                        .ifPresent(cmd -> cmd.execute(player, peerId, payload));
                            }
                        }else{
                            if(!player.isTutorial()) {
                                playerService.sendMessage(peerId, "Чтобы начать игру напишите в группу vk.me/kingsbot", Keyboards.getChatKeyboard());
                                return;
                            }
                            if(player.isBanned()) {
                                return;
                            }
                            String commandName = payload.get("command");
                            Optional<Command> command = bot.getCommandMap().getChatCommand(commandName);
                            if(command.isPresent()) {
                                command.get().execute(player, peerId, payload);
                            }else{
                                bot.getCommandMap().getChatCommand("info").ifPresent(cmd -> cmd.execute(player, peerId, payload));
                            }
                        }
                    break;
                }
            });

        }
    }

}
