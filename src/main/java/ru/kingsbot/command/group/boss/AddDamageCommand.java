package ru.kingsbot.command.group.boss;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Map;

public class AddDamageCommand extends Command {

    public AddDamageCommand() {
        super("add_damage");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("warrior") == null) {
            return;
        }
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("100", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "100")), Color.WHITE),
                        new Button(new Action("500", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "500")), Color.WHITE),
                        new Button(new Action("1000", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "1000")), Color.WHITE),
                        new Button(new Action("5000", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "5000")), Color.WHITE)
                        )
                )
                .row(List.of(
                        new Button(new Action("10k", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "10000")), Color.WHITE),
                        new Button(new Action("50k", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "50000")), Color.WHITE),
                        new Button(new Action("100k", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "100000")), Color.WHITE),
                        new Button(new Action("500k", Map.of("command", "add_damage_amount", "warrior", payload.get("warrior"), "amount", "500000")), Color.WHITE)
                        )
                )
                .row(List.of(
                        new Button(new Action("&#128259;Назад", Map.of("command", "back", "next", "boss")), Color.WHITE),
                        new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
                        )
                )
                .build();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.RED_EXCLAMATION_MARK).append("Выберите количество воинов для атаки босса\n")
                .append("Количество снесенного урона зависит от количества и атаки ваших войск");
        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
