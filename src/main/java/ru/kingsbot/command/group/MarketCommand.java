package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class MarketCommand extends Command {

    public MarketCommand() {
        super("market");
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
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        //TODO: добавить торговца
        StringBuilder sb = new StringBuilder();
        sb.append("На рынке ты можешь купить или продать некоторые ресурсы.");
        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
