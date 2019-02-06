package ru.kingsbot.command.group.army;

import ru.kingsbot.Emoji;
import ru.kingsbot.attack.PlayerAttack;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.Utils;

import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AttackCommand extends Command {

    private static final long TIMESTAMP = 60 * 20;

    private final SimpleDateFormat formatter = new SimpleDateFormat("mm мин ss сек");
    private Map<Integer, Long> players = new HashMap<>();

    public AttackCommand() {
        super("attack");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        StringBuilder sb = new StringBuilder();
        Long currentTime = Instant.now().getEpochSecond();
        if(!players.containsKey(player.getId()) || (currentTime - players.get(player.getId()) > TIMESTAMP)) {
            TypedQuery<Player> query = HibernateUtil.getEntityManager()
                    .createQuery("Select p from Player p inner join Perk perk on perk.id = p.id " +
                            "where p.id != :id " +
                            "and p.id > 0 " +
                            "and p.firstName <> null " +
                            "and perk.shieldCancel < :time " +
                            "and p.age = :age " +
                            "and round(p.territory) > round(:territory / 1.2) " +
                            "and round(p.territory) < round(:territory * 1.2)", Player.class);

            query.setParameter("id", player.getId());
            query.setParameter("time", currentTime);
            query.setParameter("age", player.getAge());
            query.setParameter("territory", Double.valueOf(player.getTerritory()));
            query.setMaxResults(5);

            Player target = Utils.getRandomValueFromList(query.getResultList());
            if(target == null) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Противников не найдено, попробуй позже");
            }else{
                if(target.getFirstName() == null) {
                    bot.setName(target);
                }
                PlayerAttack attack = new PlayerAttack(player, target);
                attack.doAttack();
                bot.sendMessage(peerId, attack.getWhoResult(), null);
                bot.sendMessage(target.getId(), attack.getTargetResult(), null);
                players.put(player.getId(), currentTime);
            }
        }else{
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Следующую атаку на королевство можно совершить через ")
                    .append(formatter.format(new Date((TIMESTAMP - (currentTime - players.get(player.getId()))) * 1000)));
        }
        bot.sendMessage(peerId, sb.toString(), null);
    }
}
