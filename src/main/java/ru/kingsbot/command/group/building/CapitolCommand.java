package ru.kingsbot.command.group.building;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class CapitolCommand extends Command {

    public CapitolCommand() {
        super("capitol");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label("Улучшить" + Emoji.CITIZEN)
                                .payload("command", "upgrade_building")
                                .payload("building", "capitol")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.WORKERS + "Рабочий")
                                .payload("command", "citizen")
                                .color(Color.WHITE)
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
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        Capitol capitol = player.getCapitol();
        Storage storage = player.getStorage();
        Citizen citizen = capitol.getCitizen();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.CAPITOL).append("Капитолий:\n")
                .append(Emoji.LEVEL).append("Уровень: ").append(capitol.getLevel()).append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(capitol.getGoldUpgradeCost())).append(Emoji.GOLD)
                .append(capitol.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(capitol.getIronUpgradeCost())).append(Emoji.IRON)
                .append(capitol.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(capitol.getStoneUpgradeCost())).append(Emoji.STONE)
                .append(capitol.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(capitol.getWoodUpgradeCost())).append(Emoji.WOOD)
                .append(capitol.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
