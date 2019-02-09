package ru.kingsbot.command.chat;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Keyboards;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class HuntingCommand extends Command {

    private static final Random RANDOM = new Random();

    private static final int TIMESTAMP = 60 * 15;
    private final SimpleDateFormat formatter = new SimpleDateFormat("mm мин ss сек");

    private Map<Integer, Long> players = new HashMap<>();
    private List<String> list = new ArrayList<>();

    public HuntingCommand() {
        super("hunting");
        list.add("тебе повезло и ты наткнулся на оленя.");
        list.add("в роще ты нактнулся на медведя и одолел его.");
        list.add("на поле ты встретил стаю диких зайцев.");
        list.add("на твоем пути стоит болото с лягушками.");
        list.add("ты накнулся на стаю хищников. Твои люди чудом остались живы");
        list.add("на тебя напало племя диких оборигенов. Охота прошла неудачно");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        long currentTime = Instant.now().getEpochSecond();
        StringBuilder sb = new StringBuilder();
        Capitol capitol = player.getCapitol();
        if(!players.containsKey(player.getId()) || players.get(player.getId()) <= currentTime) {
            if(capitol.getFreeCitizensAmount() > 0) {
                int i = RANDOM.nextInt(list.size() - 1);
                player.addExperience(1);
                if(player.getCurrentExperience().intValue() == player.getMaxExperience().intValue()) {
                    player.levelUp();
                }
                int level = player.getLevel();
                int freeCitizens = capitol.getFreeCitizensAmount();
                if(i < 4) {
                    int max = 1000 * level * freeCitizens;
                    int min = 200 * level * freeCitizens;
                    int amount = RANDOM.nextInt(max - min) + min;
                    sb.append(Utils.createLink(player)).append(", ").append(list.get(i)).append(" Это принесло тебе ")
                            .append(NumberConverter.toString(amount)).append(Emoji.FOOD).append("\n\n");
                    player.getStorage().addFood(amount);
                }else{
                    sb.append(Utils.createLink(player)).append(", ").append(list.get(i)).append("\n\n");
                }

                sb.append(Emoji.LEVEL).append("Уровень: ").append(level).append("\n")
                        .append(Emoji.EXPERIENCE).append("Опыт: ").append(player.getCurrentExperience()).append("/").append(player.getMaxExperience());
                players.put(player.getId(), Instant.now().plusSeconds(TIMESTAMP).getEpochSecond());
            }else{
                sb.append(Utils.createLink(player)).append(", у тебя нет свободных рабочих чтобы идти на охоту.\n")
                .append("Создать новых рабочих можно в \"Строения\" -> \"Капитолий\"");
            }
        }else{
            sb.append(Utils.createLink(player)).append(", твои люди устали после прошлой охоты. В следующий поход можно пойти через ")
                    .append(formatter.format(new Date((players.get(player.getId()) - currentTime) * 1000)));
        }

        playerService.sendMessage(peerId, sb.toString(), Keyboards.getChatKeyboard());
    }

}
