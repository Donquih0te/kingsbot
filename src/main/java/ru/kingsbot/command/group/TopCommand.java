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
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
                    .createQuery("from Player p where p.id > 0 and p.firstName <> null order by p.territory desc", Player.class);
            query.setMaxResults(10);
            List<Player> list = query.getResultList();
            sb.append(Emoji.TOP).append("Рейтинг игроков по территории:\n\n");
            List<Player> collect = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
            if(collect.isEmpty()) {
                return;
            }
            AtomicInteger i = new AtomicInteger(1);
            collect.forEach(p -> {
                sb.append(getEmoji(i.getAndIncrement())).append(" ").append(Utils.createLink(p)).append("  =>  ")
                        .append(NumberConverter.toString(p.getTerritory())).append("\n");
            });


            lastUpdate = Instant.now().getEpochSecond();
            lastResult = sb.toString();
        }

        bot.sendMessage(peerId, lastResult, null);
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
