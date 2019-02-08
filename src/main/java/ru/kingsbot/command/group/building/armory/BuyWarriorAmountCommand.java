package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class BuyWarriorAmountCommand extends Command {

    public BuyWarriorAmountCommand() {
        super("buy_warrior_amount");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("warrior") == null || payload.get("amount") == null || Utils.parseInt(payload.get("amount")) < 0) {
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
        int amount = Utils.parseInt(payload.get("amount"));
        Storage storage = player.getStorage();
        boolean buy = true;
        if(storage.getMaxFood() < player.getArmy().getWarriorsAmount() + amount / 100) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("На складе нет столько еды, чтобы прокормить твоё войско.")
                    .append("Качай склад и рабочих, чтобы нанять больше армии.");
        }else{
            if(storage.getFood() < (amount * warrior.getFoodCost())) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                        .append(NumberConverter.toString(amount * warrior.getFoodCost() - storage.getFood()))
                        .append(Emoji.FOOD).append(" для покупки воинов\n");
                buy = false;
            }
            if(storage.getGold() < (amount * warrior.getGoldCost())) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                        .append(NumberConverter.toString(amount * warrior.getGoldCost() - storage.getGold()))
                        .append(Emoji.GOLD).append(" для покупки воинов\n");
                buy = false;
            }
            if(storage.getIron() < (amount * warrior.getIronCost())) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                        .append(NumberConverter.toString(amount * warrior.getIronCost() - storage.getIron()))
                        .append(Emoji.IRON).append(" для покупки воинов\n");
                buy = false;
            }

            if(buy) {
                warrior.add(amount);
                storage.reduceFood(amount * warrior.getFoodCost());
                storage.reduceGold(amount * warrior.getGoldCost());
                storage.reduceIron(amount * warrior.getIronCost());
                sb.append("Куплено ").append(NumberConverter.toString(amount)).append(" воинов\n")
                        .append("за ").append(NumberConverter.toString(amount * warrior.getFoodCost())).append(Emoji.FOOD).append("  ")
                        .append(NumberConverter.toString(amount * warrior.getGoldCost())).append(Emoji.GOLD).append("  ")
                        .append(NumberConverter.toString(amount * warrior.getIronCost())).append(Emoji.IRON).append("\n");
            }
        }

        playerService.sendMessage(peerId, sb.toString(), null);

    }
}
