package ru.kingsbot.command.group.building;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Tower;
import ru.kingsbot.entity.building.Wall;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class ProtectionCommand extends Command {

    public ProtectionCommand() {
        super("protection");
        keyboard = Keyboard.newKeyboard()
                .withRowButtons(List.of(
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
                .withRowButtons(List.of(
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
                .create();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        Wall wall = player.getWall();
        Tower tower = player.getTower();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.WALL).append("Стены:\n")
                .append(Emoji.LEVEL).append("Уровень: ").append(wall.getLevel()).append("\n")
                .append("Количество: ").append(wall.getAmount()).append("\n\n");
        sb.append(Emoji.TOWER).append("Башни:\n")
                .append(Emoji.LEVEL).append("Уровень: ").append(tower.getLevel()).append("\n")
                .append("Количество: ").append(tower.getAmount()).append("\n\n");
        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
