package ru.kingsbot.command.group;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.Map;

public class NotFoundCommand extends Command {

    public NotFoundCommand() {
        super("not_found");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        bot.sendMessage(peerId, "Неизвестная команда", bot.getKeyboard());
    }
}
