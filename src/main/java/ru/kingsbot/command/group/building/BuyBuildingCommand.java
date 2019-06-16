package ru.kingsbot.command.group.building;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Keyboards;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Building;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class BuyBuildingCommand extends Command {

    public BuyBuildingCommand() {
        super("buy_building");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
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
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getGoldCost() - storage.getGold())).append(Emoji.GOLD)
                    .append(" для покупки здания\n");
            buy = false;
        }
        if(storage.getIron() < building.getIronCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getIronCost() - storage.getIron())).append(Emoji.IRON)
                    .append(" для покупки здания\n");
            buy = false;
        }
        if(storage.getStone() < building.getStoneCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getStoneCost() - storage.getStone())).append(Emoji.STONE)
                    .append(" для покупки здания\n");
            buy = false;
        }
        if(storage.getWood() < building.getWoodCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getWoodCost() - storage.getWood())).append(Emoji.WOOD)
                    .append(" для покупки здания\n");
            buy = false;
        }
        if(buy) {
            storage.reduceGold(building.getGoldCost());
            storage.reduceIron(building.getIronCost());
            storage.reduceStone(building.getStoneCost());
            storage.reduceWood(building.getWoodCost());
            building.setPurchased(true);
            sb.append("Куплено новое здание");
        }

        playerService.sendMessage(peerId, sb.toString(), Keyboards.getGroupKeyboard());
    }
}
