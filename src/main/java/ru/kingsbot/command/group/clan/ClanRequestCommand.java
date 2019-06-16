package ru.kingsbot.command.group.clan;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Keyboards;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class ClanRequestCommand extends Command {

    public ClanRequestCommand() {
        super("clan_request");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("action") == null || payload.get("from") == null || Utils.parseInt(payload.get("from")) < 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        int from = Utils.parseInt(payload.get("from"));
        switch(payload.get("action")) {
            case "accept":
                Clan clan = playerService.getById(from).getClan();
                player.setClan(clan);
                clan.addMember(player.getId());
                sb.append(Emoji.ACCEPT).append("Ты вступил в клан ").append(clan.getName());
                break;
            case "deny":
                sb.append(Emoji.DENY).append("Заявка на вступление в клан отклонена");
                break;
        }
        player.setClanRequest(null);
        playerService.sendMessage(peerId, sb.toString(), Keyboards.getGroupKeyboard());
    }
}
