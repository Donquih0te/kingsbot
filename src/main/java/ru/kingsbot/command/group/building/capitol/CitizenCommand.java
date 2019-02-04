package ru.kingsbot.command.group.building.capitol;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CitizenCommand extends Command {

    public CitizenCommand() {
        super("citizen");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        keyboard = Keyboard.newKeyboard()
                .row(new LinkedList<>(List.of(
                        Button.newButton()
                                .label(Emoji.PLUS + "Создать")
                                .payload("command", "create_citizen")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.UPGRADE + "Улучшить")
                                .payload("command", "upgrade_citizen")
                                .color(Color.WHITE)
                                .create()
                        ))
                )
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "capitol")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .build();
        Citizen citizen = player.getCapitol().getCitizen();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.WORKERS).append("Рабочий:\n\n")
                .append("Уровень: ").append(citizen.getLevel()).append("\n\n")
                .append("Скорость добычи: ")
                .append(NumberConverter.toString(citizen.getFoodPerMinute())).append(Emoji.FOOD).append(" в минуту\n\n")
                .append("Создать:\n")
                .append(NumberConverter.toString(citizen.getFoodCost())).append(Emoji.FOOD)
                .append(citizen.getFoodCost() <= storage.getFood() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(citizen.getGoldCost())).append(Emoji.GOLD)
                .append(citizen.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(citizen.getFoodUpgradeCost())).append(Emoji.FOOD)
                .append(storage.getFood() - citizen.getFoodUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(citizen.getGoldUpgradeCost())).append(Emoji.GOLD)
                .append(storage.getGold() - citizen.getGoldUpgradeCost() > 0 ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
