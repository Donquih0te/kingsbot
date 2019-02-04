package ru.kingsbot.command.group.building.protection;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.building.Tower;
import ru.kingsbot.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TowerCommand extends Command {

    public TowerCommand() {
        super("tower");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        keyboard = Keyboard.newKeyboard()
                .row(new LinkedList<>(List.of(
                        Button.newButton()
                                .label(Emoji.PLUS + "Купить")
                                .payload("command", "buy_protection_building")
                                .payload("building", "tower")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Улучшить" + Emoji.CITIZEN)
                                .payload("command", "upgrade_building")
                                .payload("building", "tower")
                                .color(Color.WHITE)
                                .create()
                        ))
                )
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
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        Tower tower = player.getTower();
        sb.append(Emoji.TOWER).append("Башни:\n\n")
                .append("Уровень:").append(tower.getLevel()).append("\n")
                .append("Количество: ").append(tower.getAmount()).append("\n\n")
                .append("Купить:\n")
                .append(tower.getGoldCost()).append(Emoji.GOLD)
                .append((long)tower.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(tower.getIronCost()).append(Emoji.IRON)
                .append((long)tower.getIronCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(tower.getStoneCost()).append(Emoji.STONE)
                .append((long)tower.getStoneCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(tower.getWoodCost()).append(Emoji.WOOD)
                .append((long)tower.getWoodCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n")
                .append("Улучшить:\n")
                .append(tower.getGoldUpgradeCost()).append(Emoji.GOLD)
                .append((long)tower.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(tower.getIronUpgradeCost()).append(Emoji.IRON)
                .append((long)tower.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(tower.getStoneUpgradeCost()).append(Emoji.STONE)
                .append((long)tower.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(tower.getWoodUpgradeCost()).append(Emoji.WOOD)
                .append((long)tower.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
