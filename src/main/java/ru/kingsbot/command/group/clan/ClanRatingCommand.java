package ru.kingsbot.command.group.clan;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.NumberConverter;

import javax.persistence.TypedQuery;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ClanRatingCommand extends Command {

    private String lastResult;
    private Long lastUpdate;

    public ClanRatingCommand() {
        super("clan_rating");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        long time = Instant.now().getEpochSecond();
        if(lastUpdate == null || time - lastUpdate > 60) {
            StringBuilder sb = new StringBuilder("Рейтинг кланов:\n");

            TypedQuery<Clan> query = HibernateUtil.getEntityManager()
                    .createQuery("select clan from Clan clan order by clan.rating desc", Clan.class);
            query.setMaxResults(10);
            List<Clan> list = query.getResultList();

            list.forEach(clan -> {
                sb.append(clan.getName()).append(": ")
                        .append(NumberConverter.toString(clan.getRating()))
                        .append(Emoji.TOP).append("\n");
            });

            lastUpdate = Instant.now().getEpochSecond();
            lastResult = sb.toString();
        }
        bot.sendMessage(peerId, lastResult, null);
    }
}
