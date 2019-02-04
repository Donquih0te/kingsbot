package ru.kingsbot.command.group.building;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.List;
import java.util.Map;

public class CapitolCommand extends Command {

    public CapitolCommand() {
        super("capitol");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("Улучшить&#9874;", Map.of("command", "upgrade_building", "building", "capitol")), Color.WHITE),
                        new Button(new Action("&#9937;Рабочий", Map.of("command", "citizen")), Color.WHITE)
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
        Capitol capitol = player.getCapitol();
        Storage storage = player.getStorage();
        Citizen citizen = capitol.getCitizen();
        StringBuilder sb = new StringBuilder("&#128331;Капитолий\n\n");
        sb.append("Уровень: ").append(capitol.getLevel()).append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(capitol.getGoldUpgradeCost())).append("&#128176;")
                .append(capitol.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(capitol.getIronUpgradeCost())).append("&#9725;")
                .append(capitol.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(capitol.getStoneUpgradeCost())).append("&#9935;")
                .append(capitol.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(capitol.getWoodUpgradeCost())).append("&#127795;")
                .append(capitol.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
