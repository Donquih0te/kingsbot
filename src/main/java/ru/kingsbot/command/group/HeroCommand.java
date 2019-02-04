package ru.kingsbot.command.group;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.age.Age;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class HeroCommand extends Command {

    public HeroCommand() {
        super("hero");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(player.getAge() != Age.COPPER) {
            bot.sendMessage(peerId, "Герои станут доступны с Эпохи: Медный век", null);
        }
    }
}
