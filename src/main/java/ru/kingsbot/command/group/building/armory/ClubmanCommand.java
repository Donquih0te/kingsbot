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

public class ClubmanCommand extends Command {

    public ClubmanCommand() {
        super("clubman");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("&#10133;Купить", Map.of("command", "buy_warrior", "warrior", "clubman")), Color.WHITE),
                        new Button(new Action("Улучшить&#9874;", Map.of("command", "upgrade_warrior", "warrior", "clubman")), Color.WHITE)
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
        Warrior clubman = player.getArmy().getClubman();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder("Воин с дубиной\n\n");
        sb.append("Уровень: ").append(clubman.getLevel()).append("\n")
                .append("Колличество: ").append(NumberConverter.toString(clubman.getAmount())).append("\n")
                .append("HP: ").append(clubman.getHealth()).append("&#129505;\n")
                .append("Атака: ").append(clubman.getAttack()).append("&#9876;\n")
                .append("Защита: ").append(clubman.getArmor()).append("&#128737;\n\n")
                .append("Улучшить:\n")
                .append(NumberConverter.toString(clubman.getFoodUpgradeCost())).append("&#127830;")
                .append(clubman.getFoodUpgradeCost() <= storage.getFood() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(clubman.getGoldUpgradeCost())).append("&#128176;")
                .append(clubman.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                .append(NumberConverter.toString(clubman.getIronUpgradeCost())).append("&#9725;")
                .append(clubman.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n\n")
                .append("Купить:\n")
                .append("100 воинов за ").append(clubman.getFoodCost() * 100).append("&#127830; ")
                .append(clubman.getGoldCost() * 100).append("&#128176; ")
                .append(clubman.getIronCost() * 100).append("&#9725;\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }

}
