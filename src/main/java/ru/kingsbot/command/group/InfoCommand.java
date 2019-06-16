package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.command.keyboard.Keyboards;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Capitol;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.time.Instant;
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
        long currentTime = Instant.now().getEpochSecond();
        long shieldCancel = player.getPerk().getShieldCancel();
        Storage storage = player.getStorage();
        Capitol capitol = player.getCapitol();
        String t = null;
        if(currentTime < shieldCancel) {
            long hour = (shieldCancel - currentTime) / (60 * 60);
            long min = ((shieldCancel - currentTime) / 60) - hour * 60;
            long sec = (shieldCancel - currentTime) - (hour * 60 * 60 + min * 60);
            t = hour + ":" + min + ":" + sec;
        }else{
            t = "00:00:00";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Игровой ID: ").append(player.getId()).append("\n")
                .append("Эпоха: ").append(player.getAge().getName()).append(Emoji.AGE).append("\n")
                .append("Земли: ").append(player.getTerritory()).append(Emoji.TERRITORY).append("\n")
                .append("Щит: ").append(t).append("\n\n")
                .append("Свободно рабочих: ").append(capitol.getFreeCitizensAmount()).append(Emoji.FREE_CITIZEN).append("\n")
                .append("Рабочих: ").append(capitol.getCitizensAmount()).append("/").append(capitol.getMaxCitizensAmount()).append(Emoji.CITIZEN).append("\n\n")
                .append("Побед: ").append(player.getWins()).append(Emoji.GOLD_MEDAL).append("\n")
                .append("Поражений: ").append(player.getLesions()).append("\n\n")
                .append(Emoji.FOOD).append("Еда: ").append(NumberConverter.toString(storage.getFood())).append("  |  ")
                .append(NumberConverter.toString(storage.getMaxFood())).append("\n")
                .append(Emoji.GOLD).append("Золото: ").append(NumberConverter.toString(storage.getGold())).append("  |  ")
                .append(NumberConverter.toString(storage.getMaxGold())).append("\n")
                .append(Emoji.IRON).append("Железо: ").append(NumberConverter.toString(storage.getIron())).append("  |  ")
                .append(NumberConverter.toString(storage.getMaxIron())).append("\n")
                .append(Emoji.STONE).append("Камень: ").append(NumberConverter.toString(storage.getStone())).append("  |  ")
                .append(NumberConverter.toString(storage.getMaxStone())).append("\n")
                .append(Emoji.WOOD).append("Дерево: ").append(NumberConverter.toString(storage.getWood())).append("  |  ")
                .append(NumberConverter.toString(storage.getMaxWood())).append("\n\n");

        if(player.getFoodResource().isMined() || player.getGoldResource().isMined() || player.getIronResource().isMined() ||
                player.getStoneResource().isMined() || player.getWoodResource().isMined()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Есть истощенные ресурсы");
        }

        playerService.sendMessage(peerId, sb.toString(), Keyboards.getGroupKeyboard());
    }

}
