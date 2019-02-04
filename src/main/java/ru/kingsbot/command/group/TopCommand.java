package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import javax.persistence.TypedQuery;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class TopCommand extends Command {

    private Long lastUpdate;
    private String lastResult;

    public TopCommand() {
        super("top");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        long time = Instant.now().getEpochSecond();
        if(lastUpdate == null || time - lastUpdate > 60) {
            StringBuilder sb = new StringBuilder();

            TypedQuery<Player> query = HibernateUtil.getEntityManager()
                    .createQuery("from Player p order by p.territory desc", Player.class);
            query.setMaxResults(10);
            List<Player> list = query.getResultList();
            sb.append(Emoji.TOP).append("Рейтинг игроков по территории:\n");
            list.forEach(p -> {
                sb.append(Utils.createLink(p)).append("  ")
                        .append(NumberConverter.toString(p.getTerritory()))
                        .append(Emoji.TERRITORY).append("\n");
            });

            lastUpdate = Instant.now().getEpochSecond();
            lastResult = sb.toString();
        }

        bot.sendMessage(peerId, lastResult, null);
    }
}
