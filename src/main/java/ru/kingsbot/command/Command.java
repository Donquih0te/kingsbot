package ru.kingsbot.command;

import lombok.Getter;
import ru.kingsbot.Bot;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.entity.Player;

import java.util.Map;

public abstract class Command {

    @Getter
    protected String name;
    protected Keyboard keyboard;
    protected Bot bot;

    public Command(String name) {
        this.name = name;
        bot = Bot.getInstance();
    }

    public abstract void execute(Player player, Integer peerId, Map<String, String> payload);

}
