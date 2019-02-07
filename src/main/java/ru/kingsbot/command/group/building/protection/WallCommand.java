package ru.kingsbot.command.group.building.protection;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.building.Wall;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WallCommand extends Command {

    public WallCommand() {
        super("wall");
        keyboard = Keyboard.newKeyboard()
                .row(new LinkedList<>(List.of(
                        Button.newButton()
                                .label(Emoji.PLUS + "Купить")
                                .payload("command", "buy_protection_building")
                                .payload("building", "wall")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Улучшить" + Emoji.CITIZEN)
                                .payload("command", "upgrade_building")
                                .payload("building", "wall")
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
        Wall wall = player.getWall();
        sb.append(Emoji.WALL).append("Стены:\n")
                .append(Emoji.LEVEL).append("Уровень: ").append(wall.getLevel()).append("\n")
                .append("Количество: ").append(wall.getAmount()).append("\n\n")
                .append("Купить:\n")
                .append(NumberConverter.toString(wall.getGoldCost())).append(Emoji.GOLD)
                .append(wall.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(wall.getIronCost())).append(Emoji.IRON)
                .append(wall.getIronCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(wall.getStoneCost())).append(Emoji.STONE)
                .append(wall.getStoneCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(wall.getWoodCost())).append(Emoji.WOOD)
                .append(wall.getWoodCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(wall.getGoldUpgradeCost())).append(Emoji.GOLD)
                .append(wall.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(wall.getIronUpgradeCost())).append(Emoji.IRON)
                .append(wall.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(wall.getStoneUpgradeCost())).append(Emoji.STONE)
                .append(wall.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(wall.getWoodUpgradeCost())).append(Emoji.WOOD)
                .append(wall.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
