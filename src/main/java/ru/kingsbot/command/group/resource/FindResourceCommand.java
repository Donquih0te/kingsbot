package ru.kingsbot.command.group.resource;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.resource.*;
import ru.kingsbot.utils.Emoji;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class FindResourceCommand extends Command {

    public FindResourceCommand() {
        super("find_resource");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("resource") == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Capitol capitol = player.getCapitol();
        Resource resource = null;
        switch(payload.get("resource")) {
            case "food":
                resource = player.getFoodResource();
                if(resource.isMined()) {
                    capitol.addFreeCitizens(resource.getCitizensAmount());
                    player.setFoodResource(new Food(Utils.RANDOM.nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel()));
                    sb.append(Emoji.MARK).append("Найдена новая ферма для добычи еды\n")
                            .append("Твои рабочие вернулись со старой фермы. Теперь ты можешь отправить их работать на новую\n\n")
                            .append("Рабочих на добыче: 0/")
                            .append(resource.getMaxCitizensAmount()).append(Emoji.STONE).append("\n")
                            .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.WORKERS).append("\n");

                }else{
                    sb.append(Emoji.RED_EXCLAMATION_MARK).append("Поиск нового ресурса возможен только когда ресурс истощен\n");
                }
                break;
            case "gold":
                resource = player.getGoldResource();
                if(resource.isMined()) {
                    capitol.addFreeCitizens(resource.getCitizensAmount());
                    player.setGoldResource(new Gold(Utils.RANDOM.nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel()));
                    sb.append(Emoji.MARK).append("Найден новый золотой рудник для добычи золота\n")
                            .append("Твои рабочие вернулись со старого рудника. Теперь ты можешь отправить их работать на новый\n")
                            .append("Рабочих на добыче: 0/")
                            .append(resource.getMaxCitizensAmount()).append(Emoji.STONE).append("\n")
                            .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.WORKERS).append("\n");
                }else{
                    sb.append(Emoji.RED_EXCLAMATION_MARK).append("Поиск нового ресурса возможен только когда ресурс истощен\n");
                }
                break;
            case "iron":
                resource = player.getIronResource();
                if(resource.isMined()) {
                    capitol.addFreeCitizens(resource.getCitizensAmount());
                    player.setIronResource(new Iron(Utils.RANDOM.nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel()));
                    sb.append(Emoji.MARK).append("Найден новый железный рудник для добычи железа\n")
                            .append("Твои рабочие вернулись со старого рудника. Теперь ты можешь отправить их работать на новый\n")
                            .append("Рабочих на добыче: 0/")
                            .append(resource.getMaxCitizensAmount()).append(Emoji.STONE).append("\n")
                            .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.WORKERS).append("\n");
                }else{
                    sb.append(Emoji.RED_EXCLAMATION_MARK).append("Поиск нового ресурса возможен только когда ресурс истощен\n");
                }
                break;
            case "stone":
                resource = player.getStoneResource();
                if(resource.isMined()) {
                    capitol.addFreeCitizens(resource.getCitizensAmount());
                    player.setStoneResource(new Stone(Utils.RANDOM.nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel()));
                    sb.append(Emoji.MARK).append("Найдена новая каменная шахта для добычи камня\n")
                            .append("Твои рабочие вернулись со старой шахты. Теперь ты можешь отправить их работать на новую\n")
                            .append("Рабочих на добыче: 0/")
                            .append(resource.getMaxCitizensAmount()).append(Emoji.STONE).append("\n")
                            .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.WORKERS).append("\n");
                }else{
                    sb.append(Emoji.RED_EXCLAMATION_MARK).append("Поиск нового ресурса возможен только когда ресурс истощен\n");
                }
                break;
            case "wood":
                resource = player.getWoodResource();
                if(resource.isMined()) {
                    capitol.addFreeCitizens(resource.getCitizensAmount());
                    player.setWoodResource(new Wood(Utils.RANDOM.nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel()));
                    sb.append(Emoji.MARK).append("Найден новый лес для добычи дерева\n")
                            .append("Твои рабочие вернулись со старого леса. Теперь ты можешь отправить их работать на новый\n")
                            .append("Рабочих на добыче: 0/")
                            .append(resource.getMaxCitizensAmount()).append(Emoji.STONE).append("\n")
                            .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.WORKERS).append("\n");
                }else{
                    sb.append(Emoji.RED_EXCLAMATION_MARK).append("Поиск нового ресурса возможен только когда ресурс истощен\n");
                }
                break;
        }
        playerService.sendMessage(peerId, sb.toString(), null);
    }

}
