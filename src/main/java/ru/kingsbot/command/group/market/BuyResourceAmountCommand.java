package ru.kingsbot.command.group.market;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.market.Market;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class BuyResourceAmountCommand extends Command {

    public BuyResourceAmountCommand() {
        super("buy_resource_amount");

    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("resource") == null || payload.get("amount") == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Market market = bot.getMarket();
        Storage storage = player.getStorage();
        long amount = Utils.parseInt(payload.get("amount"));
        switch(payload.get("resource")) {
            case "food":
                if(market.getFood().getBuyCost() * amount / market.getFood().getBuyAmount() > storage.getGold()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(market.getFood().getBuyCost() * amount / market.getFood().getBuyAmount() - storage.getGold()))
                            .append(Emoji.GOLD).append(" для покупки\n");
                }else{
                    if(amount + storage.getFood() > storage.getMaxFood()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад\n");
                    }else{
                        sb.append("Куплено ").append(NumberConverter.toString(amount)).append(Emoji.FOOD).append(" за ")
                                .append(NumberConverter.toString(market.getFood().getBuyCost() * amount / market.getFood().getBuyAmount())).append("&#128176;\n");
                        storage.addFood(amount);
                        storage.reduceGold(market.getFood().getBuyCost() * amount / market.getFood().getBuyAmount());
                    }
                }
                break;
            case "iron":
                if(market.getIron().getBuyCost() * amount / market.getIron().getBuyAmount() > storage.getGold()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(market.getIron().getBuyCost() * amount / market.getIron().getBuyAmount() - storage.getGold()))
                            .append(Emoji.GOLD).append(" для покупки\n");
                }else{
                    if(amount + storage.getIron() > storage.getMaxIron()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад\n");
                    }else{
                        sb.append("Куплено ").append(NumberConverter.toString(amount)).append(Emoji.IRON).append(" за ")
                                .append(NumberConverter.toString(market.getIron().getBuyCost() * amount / market.getIron().getBuyAmount())).append("&#128176;\n");
                        storage.addIron(amount);
                        storage.reduceGold(market.getIron().getBuyCost() * amount / market.getIron().getBuyAmount());
                    }
                }
                break;
            case "stone":
                if(market.getStone().getBuyCost() * amount / market.getStone().getBuyAmount() > storage.getGold()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(market.getStone().getBuyCost() * amount / market.getStone().getBuyAmount() - storage.getGold()))
                            .append(Emoji.GOLD).append(" для покупки\n");
                }else{
                    if(amount + storage.getStone() > storage.getMaxStone()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад\n");
                    }else{
                        sb.append("Куплено ").append(NumberConverter.toString(amount)).append(Emoji.STONE).append(" за ")
                                .append(NumberConverter.toString(market.getStone().getBuyCost() * amount / market.getStone().getBuyAmount())).append("&#128176;\n");
                        storage.addStone(amount);
                        storage.reduceGold(market.getStone().getBuyCost() * amount / market.getStone().getBuyAmount());
                    }
                }
                break;
            case "wood":
                if(market.getWood().getBuyCost() * amount / market.getWood().getBuyAmount() > storage.getGold()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(market.getWood().getBuyCost() * amount / market.getWood().getBuyAmount() - storage.getGold()))
                            .append(Emoji.GOLD).append(" для покупки\n");
                }else{
                    if(amount + storage.getWood() > storage.getMaxWood()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад\n");
                    }else{
                        sb.append("Куплено ").append(NumberConverter.toString(amount)).append(Emoji.WOOD).append(" за ")
                                .append(NumberConverter.toString(market.getWood().getBuyCost() * amount / market.getWood().getBuyAmount())).append("&#128176;\n");
                        storage.addWood(amount);
                        storage.reduceGold(market.getWood().getBuyCost() * amount / market.getWood().getBuyAmount());
                    }
                }
                break;
        }

        sb.append(Emoji.STORAGE).append("\nСклад:\n")
                .append(NumberConverter.toString(storage.getFood())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxFood())).append(Emoji.FOOD).append("\n")
                .append(NumberConverter.toString(storage.getGold())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxGold())).append(Emoji.GOLD).append("\n")
                .append(NumberConverter.toString(storage.getIron())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxIron())).append(Emoji.IRON).append("\n")
                .append(NumberConverter.toString(storage.getStone())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxStone())).append(Emoji.STONE).append("\n")
                .append(NumberConverter.toString(storage.getWood())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxWood())).append(Emoji.WOOD).append("\n");

        bot.sendMessage(peerId, sb.toString(), null);
    }

}
