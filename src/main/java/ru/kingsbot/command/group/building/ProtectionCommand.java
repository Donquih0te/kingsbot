package ru.kingsbot.command.group.building;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Tower;
import ru.kingsbot.entity.building.Wall;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class ProtectionCommand extends Command {

    public ProtectionCommand() {
        super("protection");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.WALL + "Стены")
                                .payload("command", "wall")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.TOWER + "Башни")
                                .payload("command", "tower")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "building")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .build();
        Wall wall = player.getWall();
        Tower tower = player.getTower();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.WALL).append("Стены:\n")
                .append("Уровень: ").append(wall.getLevel()).append("\n")
                .append("Количество: ").append(wall.getAmount()).append("\n\n");
        sb.append(Emoji.TOWER).append("Башни:\n")
                .append("Уровень: ").append(tower.getLevel()).append("\n")
                .append("Количество: ").append(tower.getAmount()).append("\n\n");
        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
