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
        sb.append("Помощь по игре: ").append("vk.com/@kingsbot-pomosch-po-igre").append("\n")
                .append("Помощь проекту: ").append("kingsbot.ru").append("\n\n")
                .append("Если тебя пригласили в игру, то ты можешь написать \"реф <ID пригласившего>\" и вы оба получите небольшой бонус");

        playerService.sendMessage(peerId, sb.toString(), null);
    }
}
