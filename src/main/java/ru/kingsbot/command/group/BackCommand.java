package ru.kingsbot.command.group;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.Collections;
import java.util.Map;

public class BackCommand extends Command {

    public BackCommand() {
        super("back");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("next") == null) {
            return;
        }
        player.updateResources();
        playerService.update(player);
        Command next = bot.getCommandMap().getCommand(payload.get("next"));
        next.execute(player, peerId, Collections.emptyMap());
    }
}
