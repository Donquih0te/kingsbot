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

public class UpgradeCitizenCommand extends Command {

    public UpgradeCitizenCommand() {
        super("upgrade_citizen");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        StringBuilder sb = new StringBuilder();
        Capitol capitol = player.getCapitol();
        Citizen citizen = capitol.getCitizen();
        Storage storage = player.getStorage();
        boolean buy = true;
        if((long)citizen.getFoodUpgradeCost() > storage.getFood()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK)
                    .append("Для улучшения не хватает ").append(citizen.getFoodUpgradeCost() - storage.getFood()).append(Emoji.FOOD).append("\n");
            buy = false;
        }
        if((long)citizen.getGoldUpgradeCost() > storage.getGold()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK)
                    .append("Для улучшения не хватает ").append(citizen.getGoldUpgradeCost() - storage.getGold()).append(Emoji.GOLD).append("&#128176;\n");
            buy = false;
        }
        if(buy) {
            storage.reduceFood(citizen.getFoodUpgradeCost());
            storage.reduceGold(citizen.getGoldUpgradeCost());
            citizen.upgrade();

            sb.append("Уровень: ").append(citizen.getLevel()).append("\n")
                    .append("Рабочих: ").append(capitol.getCitizensAmount()).append("/")
                    .append(capitol.getMaxCitizensAmount()).append(Emoji.RESOURCES).append("\n")
                    .append("Свободных рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.WORKERS).append("\n\n")
                    .append("Улучшить рабочего:\n")
                    .append(NumberConverter.toString(citizen.getFoodUpgradeCost())).append(Emoji.FOOD)
                    .append(storage.getFood() - (long)citizen.getFoodUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(citizen.getGoldUpgradeCost())).append(Emoji.GOLD)
                    .append(storage.getGold() - (long)citizen.getGoldUpgradeCost() > 0 ? " ✔" : " ❌").append("\n\n");
        }

        bot.sendMessage(peerId, sb.toString(), null);
    }
}
