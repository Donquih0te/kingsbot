package ru.kingsbot.command.group;

import ru.kingsbot.api.keyboard.Keyboards;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class NotFoundCommand extends Command {

    public NotFoundCommand() {
        super("not_found");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        playerService.sendMessage(peerId, "Неизвестная команда", Keyboards.getGroupKeyboard());
    }
}
