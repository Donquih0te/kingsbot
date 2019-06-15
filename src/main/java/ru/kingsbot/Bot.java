package ru.kingsbot;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.config.Property;
import ru.kingsbot.api.LongPool;
import ru.kingsbot.api.TransportClient;
import ru.kingsbot.api.keyboard.Keyboards;
import ru.kingsbot.attack.BossAttackMap;
import ru.kingsbot.boss.BossMap;
import ru.kingsbot.command.CommandMap;
import ru.kingsbot.service.*;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

        gson = new Gson();

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
        transportClient.start();

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
        Keyboards.init();
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
                List<String> lines = Files.readAllLines(appPropPath);
                Files.createFile(appPropPath);
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

        groupId = Utils.parseInt(prop.getProperty("groupId"));

        String token = prop.getProperty("token");

        if(token == null) {
            throw new RuntimeException("Specify a token in the " + appProp);
        }

        transportClient = new TransportClient(API_VERSION, token);
    }

}
