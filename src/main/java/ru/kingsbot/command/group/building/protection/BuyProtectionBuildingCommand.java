package ru.kingsbot.command.group.building.protection;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Building;
import ru.kingsbot.entity.building.Protection;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class BuyProtectionBuildingCommand extends Command {

    public BuyProtectionBuildingCommand() {
        super("buy_protection_building");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
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
        if(storage.getGold() < building.getGoldCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getGoldCost() - storage.getGold())).append(Emoji.GOLD).append(" для покупки\n");
            buy = false;
        }
        if(storage.getIron() < building.getIronCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getIronCost() - storage.getIron())).append(Emoji.IRON).append(" для покупки\n");
            buy = false;
        }
        if(storage.getStone() < building.getStoneCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getStoneCost() - storage.getStone())).append(Emoji.STONE).append(" для покупки\n");
            buy = false;
        }
        if(storage.getWood() < building.getWoodCost()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ")
                    .append(NumberConverter.toString(building.getWoodCost() - storage.getWood())).append(Emoji.WOOD).append(" для покупки\n");
            buy = false;
        }
        if(buy) {
            if(player.getTerritory() / 1000 > ((Protection) building).getAmount()) {
                sb.append(Emoji.RED_EXCLAMATION_MARK)
                        .append("Ты достиг максимального количества защитных сооружений для твоей территории.\n Атакуй другие королевства и захватывай территории чтобы купить больше защитных сооружений");
            }else{
                storage.reduceGold(building.getGoldCost());
                storage.reduceIron(building.getIronCost());
                storage.reduceStone(building.getStoneCost());
                storage.reduceWood(building.getWoodCost());
                sb.append(Emoji.LEVEL).append("Уровень: ").append(building.getLevel()).append("\n")
                        .append("Количество: ").append(((Protection) building).getAmount()).append("\n");

            }
        }

        bot.sendMessage(peerId, sb.toString(), null);
    }
}
