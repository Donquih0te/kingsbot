package ru.kingsbot.command.group.boss;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.game.boss.Boss;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Map;

public class BossTypeCommand extends Command {

    public BossTypeCommand() {
        super("boss_type");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        keyboard = Keyboard.newKeyboard()
                .withRowButtons(List.of(
                        Button.newButton()
                                .label(Emoji.ARMORY + "Бой")
                                .payload("command", "boss_attack")
                                .payload("boss", payload.get("boss"))
                                .color(Color.GREEN)
                                .create(),
                        Button.newButton()
                                .label("Главная")
                                .payload("command", "info")
                                .color(Color.BLUE)
                                .create()
                ))
                .create();

        Boss boss = bot.getBossMap().getBoss(payload.get("boss"));
        if(boss == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.BOSS_TYPE).append(boss.getCustomName()).append(":\n")
                .append("HP: ").append(NumberConverter.toString(boss.getMaxHp())).append(Emoji.HEARTH).append("\n")
                .append("Побед: ").append(player.getBossInfo().getWins(boss)).append(Emoji.TOP).append("\n")
                .append("Ключей: ").append(player.getBossInfo().getKeys(boss)).append(Emoji.KEY).append("\n\n")
                .append("Награда за победу:\n")
                .append(NumberConverter.toString(boss.getFoodReward())).append(Emoji.FOOD).append("  ")
                .append(NumberConverter.toString(boss.getGoldReward())).append(Emoji.GOLD).append("  ")
                .append(NumberConverter.toString(boss.getIronReward())).append(Emoji.IRON).append("  ")
                .append(NumberConverter.toString(boss.getStoneReward())).append(Emoji.STONE).append("  ")
                .append(NumberConverter.toString(boss.getWoodReward())).append(Emoji.WOOD).append("  ");
        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
