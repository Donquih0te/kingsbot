package ru.kingsbot;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import ru.kingsbot.api.LongPool;
import ru.kingsbot.api.VkApiClient;
import ru.kingsbot.api.keyboard.Keyboards;
import ru.kingsbot.attack.BossAttackMap;
import ru.kingsbot.boss.BossMap;
import ru.kingsbot.command.CommandMap;
import ru.kingsbot.service.*;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class Bot {

    private static final String PROPERTIES_FILE = "application.properties";
    private static volatile Bot instance;

    @Getter
    private VkApiClient vkApiClient;
    @Getter
    private RequestHandler requestHandler;
    @Getter
    private PlayerService playerService;
    @Getter
    private MarketService marketService;
    @Getter
    private DonateService donateService;
    @Getter
    private ConversationService conversationService;

    @Getter
    private LongPool longPool;
    @Getter
    private CommandMap commandMap;
    @Getter
    private BossMap bossMap;
    @Getter
    private BossAttackMap bossAttackMap;

    @Getter
    private Gson gson;

    private String token;
    private String version;
    private Integer groupId;

    public Bot() throws FileNotFoundException {
        instance = this;
        gson = new Gson();
        initProperties();
        HibernateUtil.build();
        
        vkApiClient = new VkApiClient();
        requestHandler = new RequestHandler(vkApiClient, token, version);

        playerService = new PlayerService(gson, requestHandler);
        marketService = new MarketService();
        donateService = new DonateService();
        conversationService = new ConversationService();

        longPool = new LongPool(this, requestHandler, groupId);
        bossMap = new BossMap();
        bossAttackMap = new BossAttackMap();
        commandMap = new CommandMap();
    }

    public static Bot getInstance() {
        return instance;
    }

    public void run() {
        Keyboards.init();
        longPool.run();
    }

    public void shutdown() {
        vkApiClient.close();
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
            groupId = Utils.parseInt(properties.getProperty("group_id"));
        }catch(IOException e) {
            log.error("Failed to load properties", e);
        }
    }

}
