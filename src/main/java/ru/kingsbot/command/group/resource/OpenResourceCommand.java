package ru.kingsbot.command.group.resource;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.resource.Resource;

import java.util.List;
import java.util.Map;

public class OpenResourceCommand extends Command {

    public OpenResourceCommand() {
        super("open_resource");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("resource") == null) {
            return;
        }
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.PLUS + "Добавить рабочего",Map.of("command", "citizen_resource", "resource", payload.get("resource"), "action", "put")), Color.WHITE),
                        new Button(new Action(Emoji.MINUS + "Снять рабочего",Map.of("command", "citizen_resource", "resource", payload.get("resource"), "action", "remove")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.FIND + "Найти",Map.of("command", "find_resource", "resource", payload.get("resource"))), Color.RED),
                        new Button(new Action(Emoji.BACK + "Назад", Map.of("command", "back", "next", "resource")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();
        StringBuilder sb = new StringBuilder();
        Resource resource = null;
        switch(payload.get("resource")) {
            case "food":
                resource = player.getFoodResource();
                sb.append(Emoji.FOOD).append("Ферма:\n\n");
                break;
            case "gold":
                resource = player.getGoldResource();
                sb.append(Emoji.GOLD).append("Золотой рудник:\n\n");
                break;
            case "iron":
                resource = player.getIronResource();
                sb.append(Emoji.IRON).append("Железный рудник:\n\n");
                break;
            case "stone":
                resource = player.getStoneResource();
                sb.append(Emoji.STONE).append("Каменная шахта:\n\n");
                break;
            case "wood":
                resource = player.getWoodResource();
                sb.append(Emoji.WOOD).append("Лес:\n\n");
                break;
        }
        if(resource == null) {
            return;
        }

        sb.append("Ресурсов: ").append(resource.getCurrentAmount()).append(Emoji.STONE).append("\n")
                .append("Рабочих: ").append(resource.getCitizensAmount()).append("/")
                .append(resource.getMaxCitizensAmount()).append(Emoji.WORKERS).append("\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }

}
