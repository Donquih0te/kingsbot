package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.NumberConverter;

import java.util.List;
import java.util.Map;

public class ResourceCommand extends Command {

    public ResourceCommand() {
        super("resource");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.FOOD + "Ферма", Map.of("command", "open_resource", "resource" , "food")), Color.WHITE),
                        new Button(new Action(Emoji.GOLD + "Золотой рудник", Map.of("command", "open_resource", "resource" , "gold")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.IRON + "Железный рудник", Map.of("command", "open_resource", "resource" , "iron")), Color.WHITE),
                        new Button(new Action(Emoji.STONE + "Каменная шахта", Map.of("command", "open_resource", "resource" , "stone")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.WOOD + "Лес", Map.of("command", "open_resource", "resource" , "wood")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Citizen citizen = player.getCapitol().getCitizen();
        if(player.updateResources()) {
            bot.getPlayerRepository().update(player);
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

        bot.sendMessage(peerId, sb.toString(), keyboard);

    }

}
