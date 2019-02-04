package ru.kingsbot.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import ru.kingsbot.Bot;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.TextCommandParser;
import ru.kingsbot.entity.Player;
import ru.kingsbot.repository.PlayerRepository;
import ru.kingsbot.tutorial.Tutorial;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Log4j2
public class LongPool {

    private static final String MESSAGE_NEW = "message_new";

    private JsonParser parser;

    private Bot bot;
    private VkApiClient client;
    private PlayerRepository playerRepository;
    private TextCommandParser commandParser;
    private String key;
    private String server;
    private String ts;
    private String token;
    private String version;
    private Integer groupId;
    //private final Integer GROUP_ID = 123281395;

    public LongPool(Bot bot, VkApiClient client, String token, String version, Integer groupId) {
        this.bot = bot;
        this.client = client;
        this.token = token;
        this.version = version;
        this.groupId = groupId;
        parser = new JsonParser();
        playerRepository = bot.getPlayerRepository();
        commandParser = new TextCommandParser();
        getLongPoolData();
    }

    private void getLongPoolData() {
        ApiRequest request = ApiRequest.newApiRequest()
                .method("groups.getLongPollServer")
                .param("group_id", groupId)
                .param("access_token", token)
                .param("v", version)
                .build();
        String response = client.request(request);
        if(response == null) {
            return;
        }

        JsonObject element = parser.parse(response).getAsJsonObject();
        if(element.has("error")) {
            log.error("ApiRequest error", element.toString());
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
            HttpGet get = new HttpGet(url);

            String body = null;
            HttpResponse response = null;
            try {
                response = client.getHttpClient().execute(get, null).get();
            }catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage(), e);
            }
            if(response == null) {
                return;
            }
            try {
                body = EntityUtils.toString(response.getEntity(), "UTF-8");
            }catch(IOException e) {
                log.error(e.getMessage(), e);
            }
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
                        Player player = playerRepository.load(fromId);
                        if(payloadObject == null) {
                            if(peerId == fromId) {
                                if(!player.isTutorial()) {
                                    Tutorial tutorial = new Tutorial(player);
                                    tutorial.start();
                                    return;
                                }
                            }else{
                                if(!player.isTutorial()) {
                                    bot.sendMessage(peerId, "Чтобы начать игру напишите в группу vk.me/kingsbot", bot.getChatKeyboard());
                                }
                            }
                            commandParser.parse(peerId, fromId, text);
                            return;
                        }
                        Map<String, String> payload = bot.getGson().fromJson(payloadObject.getAsString(), new TypeToken<Map<String, String>>(){}.getType());
                        if(peerId == fromId) {
                            if(!player.isTutorial()) {
                                Tutorial tutorial = new Tutorial(player);
                                tutorial.start();
                                return;
                            }
                            if(payload.isEmpty()) {
                                bot.sendMessage(peerId, "Для игры используйте кнопки", bot.getKeyboard());
                                return;
                            }
                            String commandName = payload.get("command");
                            if(player.isBanned()) {
                                bot.getCommandMap().getCommand("user_banned").ifPresent(cmd -> cmd.execute(player, peerId, payload));
                                return;
                            }
                            Optional<Command> command = bot.getCommandMap().getCommand(commandName);
                            if(command.isPresent()) {
                                command.get().execute(player, peerId, payload);
                            }else{
                                bot.getCommandMap().getCommand("not_found").ifPresent(cmd -> cmd.execute(player, peerId, payload));
                            }
                        }else{
                            if(!player.isTutorial()) {
                                bot.sendMessage(peerId, "Чтобы начать игру напишите в группу vk.me/kingsbot", bot.getChatKeyboard());
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
