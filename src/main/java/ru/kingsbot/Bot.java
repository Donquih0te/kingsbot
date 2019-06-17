package ru.kingsbot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import ru.kingsbot.client.LongPool;
import ru.kingsbot.client.TransportClient;
import ru.kingsbot.command.CommandMap;
import ru.kingsbot.command.keyboard.Keyboards;
import ru.kingsbot.game.attack.BossAttackMap;
import ru.kingsbot.game.boss.BossMap;
import ru.kingsbot.service.ConversationService;
import ru.kingsbot.service.DonateService;
import ru.kingsbot.service.MarketService;
import ru.kingsbot.service.PlayerService;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Log4j2
public class Bot {

    private static final String API_VERSION = "5.95";

    private static volatile Bot instance;

    @Getter
    private TransportClient transportClient;
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

    @Getter
    private String dataPath;

    @Getter
    private Integer groupId;

    public Bot(String dataPath) {
        instance = this;
        this.dataPath = dataPath;

        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        // Checking the configuration files. If them does not exists then create default
        try {
            this.initPropertyFile("application.properties");
            this.initPropertyFile("hibernate.properties");
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

        // Initializing and starting the http-request executor
        this.initTransportClient();

        Keyboards.init();

        // Creating the database connection
        HibernateUtil.build();
        playerService = new PlayerService(gson, transportClient);
        marketService = new MarketService();
        //donateService = new DonateService();
        conversationService = new ConversationService();

        longPool = new LongPool(this, transportClient, groupId);

        bossMap = new BossMap();
        bossAttackMap = new BossAttackMap();
        commandMap = new CommandMap();
    }

    public static Bot getInstance() {
        return instance;
    }

    public void run() {
        commandMap.loadDefaultCommands();
        transportClient.start();
        longPool.run();
    }

    public void shutdown() {
        transportClient.close();
    }

    private void initPropertyFile(String fileName) throws FileNotFoundException {
        Path appPropPath = Paths.get(dataPath + fileName);
        if(!Files.exists(appPropPath)) {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            if(inputStream == null) {
                throw new FileNotFoundException(String.format("The %s file doesn't exists in classpath", fileName));
            }
            try {
                Files.copy(inputStream, appPropPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void initTransportClient() {
        String appProp = "application.properties";
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(new File(dataPath + appProp)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        groupId = Utils.parseInt(prop.getProperty("group_id"));

        String token = prop.getProperty("token");

        if(token == null) {
            throw new RuntimeException("Specify a token in the " + appProp);
        }

        transportClient = new TransportClient(API_VERSION, token);
    }

}
