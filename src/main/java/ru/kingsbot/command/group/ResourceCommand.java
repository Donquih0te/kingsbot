package ru.kingsbot.command.group;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class ResourceCommand extends Command {

    public ResourceCommand() {
        super("resource");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.FOOD + "Ферма")
                                .payload("command", "open_resource")
                                .payload("resource" , "food")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.GOLD + "Золотой рудник")
                                .payload("command", "open_resource")
                                .payload("resource" , "gold")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.IRON + "Железный рудник")
                                .payload("command", "open_resource")
                                .payload("resource" , "iron")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.STONE + "Каменная шахта")
                                .payload("command", "open_resource")
                                .payload("resource" , "stone")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.WOOD + "Лес")
                                .payload("command", "open_resource")
                                .payload("resource" , "wood")
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
        Citizen citizen = player.getCapitol().getCitizen();
        if(player.updateResources()) {
            playerService.update(player);
        }
        StringBuilder sb = new StringBuilder();
        String exhausted = "(" + Emoji.RED_EXCLAMATION_MARK + " ИСТОЩЕН)\n";
        sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для добычи ресурсов отправь к ним рабочих\n\n")
                .append("Ферма: ").append(NumberConverter.toString(player.getFoodResource().getCurrentAmount())).append(Emoji.FOOD).append(" ")
                .append(player.getFoodResource().isMined() ? exhausted : "\n")
                .append("+")
                .append(NumberConverter.toString(player.getFoodResource().getCitizensAmount() * citizen.getFoodPerMinute()))
                .append(Emoji.FOOD).append(" в минуту\n\n")
                .append("Золотой рудник: ")
                .append(NumberConverter.toString(player.getGoldResource().getCurrentAmount())).append(Emoji.GOLD).append(" ")
                .append(player.getGoldResource().isMined() ? exhausted : "\n")
                .append("+")
                .append(NumberConverter.toString(player.getGoldResource().getCitizensAmount() * citizen.getGoldPerMinute()))
                .append(Emoji.GOLD).append(" в минуту\n\n")
                .append("Железный рудник: ")
                .append(NumberConverter.toString(player.getIronResource().getCurrentAmount())).append(Emoji.IRON).append(" ")
                .append(player.getIronResource().isMined() ? exhausted : "\n")
                .append("+")
                .append(NumberConverter.toString(player.getIronResource().getCitizensAmount() * citizen.getIronPerMinute()))
                .append(Emoji.IRON).append(" в минуту\n\n")
                .append("Каменная шахта: ")
                .append(NumberConverter.toString(player.getStoneResource().getCurrentAmount())).append(Emoji.STONE).append(" ")
                .append(player.getStoneResource().isMined() ? exhausted : "\n")
                .append("+")
                .append(NumberConverter.toString(player.getStoneResource().getCitizensAmount() * citizen.getStonePerMinute()))
                .append(Emoji.STONE).append(" в минуту\n\n")
                .append("Лес: ")
                .append(NumberConverter.toString(player.getWoodResource().getCurrentAmount())).append(Emoji.WOOD).append(" ")
                .append(player.getWoodResource().isMined() ? exhausted : "\n")
                .append("+")
                .append(NumberConverter.toString(player.getWoodResource().getCitizensAmount() * citizen.getWoodPerMinute()))
                .append(Emoji.WOOD).append(" в минуту\n\n");

        playerService.sendMessage(peerId, sb.toString(), keyboard);

    }

}
