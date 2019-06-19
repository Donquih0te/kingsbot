package ru.kingsbot.command.group.market;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class ChoseResourceCommand extends Command {

    public ChoseResourceCommand() {
        super("chose_resource_command");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("resource") == null || payload.get("action") == null) {
            return;
        }

        StringBuilder sb = new StringBuilder("Выбери количество\n");
        switch(payload.get("action")) {
            case "buy":
                keyboard = Keyboard.newKeyboard()
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label("1k")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "1000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("5k")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "5000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("10k")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "10000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("50k")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "50000")
                                        .color(Color.WHITE)
                                        .create()
                        ))
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label("100k")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "100000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("500k")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "500000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("1kk")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "1000000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("5kk")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "5000000")
                                        .color(Color.WHITE)
                                        .create()
                            )
                        )
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label("10kk")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "10000000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("50kk")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "50000000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("100kk")
                                        .payload("command", "buy_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "100000000")
                                        .color(Color.WHITE)
                                        .create()
                        ))
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label(Emoji.BACK + "Назад")
                                        .payload("command", "back")
                                        .payload("next", "buy_resource")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("Главная")
                                        .payload("command", "info")
                                        .color(Color.BLUE)
                                        .create()
                            )
                        )
                        .create();
                break;
            case "sell":
                keyboard = Keyboard.newKeyboard()
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label("1k")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "1000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("5k")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "5000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("10k")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "10000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("50k")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "50000")
                                        .color(Color.WHITE)
                                        .create()
                            )
                        )
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label("100k")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "100000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("500k")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "500000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("1kk")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "1000000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("5kk")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "5000000")
                                        .color(Color.WHITE)
                                        .create()                                )
                        )
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label("10kk")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "10000000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("50kk")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "50000000")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("100kk")
                                        .payload("command", "sell_resource_amount")
                                        .payload("resource", payload.get("resource"))
                                        .payload("amount", "100000000")
                                        .color(Color.WHITE)
                                        .create()
                        ))
                        .withRowButtons(List.of(
                                Button.newButton()
                                        .label(Emoji.BACK + "Назад")
                                        .payload("command", "back")
                                        .payload("next", "sell_resource")
                                        .color(Color.WHITE)
                                        .create(),
                                Button.newButton()
                                        .label("Главная")
                                        .payload("command", "info")
                                        .color(Color.BLUE)
                                        .create()
                            )
                        )
                        .create();
                break;
        }

        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
