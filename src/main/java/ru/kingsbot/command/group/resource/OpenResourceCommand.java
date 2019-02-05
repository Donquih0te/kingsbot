package ru.kingsbot.command.group.resource;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.resource.Resource;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class OpenResourceCommand extends Command {

    public OpenResourceCommand() {
        super("open_resource");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("resource") == null) {
            return;
        }
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton().label(Emoji.PLUS + "Добавить рабочего").payload("command", "citizen_resource")
                                .payload("resource", payload.get("resource"))
                                .payload("action", "put")
                                .payload("key", Utils.encodeSignature(player.getId() + "-citizen_resource"))
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton().label(Emoji.MINUS + "Снять рабочего").payload("command", "citizen_resource")
                                .payload("resource", payload.get("resource"))
                                .payload("action", "remove")
                                .payload("key", Utils.encodeSignature(player.getId() + "-citizen_resource"))
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.FIND + "Найти")
                                .payload("command", "find_resource")
                                .payload("resource", payload.get("resource"))
                                .color(Color.RED)
                                .create(),
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "resource")
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
