package ru.kingsbot.command.group;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class BossCommand extends Command {

    public BossCommand() {
        super("boss");
        keyboard = Keyboard.newKeyboard()
                .withRowButtons(List.of(
                        Button.newButton()
                                .label(Emoji.KRIEG + "Криг")
                                .payload("command", "boss_type")
                                .payload("boss", "krieg")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.ARLONG + "Арлонг")
                                .payload("command", "boss_type")
                                .payload("boss", "arlong")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.CROCODILE + "Крокодил")
                                .payload("command", "boss_type")
                                .payload("boss", "crocodile")
                                .color(Color.WHITE)
                                .create()
                ))
                .withRowButtons(List.of(
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .create();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        playerService.sendMessage(peerId, "Боссы", keyboard);
    }
}
