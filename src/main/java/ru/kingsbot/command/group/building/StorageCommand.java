package ru.kingsbot.command.group.building;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.List;
import java.util.Map;

public class StorageCommand extends Command {

    public StorageCommand() {
        super("storage");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("Улучшить&#9874;", Map.of("command", "upgrade_building", "building", "storage")), Color.GREEN)
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
        sb.append("Склад:\n\n")
                .append("Уровень: ").append(storage.getLevel()).append("\n\n")
                .append("Вместимость: ")
                .append(NumberConverter.toString(storage.getMaxGold())).append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(storage.getGoldUpgradeCost())).append("&#128176;")
                .append((long)storage.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(storage.getIronUpgradeCost())).append("&#9725;")
                .append((long)storage.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(storage.getStoneUpgradeCost())).append("&#9935;")
                .append((long)storage.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(storage.getWoodUpgradeCost())).append("&#127795;")
                .append((long)storage.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
