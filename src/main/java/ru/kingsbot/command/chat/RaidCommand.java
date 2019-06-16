package ru.kingsbot.command.chat;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Keyboards;
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

public class RaidCommand extends Command {

    private static final Random RANDOM = new Random();
    private static final int TIMESTAMP = 20 * 60;

    private final SimpleDateFormat formatter = new SimpleDateFormat("mm мин ss сек");

    private Map<Integer, Long> players = new HashMap<>();

    public RaidCommand() {
        super("raid");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Long currentTime = Instant.now().getEpochSecond();
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        Capitol capitol = player.getCapitol();
        if(!players.containsKey(player.getId()) || players.get(player.getId()) <= currentTime) {
            if(capitol.getFreeCitizensAmount() > 0) {
                player.addExperience(1);
                if(player.getCurrentExperience().intValue() == player.getMaxExperience().intValue()) {
                    player.levelUp();
                }
                int level = player.getLevel();
                int freeCitizens = capitol.getFreeCitizensAmount();

                int max = 1000 * level * freeCitizens;
                int min = 200 * level * freeCitizens;
                int goldAmount = RANDOM.nextInt(max - min) + min;
                int ironAmount = RANDOM.nextInt(max - min) + min;
                int woodAmount = RANDOM.nextInt(max - min) + min;
                storage.addGold(goldAmount);
                storage.addIron(ironAmount);
                storage.addWood(woodAmount);

                sb.append(Utils.createLink(player)).append(", ты совершил набег на близлижайшее поселение.\n\n")
                        .append("В результате набега получено: \n")
                        .append(NumberConverter.toString(goldAmount)).append(Emoji.GOLD).append("  ")
                        .append(NumberConverter.toString(ironAmount)).append(Emoji.IRON).append("  ")
                        .append(NumberConverter.toString(woodAmount)).append(Emoji.WOOD).append("\n\n")
                        .append(Emoji.LEVEL).append("Уровень: ").append(level).append("\n")
                        .append(Emoji.EXPERIENCE).append("Опыт: ").append(player.getCurrentExperience()).append("/").append(player.getMaxExperience());
                players.put(player.getId(), Instant.now().plusSeconds(TIMESTAMP).getEpochSecond());
            }else{
                sb.append(Utils.createLink(player)).append(", у тебя нет свободных рабочих чтобы совершить набег.\n")
                        .append("Создать новых рабочих можно в \"Строения\" -> \"Капитолий\"");
            }
        }else{
            sb.append(Utils.createLink(player)).append(", твои люди устали после прошлого набега. Следующий набег можно совершить через ")
                    .append(formatter.format(new Date((players.get(player.getId()) - currentTime) * 1000)));
        }

        playerService.sendMessage(peerId, sb.toString(), Keyboards.getChatKeyboard());
    }

}
