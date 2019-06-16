package ru.kingsbot.command.group.army;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.game.attack.PlayerAttack;
import ru.kingsbot.utils.Utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
        sb.append("Атаки отключены для устранения неполадок. В скором времени все вернется");
        Long currentTime = Instant.now().getEpochSecond();
        if(!players.containsKey(player.getId()) || (currentTime - players.get(player.getId()) > TIMESTAMP)) {
            List<Player> targets = playerService.getEnemyToAttack(player);
            Player target = Utils.getRandomValueFromList(targets);
            if(target == null) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Противников не найдено, попробуй позже");
            }else{
                if(target.getFirstName() == null) {
                    playerService.validateName(target);
                }

                PlayerAttack attack = new PlayerAttack(player, target);
                attack.doAttack();

                playerService.sendMessage(peerId, attack.getWhoResult(), null);
                playerService.sendMessage(target, attack.getTargetResult(), null);
                players.put(player.getId(), currentTime);
            }
        }else{
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Следующую атаку на королевство можно совершить через ")
                    .append(formatter.format(new Date((TIMESTAMP - (currentTime - players.get(player.getId()))) * 1000)));
        }
        playerService.sendMessage(peerId, sb.toString(), null);
    }
}
