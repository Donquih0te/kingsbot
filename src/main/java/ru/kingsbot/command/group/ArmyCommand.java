package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class ArmyCommand extends Command {

    public ArmyCommand() {
        super("army");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label(Emoji.ATTACK + "Атака")
                                .payload("command", "attack")
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
        Warrior warrior1 = null;
        Warrior warrior2 = null;
        switch(player.getAge()) {
            case PREHISTORIC:
                warrior1 = player.getArmy().getClubman();
                warrior2 = player.getArmy().getRockThrower();
                break;
        }
        if(warrior1 == null || warrior2 == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.CLUBMAN).append("[").append(warrior1.getLevel()).append("] Воин с дубиной: ")
                .append(NumberConverter.toString(warrior1.getAmount())).append("\n")
                .append(Emoji.ROCK_THROWER).append("[").append(warrior2.getLevel()).append("] Метатель камней: ")
                .append(NumberConverter.toString(warrior2.getAmount())).append("\n");

        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
