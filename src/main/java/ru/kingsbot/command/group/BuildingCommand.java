package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class BuildingCommand extends Command {

    public BuildingCommand() {
        super("building");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.CAPITOL + "Капитолий")
                                .payload("command", "capitol")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.STORAGE + "Склад")
                                .payload("command", "storage")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.ARMORY + "Казармы")
                                .payload("command", "armory")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.PROTECTION + "Защита")
                                .payload("command", "protection")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        String message = "Строй зданий, улучшай их и открой все их тайны";
        playerService.sendMessage(peerId, message, keyboard);
    }

}
