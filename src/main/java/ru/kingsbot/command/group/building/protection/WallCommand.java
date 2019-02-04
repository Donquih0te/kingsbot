package ru.kingsbot.command.group.building.protection;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.building.Wall;

import java.util.List;
import java.util.Map;

public class WallCommand extends Command {

    public WallCommand() {
        super("wall");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("&#10133;Купить", Map.of("command", "buy_protection_building", "building", "wall")), Color.WHITE),
                        new Button(new Action("Улучшить&#9874;", Map.of("command", "upgrade_building", "building", "wall")), Color.WHITE)
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
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        Wall wall = player.getWall();
        sb.append("&#128304;Стены:\n\n")
                .append("Уровень:").append(wall.getLevel()).append("\n")
                .append("Количество: ").append(wall.getAmount()).append("\n\n")
                .append("Купить:\n")
                .append("Золото: ").append(wall.getGoldCost()).append("&#128176;")
                .append((long)wall.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append("Железо: ").append(wall.getIronCost()).append("&#9725;")
                .append((long)wall.getIronCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append("Камень: ").append(wall.getStoneCost()).append("&#9935;")
                .append((long)wall.getStoneCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append("Дерево: ").append(wall.getWoodCost()).append("&#127795;")
                .append((long)wall.getWoodCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n")
                .append("Улучшить:\n")
                .append("Золото: ").append(wall.getGoldUpgradeCost()).append("&#128176;")
                .append((long)wall.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append("Железо: ").append(wall.getIronUpgradeCost()).append("&#9725;")
                .append((long)wall.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append("Камень: ").append(wall.getStoneUpgradeCost()).append("&#9935;")
                .append((long)wall.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append("Дерево: ").append(wall.getWoodUpgradeCost()).append("&#127795;")
                .append((long)wall.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
