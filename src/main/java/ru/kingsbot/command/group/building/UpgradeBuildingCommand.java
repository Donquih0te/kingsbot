package ru.kingsbot.command.group.building;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Building;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.Map;

public class UpgradeBuildingCommand extends Command {

    public UpgradeBuildingCommand() {
        super("upgrade_building");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
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
        if((long)building.getGoldUpgradeCost() > storage.getGold()) {
            sb.append("Для улучшения не хватает ")
                    .append(NumberConverter.toString((long)building.getGoldUpgradeCost() - storage.getGold()))
                    .append("&#128176;\n");
            buy = false;
        }
        if((long)building.getIronUpgradeCost() > storage.getIron()) {
            sb.append("Для улучшения не хватает ")
                    .append(NumberConverter.toString((long)building.getIronUpgradeCost() - storage.getIron()))
                    .append("&#9725;\n");
            buy = false;
        }
        if((long)building.getStoneUpgradeCost() > storage.getStone()) {
            sb.append("Для улучшения не хватает ")
                    .append(NumberConverter.toString((long)building.getStoneUpgradeCost() - storage.getStone()))
                    .append("&#9935;\n");
            buy = false;
        }
        if((long)building.getWoodUpgradeCost() > storage.getWood()) {
            sb.append("Для улучшения не хватает ")
                    .append(NumberConverter.toString((long)building.getWoodUpgradeCost() - storage.getWood()))
                    .append("&#127795;\n");
            buy = false;
        }
        if(buy) {
            storage.reduceGold(building.getGoldUpgradeCost());
            storage.reduceIron(building.getIronUpgradeCost());
            storage.reduceStone(building.getStoneUpgradeCost());
            storage.reduceWood(building.getWoodUpgradeCost());
            building.upgrade();

            sb.append(building.getName()).append("\n\n")
                    .append("Уровень: ").append(building.getLevel()).append("\n\n")
                    .append("Улучшить:\n")
                    .append(NumberConverter.toString(building.getGoldUpgradeCost())).append("&#128176;")
                    .append(storage.getGold() >= (long)building.getGoldUpgradeCost() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(building.getIronUpgradeCost())).append("&#9725;")
                    .append(storage.getIron() >= (long)building.getIronUpgradeCost() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(building.getStoneUpgradeCost())).append("&#9935;")
                    .append(storage.getStone() >= (long)building.getStoneUpgradeCost() ? " ✔" : " ❌").append("\n")
                    .append(NumberConverter.toString(building.getWoodUpgradeCost())).append("&#127795;")
                    .append(storage.getWood() >= (long)building.getWoodUpgradeCost() ? " ✔" : " ❌").append("\n\n");
        }
        bot.sendMessage(peerId, sb.toString(), null);
    }
}
