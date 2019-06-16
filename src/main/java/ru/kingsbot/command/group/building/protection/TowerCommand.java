package ru.kingsbot.command.group.building.protection;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.building.Tower;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TowerCommand extends Command {

    public TowerCommand() {
        super("tower");
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
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        Tower tower = player.getTower();
        sb.append(Emoji.TOWER).append("Башни:\n")
                .append(Emoji.LEVEL).append("Уровень: ").append(tower.getLevel()).append("\n")
                .append("Количество: ").append(tower.getAmount()).append("\n\n")
                .append("Купить:\n")
                .append(NumberConverter.toString(tower.getGoldCost())).append(Emoji.GOLD)
                .append(tower.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(tower.getIronCost())).append(Emoji.IRON)
                .append(tower.getIronCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(tower.getStoneCost())).append(Emoji.STONE)
                .append(tower.getStoneCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(tower.getWoodCost())).append(Emoji.WOOD)
                .append(tower.getWoodCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(tower.getGoldUpgradeCost())).append(Emoji.GOLD)
                .append(tower.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(tower.getIronUpgradeCost())).append(Emoji.IRON)
                .append(tower.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(tower.getStoneUpgradeCost())).append(Emoji.STONE)
                .append(tower.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(tower.getWoodUpgradeCost())).append(Emoji.WOOD)
                .append(tower.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
