package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Map;

public class MarketCommand extends Command {

    public MarketCommand() {
        super("market");
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.PLUS + "Купить", Map.of("command", "buy_resource")), Color.WHITE),
                        new Button(new Action(Emoji.MINUS + "Продать", Map.of("command", "sell_resource")), Color.WHITE)
                    )
                )
                .row(List.of(new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)))
                .build();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        //TODO: добавить торговца
        StringBuilder sb = new StringBuilder();
        sb.append("На рынке ты можешь купить или продать некоторые ресурсы.");
        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
