package ru.kingsbot.command.group;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.Map;

public class UserBannedCommand extends Command {

    public UserBannedCommand() {
        super("user_banned");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        playerService.sendMessage(peerId, "Вы заблокированы)))))\n Спасибо, что были с нами :)", null);
    }
}
