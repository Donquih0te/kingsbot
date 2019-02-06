package ru.kingsbot.command.group.building;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Armory;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArmoryCommand extends Command {

    public ArmoryCommand() {
        super("armory");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        Armory armory = player.getArmory();
        Storage storage = player.getStorage();
        StringBuilder sb = new StringBuilder();
        if(!armory.isPurchased()) {
            sb.append(Emoji.ARMORY).append("Казармы\n")
                    .append(Emoji.LEVEL).append("Уровень: ").append(armory.getLevel()).append("\n\n")
                    .append("Купить:\n")
                    .append(NumberConverter.toString(armory.getGoldCost())).append(Emoji.GOLD)
                    .append(armory.getGoldCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(armory.getIronCost())).append(Emoji.IRON)
                    .append(armory.getIronCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(armory.getStoneCost())).append(Emoji.STONE)
                    .append(armory.getStoneCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(armory.getWoodCost())).append(Emoji.WOOD)
                    .append(armory.getWoodCost() <= storage.getWood() ? " ✔" : " ❌").append("\n");
            keyboard = Keyboard.newKeyboard()
                    .row(List.of(
                            Button.newButton()
                                    .label(Emoji.PLUS + "Купить")
                                    .payload("command", "buy_building")
                                    .payload("building", "armory")
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
                    ))
                    .build();
        }else{
            sb.append("Улучшить:\n")
                    .append(NumberConverter.toString(armory.getGoldUpgradeCost())).append(Emoji.GOLD)
                    .append(armory.getGoldUpgradeCost() <= storage.getGold() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(armory.getIronUpgradeCost())).append(Emoji.IRON)
                    .append(armory.getIronUpgradeCost() <= storage.getIron() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(armory.getStoneUpgradeCost())).append(Emoji.STONE)
                    .append(armory.getStoneUpgradeCost() <= storage.getStone() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(armory.getWoodUpgradeCost())).append(Emoji.WOOD)
                    .append(armory.getWoodUpgradeCost() <= storage.getWood() ? " ✔" : " ❌").append("\n\n");
            keyboard = Keyboard.newKeyboard()
                    .row(new LinkedList<>(List.of(
                            Button.newButton()
                                    .label("Улучшить" + Emoji.CITIZEN)
                                    .payload("command", "upgrade_building")
                                    .payload("building", "armory")
                                    .color(Color.GREEN)
                                    .create()
                            ))
                    )
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

            switch(player.getAge()) {
                case PREHISTORIC:
                    Button clubman = Button.newButton()
                            .label("Воин с дубиной")
                            .payload("command", "clubman")
                            .color(Color.WHITE)
                            .create();
                    Button rockThrower = Button.newButton()
                            .label("Метатель камней")
                            .payload("command", "rock_thrower")
                            .color(Color.WHITE)
                            .create();

                    keyboard.addButtonToRow(0, clubman);
                    keyboard.addButtonToRow(0, rockThrower);
                    break;
            }

        }

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
