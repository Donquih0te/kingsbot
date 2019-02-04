package ru.kingsbot.command.group.building.protection;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Building;
import ru.kingsbot.entity.building.Protection;
import ru.kingsbot.entity.building.Storage;

import java.util.Map;

public class BuyProtectionBuildingCommand extends Command {

    public BuyProtectionBuildingCommand() {
        super("buy_protection_building");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("building") == null) {
            return;
        }
        Building building = null;
        switch(payload.get("building")) {
            case "wall":
                building = player.getWall();
                break;
            case "tower":
                building = player.getTower();
                break;
        }
        if(!(building instanceof Protection)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        boolean buy = true;
        if(storage.getGold() < (long)building.getGoldCost()) {
            sb.append("&#10071;Не хватает ").append((long)building.getGoldCost() - storage.getGold()).append("&#128176; золота для покупки\n");
            buy = false;
        }
        if(storage.getIron() < (long)building.getIronCost()) {
            sb.append("&#10071;Не хватает ").append((long)building.getIronCost() - storage.getIron()).append("&#9725; железа для покупки\n");
            buy = false;
        }
        if(storage.getStone() < (long)building.getStoneCost()) {
            sb.append("&#10071;Не хватает ").append((long)building.getStoneCost() - storage.getStone()).append("&#9935; для покупки\n");
            buy = false;
        }
        if(storage.getWood() < (long)building.getWoodCost()) {
            sb.append("&#10071;Не хватает ").append((long)building.getWoodCost() - storage.getWood()).append("&#127795; для покупки\n");
            buy = false;
        }
        if(buy) {
            if(player.getTerritory() / 1000 > ((Protection) building).getAmount()) {
                sb.append("Вы достигли максимального количества стен для вашей территории. Захватывайте территории чтобы купить больше защитных сооружений");
            }else{
                storage.reduceGold(building.getGoldCost());
                storage.reduceIron(building.getIronCost());
                storage.reduceStone(building.getStoneCost());
                storage.reduceWood(building.getWoodCost());
                sb.append("Уровень: ").append(building.getLevel()).append("\n")
                        .append("Количество: ").append(((Protection) building).getAmount()).append("\n");

            }
        }

        bot.sendMessage(peerId, sb.toString(), null);
    }
}
