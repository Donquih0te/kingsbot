package ru.kingsbot.command.group.market;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.market.Market;
import ru.kingsbot.utils.NumberConverter;

import java.util.List;
import java.util.Map;

public class BuyResourceCommand extends Command {

    public BuyResourceCommand() {
        super("buy_resource");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.FOOD + "Еда", Map.of("command", "chose_resource", "action", "buy", "resource", "food")), Color.WHITE),
                        new Button(new Action(Emoji.IRON + "Железо", Map.of("command", "chose_resource", "action", "buy", "resource", "iron")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.STONE + "Камень", Map.of("command", "chose_resource", "action", "buy", "resource", "stone")), Color.WHITE),
                        new Button(new Action(Emoji.WOOD + "Дерево", Map.of("command", "chose_resource", "action", "buy", "resource", "wood")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action(Emoji.BACK + "Назад", Map.of("command", "back", "next", "market")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Storage storage = player.getStorage();
        Market market = bot.getMarket();
        StringBuilder sb = new StringBuilder();
        sb.append("Склад:\n")
                .append(NumberConverter.toString(storage.getFood())).append(Emoji.FOOD).append("\n")
                .append(NumberConverter.toString(storage.getGold())).append(Emoji.GOLD).append("\n")
                .append(NumberConverter.toString(storage.getIron())).append(Emoji.IRON).append("\n")
                .append(NumberConverter.toString(storage.getStone())).append(Emoji.STONE).append("\n")
                .append(NumberConverter.toString(storage.getWood())).append(Emoji.WOOD).append("\n\n")
                .append("Купить:\n")
                .append(market.getFood().getBuyAmount()).append(Emoji.FOOD).append(" за ")
                .append(market.getFood().getBuyCost()).append(Emoji.GOLD).append("\n")
                .append(market.getIron().getBuyAmount()).append(Emoji.IRON).append(" за ")
                .append(market.getIron().getBuyCost()).append(Emoji.GOLD).append("\n")
                .append(market.getStone().getBuyAmount()).append(Emoji.STONE).append(" за ")
                .append(market.getStone().getBuyCost()).append(Emoji.GOLD).append("\n")
                .append(market.getWood().getBuyAmount()).append(Emoji.WOOD).append(" за ")
                .append(market.getWood().getBuyCost()).append(Emoji.GOLD).append("\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
