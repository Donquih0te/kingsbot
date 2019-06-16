package ru.kingsbot.command.group.clan;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class HandlingCommand extends Command {

    public HandlingCommand() {
        super("clan_commands");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.INFO).append("Клановые команды:\n\n");
        if(player.getClan() == null) {
            sb.append(Emoji.WAVE).append(" клан создать <название>\n");
        }else{
            sb.append(Emoji.WAVE).append(" клан пригласить <id игрока>\n")
                    .append(Emoji.WAVE).append(" клан зам <id игрока> - назначить заместителя")
                    .append(Emoji.WAVE).append(" клан глава <id игрока> - передать главу")
                    .append(Emoji.WAVE).append(" клан имя <название> - сменить название клана")
                    .append(Emoji.WAVE).append(" клан покинуть - покинуть клан");
        }

        playerService.sendMessage(peerId, sb.toString(), null);
    }
}
