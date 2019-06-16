package ru.kingsbot.command.group.clan;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ClanRatingCommand extends Command {

    private String lastResult;
    private Long lastUpdate;

    public ClanRatingCommand() {
        super("clan_rating");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        long time = Instant.now().getEpochSecond();
        if(lastUpdate == null || time - lastUpdate > 60) {
            List<Clan> list = playerService.getClansRating();
            StringBuilder sb = new StringBuilder();
            if(list.isEmpty()) {
                sb.append("Пока ни один игрок не создал клан");
            }else{
                sb.append("Рейтинг кланов:\n");
                AtomicInteger i = new AtomicInteger(1);
                list.forEach(clan -> {
                    sb.append(getEmoji(i.getAndIncrement())).append(clan.getName()).append("  =>  ")
                            .append(NumberConverter.toString(clan.getRating()))
                            .append("\n");
                });
            }

            lastUpdate = Instant.now().getEpochSecond();
            lastResult = sb.toString();
        }
        playerService.sendMessage(peerId, lastResult, null);
    }

    private String getEmoji(int place) {
        switch(place) {
            case 1:
                return Emoji.GOLD_MEDAL;
            case 2:
                return Emoji.SILVER_MEDAL;
            case 3:
                return Emoji.BRONZE_MEDAL;
            default:
                return Emoji.TERRITORY;
        }
    }
}
