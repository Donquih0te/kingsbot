package ru.kingsbot.command.group;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        StringBuilder sb = new StringBuilder();
        sb.append("Скоро здесь будет описание игры\n")
                //.append("Помощь по игре: ").append("ссылка на статью").append("\n")
                .append("Помощь проекту: ").append("kingsbot.ru");

        bot.sendMessage(peerId, sb.toString(), null);
    }
}
