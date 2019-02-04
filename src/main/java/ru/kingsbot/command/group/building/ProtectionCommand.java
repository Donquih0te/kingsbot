package ru.kingsbot.command.group.building;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Tower;
import ru.kingsbot.entity.building.Wall;

import java.util.List;
import java.util.Map;

public class ProtectionCommand extends Command {

    public ProtectionCommand() {
        super("protection");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("&#128304;Стены", Map.of("command", "wall")), Color.WHITE),
                        new Button(new Action("&#128508;Башни", Map.of("command", "tower")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action("&#128259;Назад", Map.of("command", "back", "next", "building")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Wall wall = player.getWall();
        Tower tower = player.getTower();
        StringBuilder sb = new StringBuilder();
        sb.append("&#128304;Стены:\n")
                .append("Уровень: ").append(wall.getLevel()).append("\n")
                .append("Количество: ").append(wall.getAmount()).append("\n\n");
        sb.append("Башни:\n")
                .append("Уровень: ").append(tower.getLevel()).append("\n")
                .append("Количество: ").append(tower.getAmount()).append("\n\n");
        bot.sendMessage(peerId, "Защита территории", keyboard);
    }
}
