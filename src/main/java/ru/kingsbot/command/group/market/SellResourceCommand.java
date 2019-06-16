package ru.kingsbot.command.group.market;

import ru.kingsbot.Emoji;
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

public class SellResourceCommand extends Command {

    public SellResourceCommand() {
        super("sell_resource");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.FOOD + "Еда")
                                .payload("command", "chose_resource")
                                .payload("resource", "food")
                                .payload("action", "sell")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.IRON + "Железо")
                                .payload("command", "chose_resource")
                                .payload("resource", "iron")
                                .payload("action", "sell")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.STONE + "Камень")
                                .payload("command", "chose_resource")
                                .payload("resource", "stone")
                                .payload("action", "sell")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.WOOD + "Дерево")
                                .payload("command", "chose_resource")
                                .payload("resource", "wood")
                                .payload("action", "sell")
                                .color(Color.WHITE)
                                .create()
                        )
                )
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "market")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton().label("Главная").payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .build();
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
                .append("Продать:\n")
                .append(market.getFood().getSellAmount()).append(Emoji.FOOD).append(" за  ")
                .append(market.getFood().getSellCost()).append(Emoji.GOLD).append("\n")
                .append(market.getIron().getSellAmount()).append(Emoji.IRON).append(" за  ")
                .append(market.getIron().getSellCost()).append(Emoji.GOLD).append("\n")
                .append(market.getStone().getSellAmount()).append(Emoji.STONE).append(" за  ")
                .append(market.getStone().getSellCost()).append(Emoji.GOLD).append("\n")
                .append(market.getWood().getSellAmount()).append(Emoji.WOOD).append(" за  ")
                .append(market.getWood().getSellCost()).append(Emoji.GOLD).append("\n");

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
