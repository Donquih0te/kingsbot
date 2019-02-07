package ru.kingsbot.command.chat;

import ru.kingsbot.api.keyboard.Keyboards;
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
        if(!players.containsKey(player.getId()) || (currentTime - players.get(player.getId()) >= TIMESTAMP)) {
            if(capitol.getFreeCitizensAmount() != 0) {
                int max = 1000 * player.getLevel() * capitol.getFreeCitizensAmount();
                int min = 200 * player.getLevel() * capitol.getFreeCitizensAmount();
                int goldAmount = RANDOM.nextInt(max - min) + min;
                int ironAmount = RANDOM.nextInt(max - min) + min;
                int woodAmount = RANDOM.nextInt(max - min) + min;
                storage.addGold(goldAmount);
                storage.addIron(ironAmount);
                storage.addWood(woodAmount);
                player.addExperience(1);
                if(player.getCurrentExperience().intValue() == player.getMaxExperience().intValue()) {
                    player.levelUp();
                }

                players.put(player.getId(), currentTime);
                sb.append(Utils.createLink(player)).append(", ты совершил набег на близлижайшее поселение.\n\n")
                        .append("В результате набега получено: \n")
                        .append(NumberConverter.toString(goldAmount)).append("&#128176;  ")
                        .append(NumberConverter.toString(ironAmount)).append("&#9725;  ")
                        .append(NumberConverter.toString(woodAmount)).append("&#127795;\n\n")
                        .append("Уровень: ").append(player.getLevel()).append("&#10024;\n")
                        .append("Опыт: ").append(player.getCurrentExperience()).append("/").append(player.getMaxExperience()).append("&#9889;");
            }else{
                sb.append(Utils.createLink(player)).append(", у тебя нет свободных рабочих чтобы совершить набег.");
            }
        }else{
            sb.append(Utils.createLink(player)).append(", твои люди устали после прошлого набега. Следующий набег можно совершить через ")
                    .append(formatter.format(new Date((TIMESTAMP - (currentTime - players.get(player.getId()))) * 1000)));
        }

        playerService.sendMessage(peerId, sb.toString(), Keyboards.getChatKeyboard());
    }

}
