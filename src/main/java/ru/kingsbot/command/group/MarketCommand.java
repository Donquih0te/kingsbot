package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class MarketCommand extends Command {

    public MarketCommand() {
        super("market");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.PLUS + "Купить")
                                .payload("command", "buy_resource")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label(Emoji.MINUS + "Продать")
                                .payload("command", "sell_resource")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .build();
        //TODO: добавить торговца
        StringBuilder sb = new StringBuilder();
        sb.append("На рынке ты можешь купить или продать некоторые ресурсы.");
        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
