package ru.kingsbot.command.chat;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TributeCommand extends Command {

    private static final Random RANDOM = new Random();
    private static final int TIMESTAMP = 20 * 60;

    private final SimpleDateFormat formatter = new SimpleDateFormat("mm мин ss сек");

    private Map<Integer, Long> players = new HashMap<>();

    public TributeCommand() {
        super("tribute");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Long currentTime = Instant.now().getEpochSecond();
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        Capitol capitol = player.getCapitol();
        if(!players.containsKey(player.getId()) || (currentTime - players.get(player.getId()) >= TIMESTAMP)) {
            int max = 2500 * player.getLevel() * capitol.getLevel();
            int min = 1000 * player.getLevel() * capitol.getLevel();
            int amount = RANDOM.nextInt(max - min) + min;
            storage.addGold(amount);
            player.addExperience(1);
            if(player.getCurrentExperience().intValue() == player.getMaxExperience().intValue()) {
                player.levelUp();
            }

            players.put(player.getId(), currentTime);
            sb.append(Utils.createLink(player)).append(", сбор дани с твоих поселений принес ")
                    .append(NumberConverter.toString(amount)).append(Emoji.GOLD).append("\n\n")
                    .append("Уровень: ").append(player.getLevel()).append("&#10024;\n")
                    .append("Опыт: ").append(player.getCurrentExperience()).append("/").append(player.getMaxExperience()).append("&#9889;");
        }else{
            sb.append(Utils.createLink(player)).append(", следующий сбор дани можно совершить через ")
                    .append(formatter.format(new Date((TIMESTAMP - (currentTime - players.get(player.getId()))) * 1000)));
        }

        bot.sendMessage(peerId, sb.toString(), bot.getChatKeyboard());
    }
}
