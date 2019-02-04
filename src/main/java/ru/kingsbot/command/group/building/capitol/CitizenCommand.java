package ru.kingsbot.command.group.building.capitol;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.List;
import java.util.Map;

public class CitizenCommand extends Command {

    public CitizenCommand() {
        super("citizen");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("&#10133;Создать", Map.of("command", "create_citizen")), Color.WHITE),
                        new Button(new Action("&#9851;Улучшить", Map.of("command", "upgrade_citizen")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action("&#128259;Назад", Map.of("command", "back", "next", "capitol")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Citizen citizen = player.getCapitol().getCitizen();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder();
        sb.append("&#9937;Рабочий:\n\n")
                .append("Уровень: ").append(citizen.getLevel()).append("\n\n")
                .append("Скорость добычи: ")
                .append(NumberConverter.toString(citizen.getFoodPerMinute())).append("&#127830; в минуту\n\n")
                .append("Создать:\n")
                .append(NumberConverter.toString(citizen.getFoodCost())).append("&#127830;")
                .append(citizen.getFoodCost() <= storage.getFood() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(citizen.getGoldCost())).append("&#128176;")
                .append(citizen.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(citizen.getFoodUpgradeCost())).append("&#127830;")
                .append(storage.getFood() - citizen.getFoodUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(citizen.getGoldUpgradeCost())).append("&#128176;")
                .append(storage.getGold() - citizen.getGoldUpgradeCost() > 0 ? " ✔" : " ❌").append("\n\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
