package ru.kingsbot.command.group.building;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Armory;
import ru.kingsbot.entity.building.Storage;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArmoryCommand extends Command {

    public ArmoryCommand() {
        super("armory");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Armory armory = player.getArmory();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder("&#9876;Казармы\n\n");
        if(!armory.isPurchased()) {
            sb.append("Уровень: ").append(armory.getLevel()).append("\n\n")
                    .append("Купить:\n")
                    .append("Золото: ").append(armory.getGoldCost()).append("&#128176;")
                    .append(armory.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                    .append("Железо: ").append(armory.getIronCost()).append("&#9725;")
                    .append(armory.getIronCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                    .append("Камень: ").append(armory.getStoneCost()).append("&#9935;")
                    .append(armory.getStoneCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                    .append("Дерево: ").append(armory.getWoodCost()).append("&#127795;")
                    .append(armory.getWoodCost() <= storage.getWood() ? " ✔" : " ❌").append("\n");
            keyboard = Keyboard.newKeyboard()
                    .row(List.of(new Button(new Action("&#10133;Купить", Map.of("command", "buy_building", "building", "armory")), Color.WHITE)))
                    .row(List.of(new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)))
                    .build();
        }else{
            sb.append("Улучшить:\n");
            sb.append("Золото: ").append(armory.getGoldUpgradeCost()).append("&#128176;")
                    .append(armory.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n");
            sb.append("Железо: ").append(armory.getIronUpgradeCost()).append("&#9725;")
                    .append(armory.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n");
            sb.append("Камень: ").append(armory.getStoneUpgradeCost()).append("&#9935;")
                    .append(armory.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n");
            sb.append("Дерево: ").append(armory.getWoodUpgradeCost()).append("&#127795;")
                    .append(armory.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");
            keyboard = Keyboard.newKeyboard()
                    .row(new LinkedList<>(List.of(
                            new Button(new Action("Улучшить&#9874;", Map.of("command", "upgrade_building", "building", "armory")), Color.GREEN)
                        ))
                    )
                    .row(List.of(
                            new Button(new Action("&#128259;Назад", Map.of("command", "back", "next", "building")), Color.WHITE),
                            new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                        )
                    )
                    .build();

            switch (player.getAge()) {
                case PREHISTORIC:
                    Button clubman = new Button(new Action("Воин с дубиной", Map.of("command", "clubman")), Color.WHITE);
                    Button rockThrower = new Button(new Action("Метатель камней", Map.of("command", "rock_thrower")), Color.WHITE);
                    keyboard.addButtonToRow(0, clubman);
                    keyboard.addButtonToRow(0, rockThrower);
                    break;
            }

        }

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
