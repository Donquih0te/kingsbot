package ru.kingsbot.command.group.building.capitol;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class CreateCitizenCommand extends Command {

    public CreateCitizenCommand() {
        super("create_citizen");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        StringBuilder sb = new StringBuilder();
        Capitol capitol = player.getCapitol();
        Citizen citizen = capitol.getCitizen();
        Storage storage = player.getStorage();
        if(capitol.getCitizensAmount() >= capitol.getMaxCitizensAmount()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Создано максимальное количество жителей").append("\n");
        }else{
            boolean buy = true;
            if(citizen.getFoodCost() > storage.getFood()) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для покупки не хватает ")
                        .append(NumberConverter.toString(citizen.getFoodCost() - storage.getFood())).append(Emoji.FOOD).append("\n");
                buy = false;
            }
            if(citizen.getGoldCost() > storage.getGold()) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для покупки не хватает ")
                        .append(NumberConverter.toString(citizen.getGoldCost() - storage.getGold())).append(Emoji.GOLD).append("\n");
                buy = false;
            }
            if(buy) {
                storage.reduceFood(citizen.getFoodCost());
                storage.reduceGold(citizen.getGoldCost());
                capitol.addCitizens(1);
                capitol.addFreeCitizens(1);

                sb.append(Emoji.LEVEL).append("Уровень: ").append(citizen.getLevel()).append("\n")
                        .append(Emoji.RESOURCES).append("Рабочих: ").append(capitol.getCitizensAmount()).append("/")
                        .append(capitol.getMaxCitizensAmount()).append("\n")
                        .append(Emoji.WORKERS).append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append("\n\n")
                        .append("Создать рабочего:\n")
                        .append(NumberConverter.toString(citizen.getFoodCost())).append(Emoji.FOOD)
                        .append(storage.getFood() - citizen.getFoodCost() > 0 ? " ✔" : " ❌").append("\n")
                        .append(NumberConverter.toString(citizen.getGoldCost())).append(Emoji.GOLD)
                        .append(storage.getGold() - citizen.getGoldCost() > 0 ? " ✔" : " ❌").append("\n\n");
            }
        }

        bot.sendMessage(peerId, sb.toString(), null);
    }

}
