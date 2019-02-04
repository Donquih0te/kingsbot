package ru.kingsbot.command.group;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class StartCommand extends Command {

    public StartCommand() {
        super("start");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        StringBuilder sb = new StringBuilder();
        sb.append("Создано новое королевство.");// Полная инструкция по игре: <ссылка на статью>");

        bot.sendMessage(peerId, sb.toString(), bot.getKeyboard());
    }

}
