package ru.kingsbot.command.group.market;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.market.Market;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class BuyResourceCommand extends Command {

    public BuyResourceCommand() {
        super("buy_resource");
        keyboard = Keyboard.newKeyboard()
                .withRowButtons(List.of(
                        Button.newButton()
                                .label(Emoji.FOOD + "Еда")
                                .payload("command", "chose_resource")
                                .payload("resource", "food")
                                .payload("action", "buy")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.IRON + "Железо")
                                .payload("command", "chose_resource")
                                .payload("resource", "iron")
                                .payload("action", "buy")
                                .color(Color.WHITE)
                                .create()
                ))
                .withRowButtons(List.of(
                        Button.newButton()
                                .label(Emoji.STONE + "Камень")
                                .payload("command", "chose_resource")
                                .payload("resource", "stone")
                                .payload("action", "buy")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.WOOD + "Дерево")
                                .payload("command", "chose_resource")
                                .payload("resource", "wood")
                                .payload("action", "buy")
                                .color(Color.WHITE)
                                .create()
                ))
                .withRowButtons(List.of(
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "market")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .create();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        Storage storage = player.getStorage();
        Market market = marketService.load(1L);
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.STORAGE).append("Склад:\n")
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

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
