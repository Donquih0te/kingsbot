package ru.kingsbot.command.group;

import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class BossCommand extends Command {

    public BossCommand() {
        super("boss");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label("Криг")
                                .payload("command", "boss_type")
                                .payload("boss", "krieg")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Арлонг")
                                .payload("command", "boss_type")
                                .payload("boss", "arlong")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Крокодил")
                                .payload("command", "boss_type")
                                .payload("boss", "crocodile")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
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
        playerService.sendMessage(peerId, "Боссы", keyboard);
    }
}
