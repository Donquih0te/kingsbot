package ru.kingsbot.command.group.boss;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.boss.Boss;
import ru.kingsbot.utils.NumberConverter;

import java.util.List;
import java.util.Map;

public class BossTypeCommand extends Command {

    public BossTypeCommand() {
        super("boss_type");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("boss") == null) {
            return;
        }
        keyboard = Keyboard.newKeyboard()
                .row(List.of(new Button(new Action(Emoji.ARMORY + "Бой", Map.of("command", "boss_attack", "boss", payload.get("boss"))), Color.RED)))
                .row(List.of(new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)))
                .build();

        Boss boss = bot.getBossMap().getBoss(payload.get("boss"));
        if(boss == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.BOSS_TYPE).append(boss.getCustomName()).append(":\n\n")
                .append("HP: ").append(boss.getMaxHp()).append(Emoji.HEARTH).append("\n")
                .append("Побед: ").append(player.getBossInfo().getWins(boss)).append(Emoji.TOP).append("\n")
                .append("Ключей: ").append(player.getBossInfo().getKeys(boss)).append(Emoji.KEY).append("\n\n")
                .append("Награда за победу:\n")
                .append(NumberConverter.toString(boss.getFoodReward())).append(Emoji.FOOD).append("  ")
                .append(NumberConverter.toString(boss.getGoldReward())).append(Emoji.GOLD).append("  ")
                .append(NumberConverter.toString(boss.getIronReward())).append(Emoji.IRON).append("  ")
                .append(NumberConverter.toString(boss.getStoneReward())).append(Emoji.STONE).append("  ")
                .append(NumberConverter.toString(boss.getWoodReward())).append(Emoji.WOOD).append("  ");
        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
