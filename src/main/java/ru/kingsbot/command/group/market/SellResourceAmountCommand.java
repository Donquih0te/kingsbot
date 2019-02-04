package ru.kingsbot.command.group.market;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.market.Market;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class SellResourceAmountCommand extends Command {

    public SellResourceAmountCommand() {
        super("sell_resource_amount");
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
        long amount = Integer.parseInt(payload.get("amount"));
        switch(payload.get("resource")) {
            case "food":
                if(amount > storage.getFood()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(amount - storage.getFood())).append(Emoji.FOOD).append(" для продажи\n");
                }else{
                    if(market.getFood().getSellCost() * amount / market.getFood().getSellAmount() + storage.getGold() > storage.getMaxGold()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад");
                    }else{
                        sb.append("Продано ").append(NumberConverter.toString(amount)).append(Emoji.FOOD).append(" за ")
                                .append(NumberConverter.toString(market.getFood().getSellCost() * amount / market.getFood().getSellAmount()))
                                .append(Emoji.GOLD).append("\n");
                        storage.reduceFood(amount);
                        storage.addGold(market.getFood().getSellCost() * amount / market.getFood().getSellAmount());
                    }
                }
                break;
            case "iron":
                if(amount > storage.getIron()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(amount - storage.getIron())).append(Emoji.IRON).append(" для продажи\n");
                }else{
                    if(market.getIron().getSellCost() * amount / market.getIron().getSellAmount() + storage.getGold() > storage.getMaxGold()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад");
                    }else{
                        sb.append("Продано ").append(NumberConverter.toString(amount)).append(Emoji.IRON).append(" за ")
                                .append(NumberConverter.toString(market.getIron().getSellCost() * amount / market.getIron().getSellAmount()))
                                .append(Emoji.GOLD).append("\n");
                        storage.reduceIron(amount);
                        storage.addGold(market.getIron().getSellCost() * amount / market.getIron().getSellAmount());
                    }
                }
                break;
            case "stone":
                if(amount > storage.getStone()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(amount - storage.getStone())).append(Emoji.STONE).append(" для продажи\n");
                }else{
                    if(market.getStone().getSellCost() * amount / market.getStone().getSellAmount() + storage.getGold() > storage.getMaxGold()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад");
                    }else{
                        sb.append("Продано ").append(NumberConverter.toString(amount)).append(Emoji.STONE).append(" за ")
                                .append(NumberConverter.toString(market.getStone().getSellCost() * amount / market.getStone().getSellAmount()))
                                .append(Emoji.GOLD).append("\n");
                        storage.reduceStone(amount);
                        storage.addGold(market.getStone().getSellCost() * amount / market.getStone().getSellAmount());
                    }
                }
                break;
            case "wood":
                if(amount > storage.getWood()) {
                    sb.append("Не хватает ")
                            .append(NumberConverter.toString(amount - storage.getWood())).append(Emoji.WOOD).append(" для продажи\n");
                }else{
                    if(market.getWood().getSellCost() * amount / market.getWood().getSellAmount() + storage.getGold() > storage.getMaxGold()) {
                        sb.append("На складе не хватает места. Выбери количество поменьше или прокачай склад");
                    }else{
                        sb.append("Продано ").append(NumberConverter.toString(amount)).append(Emoji.WOOD).append(" за ")
                                .append(NumberConverter.toString(market.getWood().getSellCost() * amount / market.getWood().getSellAmount()))
                                .append(Emoji.GOLD).append("\n");
                        storage.reduceWood(amount);
                        storage.addGold(market.getWood().getSellCost() * amount / market.getWood().getSellAmount());
                    }
                }
                break;
        }

        sb.append("Склад\n")
                .append(NumberConverter.toString(storage.getFood())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxFood())).append(Emoji.FOOD).append("\n")
                .append(NumberConverter.toString(storage.getGold())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxGold())).append(Emoji.GOLD).append("\n")
                .append(NumberConverter.toString(storage.getIron())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxIron())).append(Emoji.IRON).append(";\n")
                .append(NumberConverter.toString(storage.getStone())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxStone())).append(Emoji.STONE).append("\n")
                .append(NumberConverter.toString(storage.getWood())).append(" | ")
                .append(NumberConverter.toString(storage.getMaxWood())).append(Emoji.WOOD).append("\n");

        bot.sendMessage(peerId, sb.toString(), null);
    }
}
