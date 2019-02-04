package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Map;

public class BuyWarriorCommand extends Command {

    public BuyWarriorCommand() {
        super("buy_warrior");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("warrior") == null) {
            return;
        }

        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("100", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "100")), Color.WHITE),
                        new Button(new Action("500", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "500")), Color.WHITE),
                        new Button(new Action("1000", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "1000")), Color.WHITE),
                        new Button(new Action("5000", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "5000")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action("10k", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "10000")), Color.WHITE),
                        new Button(new Action("50k", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "50000")), Color.WHITE),
                        new Button(new Action("100k", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "100000")), Color.WHITE),
                        new Button(new Action("500k", Map.of("command", "buy_warrior_amount", "warrior", payload.get("warrior"), "amount", "500000")), Color.WHITE)
                    )
                )
                .row(List.of(
                        new Button(new Action("&#128259;Назад", Map.of("command", "back", "next", "armory")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                    )
                )
                .build();

        bot.sendMessage(peerId, "Выберите количество", keyboard);
    }
}
