package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RockThrowerCommand extends Command {

    public RockThrowerCommand() {
        super("rock_thrower");
        keyboard = Keyboard.newKeyboard()
                .row(new LinkedList<>(List.of(
                        Button.newButton()
                                .label(Emoji.PLUS + "Создать")
                                .payload("command", "buy_warrior")
                                .payload("warrior", "rock_thrower")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.UPGRADE + "Улучшить")
                                .payload("command", "upgrade_warrior")
                                .payload("warrior", "rock_thrower")
                                .color(Color.WHITE)
                                .create()
                        ))
                )
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "armory")
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
        Warrior rockThrower = player.getArmy().getRockThrower();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.ROCK_THROWER).append("Метатель камней\n")
                .append(Emoji.LEVEL).append("Уровень: ").append(rockThrower.getLevel()).append("\n")
                .append("Колличество: ").append(NumberConverter.toString(rockThrower.getAmount())).append("\n")
                .append("Атака: ").append(rockThrower.getAttack()).append(Emoji.CLUBMAN).append("\n")
                .append("Защита: ").append(rockThrower.getArmor()).append(Emoji.PROTECTION).append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(rockThrower.getFoodUpgradeCost())).append(Emoji.FOOD)
                .append(rockThrower.getFoodUpgradeCost() <= storage.getFood() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(rockThrower.getGoldUpgradeCost())).append(Emoji.GOLD)
                .append(rockThrower.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(rockThrower.getIronUpgradeCost())).append(Emoji.IRON)
                .append(rockThrower.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n\n")
                .append("Купить:\n")
                .append("100 воинов за ").append(rockThrower.getFoodCost() * 100).append(Emoji.FOOD).append("  ")
                .append(rockThrower.getGoldCost() * 100).append(Emoji.GOLD).append("  ")
                .append(rockThrower.getIronCost() * 100).append(Emoji.IRON).append("\n");

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
