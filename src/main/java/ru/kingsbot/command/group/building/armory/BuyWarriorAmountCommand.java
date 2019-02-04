package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.Map;

public class BuyWarriorAmountCommand extends Command {

    public BuyWarriorAmountCommand() {
        super("buy_warrior_amount");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("warrior") == null || payload.get("amount") == null) {
            return;
        }
        Warrior warrior = null;
        switch(payload.get("warrior")) {
            case "clubman":
                warrior = player.getArmy().getClubman();
                break;
            case "rock_thrower":
                warrior = player.getArmy().getRockThrower();
                break;
        }
        if(warrior == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(warrior.getName()).append("\n\n");
        int amount = Integer.parseInt(payload.get("amount"));
        Storage storage = player.getStorage();
        boolean buy = true;
        if(storage.getFood() < amount * warrior.getFoodCost()) {
            sb.append("Не хватает ")
                    .append(NumberConverter.toString(amount * warrior.getFoodCost() - storage.getFood()))
                    .append("&#127830; для покупки воинов\n");
            buy = false;
        }
        if(storage.getGold() < amount * warrior.getGoldCost()) {
            sb.append("Не хватает ")
                    .append(NumberConverter.toString(amount * warrior.getGoldCost() - storage.getGold()))
                    .append("&#128176; для покупки воинов\n");
            buy = false;
        }
        if(storage.getIron() < amount * warrior.getIronCost()) {
            sb.append("Не хватает ")
                    .append(NumberConverter.toString(amount * warrior.getIronCost() - storage.getIron()))
                    .append("&#9725; для покупки воинов\n");
            buy = false;
        }

        if(buy) {
            warrior.add(amount);
            storage.reduceFood(amount * warrior.getFoodCost());
            storage.reduceGold(amount * warrior.getGoldCost());
            storage.reduceIron(amount * warrior.getIronCost());
            sb.append("Куплено ").append(NumberConverter.toString(amount)).append(" воинов\n")
                    .append("за ").append(amount * warrior.getFoodCost()).append("&#127830; ")
                    .append(NumberConverter.toString(amount * warrior.getGoldCost())).append("&#128176; ")
                    .append(NumberConverter.toString(amount * warrior.getIronCost())).append("&#9725;\n");
        }

        bot.sendMessage(peerId, sb.toString(), null);

    }
}
