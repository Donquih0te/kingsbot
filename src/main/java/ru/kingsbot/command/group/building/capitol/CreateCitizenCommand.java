package ru.kingsbot.command.group.building.capitol;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;

import java.util.Map;

public class CreateCitizenCommand extends Command {

    public CreateCitizenCommand() {
        super("create_citizen");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        StringBuilder sb = new StringBuilder();
        Capitol capitol = player.getCapitol();
        Citizen citizen = capitol.getCitizen();
        Storage storage = player.getStorage();
        if(capitol.getCitizensAmount() >= capitol.getMaxCitizensAmount()) {
            sb.append("&#65039;Создано максимальное количество жителей").append("\n");
        }else{
            boolean buy = true;
            if(citizen.getFoodCost() > storage.getFood()) {
                sb.append("Для покупки не хватает ").append(citizen.getFoodCost() - storage.getFood()).append("&#127830;\n");
                buy = false;
            }
            if(citizen.getGoldCost() > storage.getGold()) {
                sb.append("Для покупки не хватает ").append(citizen.getGoldCost() - storage.getGold()).append("&#128176;\n");
                buy = false;
            }
            if(buy) {
                storage.reduceFood(citizen.getFoodCost());
                storage.reduceGold(citizen.getGoldCost());
                capitol.addCitizens(1);
                capitol.addFreeCitizens(1);

                sb.append("Уровень: ").append(citizen.getLevel()).append("\n")
                        .append("Рабочих: ").append(capitol.getCitizensAmount()).append("/").append(capitol.getMaxCitizensAmount()).append("&#9935;\n")
                        .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append("&#9937;\n\n")
                        .append("Создать рабочего:\n")
                        .append(citizen.getFoodCost()).append("&#127830;")
                        .append(storage.getFood() - citizen.getFoodCost() > 0 ? " ✔" : " ❌").append("\n")
                        .append(citizen.getGoldCost()).append("&#128176;")
                        .append(storage.getGold() - citizen.getGoldCost() > 0 ? " ✔" : " ❌").append("\n\n");
            }
        }

        bot.sendMessage(peerId, sb.toString(), null);
    }

}
