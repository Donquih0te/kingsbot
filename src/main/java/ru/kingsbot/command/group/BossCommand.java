package ru.kingsbot.command.group;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Map;

public class BossCommand extends Command {

    public BossCommand() {
        super("boss");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("Криг", Map.of("command", "boss_type", "boss", "krieg")), Color.WHITE),
                        new Button(new Action("Арлонг", Map.of("command", "boss_type", "boss", "arlong")), Color.WHITE),
                        new Button(new Action("Крокодил", Map.of("command", "boss_type", "boss", "crocodile")), Color.WHITE)
                ))
                .row(List.of(new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)))
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        bot.sendMessage(peerId, "Боссы", keyboard);
    }
}
