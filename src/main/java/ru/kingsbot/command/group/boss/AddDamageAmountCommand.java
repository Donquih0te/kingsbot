package ru.kingsbot.command.group.boss;

import ru.kingsbot.Emoji;
import ru.kingsbot.attack.BossAttack;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.utils.NumberConverter;

import java.util.Map;

public class AddDamageAmountCommand extends Command {

    public AddDamageAmountCommand() {
        super("add_damage_amount");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("warrior") == null || payload.get("amount") == null) {
            return;
        }
        int amount = Integer.parseInt(payload.get("amount"));
        Warrior warrior = null;
        switch(payload.get("warrior")) {
            case "clubman":
                warrior = player.getArmy().getClubman();
                break;
            case "rock_thrower":
                warrior = player.getArmy().getRockThrower();
                break;
        }
        if(warrior == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if(amount > warrior.getAmount()) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("У тебя нет столько войск.\n")
                    .append("Твои войска: ").append(warrior.getAmount());
        }else{
            BossAttack bossAttack = bot.getBossAttackMap().get(player.getId());
            warrior.remove(amount);
            long sumAttack = (long)(amount * warrior.getAttack() * warrior.getLevel());
            bossAttack.doAttack(player.getId(), sumAttack);
            sb.append("Нанесено урона: ").append(NumberConverter.toString(sumAttack)).append("\n\n")
                    .append("HP: ").append(NumberConverter.toString(bossAttack.getBoss().getHp())).append(Emoji.HEARTH).append("\n\n");

            if(bossAttack.isWin() || bossAttack.isLose()) {
                sb.append(Emoji.TIME).append("Бой заввершен");
                keyboard = bot.getKeyboard();
            }
        }


        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
