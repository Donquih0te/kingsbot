package ru.kingsbot.command;

import lombok.Getter;
import ru.kingsbot.Bot;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.service.MarketService;
import ru.kingsbot.service.PlayerService;

import java.util.Map;

public abstract class Command {

    @Getter
    protected String name;
    protected Keyboard keyboard;

    protected Bot bot;
    protected PlayerService playerService;
    protected MarketService marketService;

    public Command(String name) {
        this.name = name;
        bot = Bot.getInstance();
        playerService = bot.getPlayerService();
        marketService = bot.getMarketService();
    }

    public abstract void execute(Player player, Integer peerId, Map<String, String> payload);

}
