package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClubmanCommand extends Command {

    public ClubmanCommand() {
        super("clubman");
        keyboard = Keyboard.newKeyboard()
                .row(new LinkedList<>(List.of(
                        Button.newButton()
                                .label(Emoji.PLUS + "Создать")
                                .payload("command", "buy_warrior")
                                .payload("warrior", "clubman")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.UPGRADE + "Улучшить")
                                .payload("command", "upgrade_warrior")
                                .payload("warrior", "clubman")
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
        Warrior clubman = player.getArmy().getClubman();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.CLUBMAN).append("Воин с дубиной\n")
                .append(Emoji.LEVEL).append("Уровень: ").append(clubman.getLevel()).append("\n")
                .append("Колличество: ").append(NumberConverter.toString(clubman.getAmount())).append("\n")
                .append("Атака: ").append(clubman.getAttack()).append(Emoji.CLUBMAN).append("\n")
                .append("Защита: ").append(clubman.getArmor()).append(Emoji.PROTECTION).append("\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(clubman.getFoodUpgradeCost())).append(Emoji.FOOD)
                .append(clubman.getFoodUpgradeCost() <= storage.getFood() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(clubman.getGoldUpgradeCost())).append(Emoji.GOLD)
                .append(clubman.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(clubman.getIronUpgradeCost())).append(Emoji.IRON)
                .append(clubman.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n\n")
                .append("Купить:\n")
                .append("100 воинов за ").append(clubman.getFoodCost() * 100).append(Emoji.FOOD).append("  ")
                .append(clubman.getGoldCost() * 100).append(Emoji.GOLD).append("  ")
                .append(clubman.getIronCost() * 100).append(Emoji.IRON).append("\n");

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }

}
