package ru.kingsbot.command.group.building.capitol;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Citizen;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.Map;

public class UpgradeCitizenCommand extends Command {

    public UpgradeCitizenCommand() {
        super("upgrade_citizen");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        StringBuilder sb = new StringBuilder();
        Capitol capitol = player.getCapitol();
        Citizen citizen = capitol.getCitizen();
        Storage storage = player.getStorage();
        boolean buy = true;
        if((long)citizen.getFoodUpgradeCost() > storage.getFood()) {
            sb.append("Для улучшения не хватает ").append(citizen.getFoodUpgradeCost() - storage.getFood()).append("&#127830;\n");
            buy = false;
        }
        if((long)citizen.getGoldUpgradeCost() > storage.getGold()) {
            sb.append("Для улучшения не хватает ").append(citizen.getGoldUpgradeCost() - storage.getGold()).append("&#128176;\n");
            buy = false;
        }
        if(buy) {
            storage.reduceFood(citizen.getFoodUpgradeCost());
            storage.reduceGold(citizen.getGoldUpgradeCost());
            citizen.upgrade();

            sb.append("Уровень: ").append(citizen.getLevel()).append("\n")
                    .append("Рабочих: ").append(capitol.getCitizensAmount()).append("/").append(capitol.getMaxCitizensAmount()).append(" &#9935;\n")
                    .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(" &#9937;\n\n")
                    .append("Улучшить рабочего:\n")
                    .append(NumberConverter.toString(citizen.getFoodUpgradeCost())).append("&#127830;")
                    .append(storage.getFood() - (long)citizen.getFoodUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(citizen.getGoldUpgradeCost())).append("&#128176;")
                    .append(storage.getGold() - (long)citizen.getGoldUpgradeCost() > 0 ? " ✔" : " ❌").append("\n\n");
        }

        bot.sendMessage(peerId, sb.toString(), null);
    }
}
