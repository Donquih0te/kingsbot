package ru.kingsbot;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import ru.kingsbot.api.ApiRequest;
import ru.kingsbot.api.LongPool;
import ru.kingsbot.api.VkApiClient;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.attack.BossAttackMap;
import ru.kingsbot.boss.BossMap;
import ru.kingsbot.command.CommandMap;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.market.Market;
import ru.kingsbot.repository.ConversationRepository;
import ru.kingsbot.repository.DonateRepository;
import ru.kingsbot.repository.MarketRepository;
import ru.kingsbot.repository.PlayerRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

@Log4j2
public class Bot {

    private static final Random RANDOM = new Random();
    private static final String PROPERTIES_FILE = "application.properties";

    private static volatile Bot instance;

    private String token;
    private String version;
    private Integer groupId;

    @Getter
    private VkApiClient vkApiClient;
    @Getter
    private LongPool longPool;
    @Getter
    private CommandMap commandMap;
    @Getter
    private Keyboard keyboard;
    @Getter
    private Keyboard chatKeyboard;
    @Getter
    private volatile PlayerRepository playerRepository;
    @Getter
    private MarketRepository marketRepository;
    @Getter
    private ConversationRepository conversationRepository;
    @Getter
    private DonateRepository donateRepository;
    @Getter
    private BossMap bossMap;
    @Getter
    private BossAttackMap bossAttackMap;

    @Getter
    private Gson gson;

    public Bot() throws FileNotFoundException {
        instance = this;
        initRepositories();
        initProperties();
        vkApiClient = new VkApiClient();
        longPool = new LongPool(this, vkApiClient, token, version, groupId);
        bossMap = new BossMap();
        bossAttackMap = new BossAttackMap();
        commandMap = new CommandMap();
        gson = new Gson();

        generateKeyboards();
    }

    public static Bot getInstance() {
        return instance;
    }

    public void run() {
        longPool.run();
    }

    public void shutdown() {
        vkApiClient.close();
    }

    private void initRepositories() {
        playerRepository = new PlayerRepository();
        marketRepository = new MarketRepository();
        conversationRepository = new ConversationRepository();
        donateRepository = new DonateRepository();
    }

    private void initProperties() throws FileNotFoundException {
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        if(inputStream == null) {
            throw new FileNotFoundException(PROPERTIES_FILE + " not found");
        }
        try{
            Properties properties = new Properties();
            properties.load(inputStream);
            token = properties.getProperty("token");
            version = properties.getProperty("version");
            groupId = Integer.parseInt(properties.getProperty("group_id"));
        }catch(IOException e) {
            log.error("Failed to load properties", e);
        }
    }

    private void generateKeyboards() {
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.INFO + "Инфо", Map.of("command", "info")), Color.GREEN),
                        new Button(new Action(Emoji.BUILDINGS + "Строения", Map.of("command", "building")), Color.WHITE),
                        new Button(new Action(Emoji.RESOURCES + "Ресурсы", Map.of("command", "resource")), Color.WHITE)
                    )
                )
                .row(List.of(
//                        new Button(new Action(Emoji.HEROES + "Герои", Map.of("command", "hero")), Color.WHITE),
                        new Button(new Action(Emoji.AGE + "Эпоха", Map.of("command", "age")), Color.WHITE),
                        new Button(new Action(Emoji.ARMY + "Армия", Map.of("command", "army")), Color.WHITE),
                        new Button(new Action(Emoji.CLAN + "Клан", Map.of("command", "clan")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.MARKET + "Рынок", Map.of("command", "market")), Color.WHITE),
                        new Button(new Action(Emoji.BOSS + "Босс", Map.of("command", "boss")), Color.WHITE),
                        new Button(new Action(Emoji.TOP + "Топ", Map.of("command", "top")), Color.WHITE)
                    )
                )
                .row(List.of(
                        //new Button(new Action("Донат", Map.of("command", "donat")), Color.WHITE),
                        //new Button(new Action("Настройки", Map.of("command", "settings")), Color.WHITE),
                        new Button(new Action("Помощь", Map.of("command", "help")), Color.GREEN)
                        )
                )
                .build();

        chatKeyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.INFO + "Инфо", Map.of("command", "info")), Color.GREEN),
                        new Button(new Action(Emoji.ROCK_THROWER + "Охота", Map.of("command", "hunting")), Color.WHITE),
                        new Button(new Action(Emoji.ARMY + "Набег", Map.of("command", "raid")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.GOLD + "Дань", Map.of("command", "tribute")), Color.WHITE),
                        new Button(new Action(Emoji.TOP + "Топ", Map.of("command", "top")), Color.WHITE)
                    )
                )
                .build();
    }

    public Market getMarket() {
        return marketRepository.load(1L);
    }

    public void sendMessage(Integer peerId, String message, Keyboard keyboard) {
        sendMessage(List.of(peerId), message, keyboard);
    }

    public void sendMessage(List<Integer> peerIds, String message, Keyboard keyboard) {
        String peerId = peerIds.stream().map(Object::toString).collect(Collectors.joining(","));
        ApiRequest.Builder builder = ApiRequest.newApiRequest()
                .method("messages.send")
                .param("random_id", RANDOM.nextInt(999_999))
                .param("peer_id", peerId)
                .param("message", message)
                .param("access_token", token)
                .param("v", version);

        if(keyboard != null) {
            builder.param("keyboard", gson.toJson(keyboard));
        }
        vkApiClient.request(builder.build());
    }

    public void setName(Player player) {
        ApiRequest request = ApiRequest.newApiRequest()
                .method("users.get")
                .param("user_ids", player.getId())
                .param("access_token", token)
                .param("v", version)
                .build();

        String result = vkApiClient.request(request);

        JsonObject json = new JsonParser().parse(result).getAsJsonObject();
        if(!json.has("response")) {
            log.error("Impossible to set player name", result);
            return;
        }
        JsonArray response = json.get("response").getAsJsonArray();

        JsonObject item = response.get(0).getAsJsonObject();
        player.setFirstName(item.get("first_name").getAsString());
        player.setLastName(item.get("last_name").getAsString());
    }

}
