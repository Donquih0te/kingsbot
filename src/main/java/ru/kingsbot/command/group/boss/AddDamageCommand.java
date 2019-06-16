package ru.kingsbot.command.group.boss;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class AddDamageCommand extends Command {

    public AddDamageCommand() {
        super("add_damage");
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
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "100")
                                .create(),
                        Button.newButton()
                                .label("500")
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "500")
                                .create(),
                        Button.newButton()
                                .label("1000")
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "1000")
                                .create(),
                        Button.newButton()
                                .label("5000")
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "5000")
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label("10k")
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "10000")
                                .create(),
                        Button.newButton()
                                .label("50k")
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "50000")
                                .create(),
                        Button.newButton()
                                .label("100k")
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "100000")
                                .create(),
                        Button.newButton()
                                .label("500k")
                                .payload("command", "add_damage_amount")
                                .payload("warrior", payload.get("warrior"))
                                .payload("amount", "500000")
                                .create()
                ))
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.BACK + "Назад")
                                .payload("command", "back")
                                .payload("next", "boss")
                                .color(Color.WHITE)
                                .create(),
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .build();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.RED_EXCLAMATION_MARK).append("Выберите количество воинов для атаки босса\n")
                .append("Количество снесенного урона зависит от количества и атаки ваших войск");
        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
