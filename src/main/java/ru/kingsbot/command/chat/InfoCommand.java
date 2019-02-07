package ru.kingsbot.command.chat;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Keyboards;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class InfoCommand extends Command {

    public InfoCommand() {
        super("info");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(player.getFirstName() == null) {
            playerService.validateName(player);
        }
        if(player.updateResources()) {
            playerService.update(player);
        }
        StringBuilder sb = new StringBuilder();
        Storage storage = player.getStorage();
        Capitol capitol = player.getCapitol();
        sb.append(Utils.createLink(player)).append(", твоя статистика:\n\n")
                .append("Игровой ID: ").append(player.getId()).append("\n")
                .append("Эпоха: ").append(player.getAge().getName()).append(Emoji.AGE).append("\n")
                .append("Земли: ").append(player.getTerritory()).append(Emoji.TERRITORY).append("\n\n")
                .append("Побед: ").append(player.getWins()).append(Emoji.GOLD_MEDAL).append("\n")
                .append("Поражений: ").append(player.getLesions()).append("\n\n")
                .append("Свободно рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.FREE_CITIZEN).append("\n")
                .append("Рабочих: ").append(capitol.getCitizensAmount()).append("/").append(capitol.getMaxCitizensAmount()).append(Emoji.CITIZEN).append("\n\n")
                .append(Emoji.FOOD).append("Еда: ").append(NumberConverter.toString(storage.getFood())).append("\n")
                .append(Emoji.GOLD).append("Золото: ").append(NumberConverter.toString(storage.getGold())).append("\n")
                .append(Emoji.IRON).append("Железо: ").append(NumberConverter.toString(storage.getIron())).append("\n")
                .append(Emoji.STONE).append("Камень: ").append(NumberConverter.toString(storage.getStone())).append("\n")
                .append(Emoji.WOOD).append("Дерево: ").append(NumberConverter.toString(storage.getWood())).append("\n");

        playerService.sendMessage(peerId, sb.toString(), Keyboards.getChatKeyboard());
    }
}
