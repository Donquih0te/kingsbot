package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class BuyWarriorCommand extends Command {

    public BuyWarriorCommand() {
        super("buy_warrior");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("warrior") == null) {
            return;
        }

        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label("100")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "100")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("500")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "500")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("1000")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "1000")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("5000")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "5000")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label("10k")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "10000")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("50k")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "50000")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("100k")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "100000")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("500k")
                                .payload("command", "buy_warrior_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "500000")
                                .color(Color.WHITE)
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "armory")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                    )
                )
                .build();

        playerService.sendMessage(peerId, "Выберите количество", keyboard);
    }
}
