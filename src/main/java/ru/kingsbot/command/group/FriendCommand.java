package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;

import java.util.Map;

public class FriendCommand extends Command {

    public FriendCommand() {
        super("friend");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        StringBuilder sb = new StringBuilder();
        sb.append("Приглашай друзей и получай за них бонусы!\n")
                .append("За каждого нового друга ты можешь получить 100к").append(Emoji.GOLD).append("\n\n")
                .append("Твой друг должен написать команду боту:\n")
                .append("реф <").append(player.getId()).append(">\n\n")
                .append("Ты пригласил в игру: ").append(player.getInviteList().size());

        playerService.sendMessage(peerId, sb.toString(), null);
    }

}
