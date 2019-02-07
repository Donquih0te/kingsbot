package ru.kingsbot.command.group.resource;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.resource.Resource;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class CitizenResourceCommand extends Command {

    public CitizenResourceCommand() {
        super("citizen_resource");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("action") == null || payload.get("resource") == null) {
            return;
        }
        Capitol capitol = player.getCapitol();
        Resource resource = null;
        switch(payload.get("resource")) {
            case "food":
                resource = player.getFoodResource();
                break;
            case "gold":
                resource = player.getGoldResource();
                break;
            case "iron":
                resource = player.getIronResource();
                break;
            case "stone":
                resource = player.getStoneResource();
                break;
            case "wood":
                resource = player.getWoodResource();
                break;
        }
        if(resource == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String action = payload.get("action");
        if(action.equals("put")) {
            if(capitol.getFreeCitizensAmount() == 0) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("У вас нет свободных рабочих").append("\n");
            }else{
                if(resource.getCitizensAmount() == resource.getMaxCitizensAmount()) {
                    sb.append(Emoji.RED_EXCLAMATION_MARK).append("Нет свободных рабочих мест, чтобы добавить рабочего").append("\n");
                }else{
                    resource.addCitizen();
                    capitol.removeFreeCitizens(1);
                }
            }
        }else if(action.equals("remove")) {
            if(resource.getCitizensAmount() == 0) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("На добыче нет больше рабочих").append("\n");
            }else{
                resource.removeCitizen();
                capitol.addFreeCitizens(1);
            }
        }
        sb.append("Рабочих на добыче: ").append(resource.getCitizensAmount()).append("/")
                .append(resource.getMaxCitizensAmount()).append(Emoji.STONE).append("\n")
                .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.WORKERS).append("\n");

        playerService.sendMessage(peerId, sb.toString(), null);
    }

}
