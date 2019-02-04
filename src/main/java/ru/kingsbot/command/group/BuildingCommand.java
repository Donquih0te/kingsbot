package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Map;

public class BuildingCommand extends Command {

    public BuildingCommand() {
        super("building");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.CAPITOL + "Капитолий", Map.of("command", "capitol")), Color.WHITE),
                        new Button(new Action(Emoji.STORAGE + "Склад", Map.of("command", "storage")), Color.WHITE),
                        new Button(new Action(Emoji.ARMORY + "Казармы", Map.of("command", "armory")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.PROTECTION + "Защита", Map.of("command", "protection")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        String message = "Строй зданий, улучшай их и открой все их тайны";
        bot.sendMessage(peerId, message, keyboard);
    }

}
