package ru.kingsbot.command.group.building;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Building;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class UpgradeBuildingCommand extends Command {

    public UpgradeBuildingCommand() {
        super("upgrade_building");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("building") == null) {
            return;
        }

        Building building = null;
        switch(payload.get("building")) {
            case "capitol":
                building = player.getCapitol();
                break;
            case "armory":
                building = player.getArmory();
                break;
            case "storage":
                building = player.getStorage();
                break;
            case "wall":
                building = player.getWall();
                break;
            case "tower":
                building = player.getTower();
                break;
        }
        if(building == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        boolean buy = true;
        if(storage.getGold() < building.getGoldUpgradeCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для улучшения не хватает ")
                    .append(NumberConverter.toString(building.getGoldUpgradeCost() - storage.getGold()))
                    .append(Emoji.GOLD).append("\n");
            buy = false;
        }
        if(storage.getIron() < building.getIronUpgradeCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для улучшения не хватает ")
                    .append(NumberConverter.toString(building.getIronUpgradeCost() - storage.getIron()))
                    .append(Emoji.IRON).append("\n");
            buy = false;
        }
        if(storage.getStone() < building.getStoneUpgradeCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для улучшения не хватает ")
                    .append(NumberConverter.toString(building.getStoneUpgradeCost() - storage.getStone()))
                    .append(Emoji.STONE).append("\n");
            buy = false;
        }
        if(storage.getWood() < building.getWoodUpgradeCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для улучшения не хватает ")
                    .append(NumberConverter.toString(building.getWoodUpgradeCost() - storage.getWood()))
                    .append(Emoji.WOOD).append("\n");
            buy = false;
        }
        if(buy) {
            storage.reduceGold(building.getGoldUpgradeCost());
            storage.reduceIron(building.getIronUpgradeCost());
            storage.reduceStone(building.getStoneUpgradeCost());
            storage.reduceWood(building.getWoodUpgradeCost());
            building.upgrade();

            sb.append(building.getName()).append("\n\n")
                    .append(Emoji.LEVEL).append("Уровень: ").append(building.getLevel()).append("\n\n")
                    .append("Улучшить:\n")
                    .append(NumberConverter.toString(building.getGoldUpgradeCost())).append(Emoji.GOLD)
                    .append(storage.getGold() >= building.getGoldUpgradeCost() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(building.getIronUpgradeCost())).append(Emoji.IRON)
                    .append(storage.getIron() >= building.getIronUpgradeCost() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(building.getStoneUpgradeCost())).append(Emoji.STONE)
                    .append(storage.getStone() >= building.getStoneUpgradeCost() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(building.getWoodUpgradeCost())).append(Emoji.WOOD)
                    .append(storage.getWood() >= building.getWoodUpgradeCost() ? " ✔" : " ❌").append("\n\n");
        }
        playerService.sendMessage(peerId, sb.toString(), null);
    }
}
