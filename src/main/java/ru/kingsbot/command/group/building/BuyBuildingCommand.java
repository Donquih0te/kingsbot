package ru.kingsbot.command.group.building;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Building;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.Map;

public class BuyBuildingCommand extends Command {

    public BuyBuildingCommand() {
        super("buy_building");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("building") == null) {
            return;
        }
        Building building = null;
        switch(payload.get("building")) {
            case "armory":
                building = player.getArmory();
                break;
        }
        if(building == null || building.isPurchased()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        boolean buy = true;
        if(storage.getGold() < building.getGoldCost()) {
            sb.append("&#10071;Не хватает ")
                    .append(NumberConverter.toString(building.getGoldCost() - storage.getGold()))
                    .append("&#128176; для покупки здания\n");
            buy = false;
        }
        if(storage.getIron() < building.getIronCost()) {
            sb.append("&#10071;Не хватает ")
                    .append(NumberConverter.toString(building.getIronCost() - storage.getIron()))
                    .append("&#9725; для покупки здания\n");
            buy = false;
        }
        if(storage.getStone() < building.getStoneCost()) {
            sb.append("&#10071;Не хватает ")
                    .append(NumberConverter.toString(building.getStoneCost() - storage.getStone()))
                    .append("&#9935; для покупки здания\n");
            buy = false;
        }
        if(storage.getWood() < building.getWoodCost()) {
            sb.append("&#10071;Не хватает ")
                    .append(NumberConverter.toString(building.getWoodCost() - storage.getWood()))
                    .append("&#127795; для покупки здания\n");
            buy = false;
        }
        if(buy) {
            storage.reduceGold(building.getGoldCost());
            storage.reduceIron(building.getIronCost());
            storage.reduceStone(building.getStoneCost());
            storage.reduceWood(building.getWoodCost());
            building.setPurchased(true);
            bot.getPlayerRepository().update(player);
            sb.append("Куплено новое здание");
        }

        bot.sendMessage(peerId, sb.toString(), bot.getKeyboard());
    }
}
