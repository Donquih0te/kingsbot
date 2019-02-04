package ru.kingsbot.command.group.market;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Map;

public class ChoseResourceCommand extends Command {

    public ChoseResourceCommand() {
        super("chose_resource_command");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("resource") == null || payload.get("action") == null) {
            return;
        }

        StringBuilder sb = new StringBuilder("Выбери количество\n");
        switch(payload.get("action")) {
            case "buy":
                keyboard = Keyboard.newKeyboard()
                        .row(List.of(
                                new Button(new Action("1k", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "1000")), Color.WHITE),
                                new Button(new Action("5k", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "5000")), Color.WHITE),
                                new Button(new Action("10k", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "10000")), Color.WHITE),
                                new Button(new Action("50k", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "50000")), Color.WHITE)
                            )
                        )
                        .row(List.of(
                                new Button(new Action("100k", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "100000")), Color.WHITE),
                                new Button(new Action("500k", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "500000")), Color.WHITE),
                                new Button(new Action("1kk", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "1000000")), Color.WHITE),
                                new Button(new Action("5kk", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "5000000")), Color.WHITE)
                            )
                        )
                        .row(List.of(
                                new Button(new Action("10kk", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "10000000")), Color.WHITE),
                                new Button(new Action("50kk", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "50000000")), Color.WHITE),
                                new Button(new Action("100kk", Map.of("command", "buy_resource_amount", "resource", payload.get("resource"), "amount", "100000000")), Color.WHITE)
                            )
                        )
                        .row(List.of(
                                new Button(new Action(Emoji.BACK + "Назад", Map.of("command", "back", "next", "buy_resource")), Color.WHITE),
                                new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                            )
                        )
                        .build();
                break;
            case "sell":
                keyboard = Keyboard.newKeyboard()
                        .row(List.of(
                                new Button(new Action("1k", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "1000")), Color.WHITE),
                                new Button(new Action("5k", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "5000")), Color.WHITE),
                                new Button(new Action("10k", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "10000")), Color.WHITE),
                                new Button(new Action("50k", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "50000")), Color.WHITE)
                            )
                        )
                        .row(List.of(
                                new Button(new Action("100k", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "100000")), Color.WHITE),
                                new Button(new Action("500k", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "500000")), Color.WHITE),
                                new Button(new Action("1kk", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "1000000")), Color.WHITE),
                                new Button(new Action("5kk", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "5000000")), Color.WHITE)
                                )
                        )
                        .row(List.of(
                                new Button(new Action("10kk", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "10000000")), Color.WHITE),
                                new Button(new Action("50kk", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "50000000")), Color.WHITE),
                                new Button(new Action("100kk", Map.of("command", "sell_resource_amount", "resource", payload.get("resource"), "amount", "100000000")), Color.WHITE)
                            )
                        )
                        .row(List.of(
                                new Button(new Action(Emoji.BACK + "Назад", Map.of("command", "back", "next", "sell_resource")), Color.WHITE),
                                new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                            )
                        )
                        .build();
                break;
        }

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
