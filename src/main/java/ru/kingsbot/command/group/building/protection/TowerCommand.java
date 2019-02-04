package ru.kingsbot.command.group.building.protection;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.building.Tower;

import java.util.List;
import java.util.Map;

public class TowerCommand extends Command {

    public TowerCommand() {
        super("tower");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("&#10133;Купить", Map.of("command", "buy_protection_building", "building", "tower")), Color.WHITE),
                        new Button(new Action("Улучшить&#9874;", Map.of("command", "upgrade_building", "building", "tower")), Color.WHITE)
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
        Tower tower = player.getTower();
        sb.append("&#128508;Башни:\n\n")
                .append("Уровень:").append(tower.getLevel()).append("\n")
                .append("Количество: ").append(tower.getAmount()).append("\n\n")
                .append("Купить:\n")
                .append(tower.getGoldCost()).append("&#128176;")
                .append((long)tower.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(tower.getIronCost()).append("&#9725;")
                .append((long)tower.getIronCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(tower.getStoneCost()).append("&#9935;")
                .append((long)tower.getStoneCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(tower.getWoodCost()).append("&#127795;")
                .append((long)tower.getWoodCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n")
                .append("Улучшить:\n")
                .append(tower.getGoldUpgradeCost()).append("&#128176;")
                .append((long)tower.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(tower.getIronUpgradeCost()).append("&#9725;")
                .append((long)tower.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(tower.getStoneUpgradeCost()).append("&#9935;")
                .append((long)tower.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(tower.getWoodUpgradeCost()).append("&#127795;")
                .append((long)tower.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
