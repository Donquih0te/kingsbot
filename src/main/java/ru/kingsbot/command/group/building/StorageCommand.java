package ru.kingsbot.command.group.building;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class StorageCommand extends Command {

    public StorageCommand() {
        super("storage");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.CITIZEN + "Улучшить")
                                .payload("command", "upgrade_building")
                                .payload("building", "storage")
                                .color(Color.GREEN)
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
                        )
                )
                .build();
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        sb.append(Emoji.STORAGE).append("Склад:\n\n")
                .append("Уровень: ").append(storage.getLevel()).append("\n\n")
                .append("Вместимость: ")
                .append(NumberConverter.toString(storage.getMaxGold())).append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(storage.getGoldUpgradeCost())).append(Emoji.GOLD)
                .append((long)storage.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(storage.getIronUpgradeCost())).append(Emoji.IRON)
                .append((long)storage.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(storage.getStoneUpgradeCost())).append(Emoji.STONE)
                .append((long)storage.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(storage.getWoodUpgradeCost())).append(Emoji.WOOD)
                .append((long)storage.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
