package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.List;
import java.util.Map;

public class RockThrowerCommand extends Command {

    public RockThrowerCommand() {
        super("rock_thrower");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("&#10133;Купить", Map.of("command", "buy_warrior", "warrior", "rock_thrower")), Color.WHITE),
                        new Button(new Action("Улучшить&#9874;", Map.of("command", "upgrade_warrior", "warrior", "rock_thrower")), Color.WHITE)
                        )
                )
                .row(List.of(
                        new Button(new Action("&#128259;Назад", Map.of("command", "back", "next", "armory")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Warrior rockThrower = player.getArmy().getRockThrower();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder("Метатель камней\n\n");
        sb.append("Уровень: ").append(rockThrower.getLevel()).append("\n")
                .append("Колличество: ").append(NumberConverter.toString(rockThrower.getAmount())).append("\n")
                .append("HP: ").append(rockThrower.getHealth()).append("&#129505;\n")
                .append("Атака: ").append(rockThrower.getAttack()).append("&#9876;\n")
                .append("Защита: ").append(rockThrower.getArmor()).append("&#128737;\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(rockThrower.getFoodUpgradeCost())).append("&#127830;")
                .append(rockThrower.getFoodUpgradeCost() <= storage.getFood() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(rockThrower.getGoldUpgradeCost())).append("&#128176;")
                .append(rockThrower.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(rockThrower.getIronUpgradeCost())).append("&#9725;")
                .append(rockThrower.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n\n")
                .append("Купить:\n")
                .append("100 воинов за ").append(rockThrower.getFoodCost() * 100).append("&#127830; ")
                .append(rockThrower.getGoldCost() * 100).append("&#128176; ")
                .append(rockThrower.getIronCost() * 100).append("&#9725;\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
