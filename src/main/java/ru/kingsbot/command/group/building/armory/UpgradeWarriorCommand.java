package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.Map;

public class UpgradeWarriorCommand extends Command {

    public UpgradeWarriorCommand() {
        super("upgrade_warrior");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        if(payload.get("warrior") == null) {
            return;
        }
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
        if(warrior.getAmount() == 0) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Сначала купи воинов");
        }else{
            Storage storage = player.getStorage();
            boolean buy = true;
            if(storage.getFood() < warrior.getFoodUpgradeCost()) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для улучшения не хватает ")
                        .append(NumberConverter.toString(warrior.getFoodUpgradeCost() - storage.getFood()))
                        .append(Emoji.FOOD).append("\n");
                buy = false;
            }
            if(storage.getGold() < warrior.getGoldUpgradeCost()) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для улучшения не хватает ")
                        .append(NumberConverter.toString(warrior.getGoldUpgradeCost() - storage.getGold()))
                        .append(Emoji.GOLD).append("\n");
                buy = false;
            }
            if(storage.getIron() < warrior.getIronUpgradeCost()) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Для улучшения не хватает ")
                        .append(NumberConverter.toString(warrior.getIronUpgradeCost() - storage.getIron()))
                        .append(Emoji.IRON).append("\n");
                buy = false;
            }
            if(buy) {
                storage.reduceFood(warrior.getFoodUpgradeCost());
                storage.reduceGold(warrior.getGoldUpgradeCost());
                storage.reduceIron(warrior.getIronUpgradeCost());
                warrior.upgrade();
                sb.append(warrior.getName()).append(":\n")
                        .append(Emoji.LEVEL).append("Уровень: ").append(warrior.getLevel()).append("\n")
                        .append("Колличество: ").append(NumberConverter.toString(warrior.getAmount())).append("\n")
                        .append("Атака: ").append(warrior.getAttack()).append(Emoji.CLUBMAN).append("\n")
                        .append("Защита: ").append(warrior.getArmor()).append(Emoji.PROTECTION).append("\n\n")
                        .append("Улучшить:\n")
                        .append(NumberConverter.toString(warrior.getFoodUpgradeCost())).append(Emoji.FOOD)
                        .append(storage.getFood() - warrior.getFoodUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                        .append(NumberConverter.toString(warrior.getGoldUpgradeCost())).append(Emoji.GOLD)
                        .append(storage.getGold() - warrior.getGoldUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                        .append(NumberConverter.toString(warrior.getIronUpgradeCost())).append(Emoji.IRON)
                        .append(storage.getIron() - warrior.getIronUpgradeCost() > 0 ? " ✔" : " ❌").append("\n\n");
            }
        }

        playerService.sendMessage(peerId, sb.toString(), null);
    }
}
