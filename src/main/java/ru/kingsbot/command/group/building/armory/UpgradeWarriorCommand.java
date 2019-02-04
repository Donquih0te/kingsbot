package ru.kingsbot.command.group.building.armory;

import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Warrior;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;

import java.util.Map;

public class UpgradeWarriorCommand extends Command {

    public UpgradeWarriorCommand() {
        super("upgrade_warrior");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
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
            sb.append("Сначала купи воинов");
        }else{
            Storage storage = player.getStorage();
            boolean buy = true;
            if((long)warrior.getFoodUpgradeCost() > storage.getFood()) {
                sb.append("Для улучшения не хватает ")
                        .append(NumberConverter.toString((long)warrior.getFoodUpgradeCost() - storage.getFood()))
                        .append("&#127830;\n");
                buy = false;
            }
            if((long)warrior.getGoldUpgradeCost() > storage.getGold()) {
                sb.append("Для улучшения не хватает ")
                        .append(NumberConverter.toString((long)warrior.getGoldUpgradeCost() - storage.getGold()))
                        .append("&#128176;\n");
                buy = false;
            }
            if((long)warrior.getIronUpgradeCost() > storage.getIron()) {
                sb.append("Для улучшения не хватает ")
                        .append(NumberConverter.toString((long)warrior.getIronUpgradeCost() - storage.getIron()))
                        .append("&#9725;\n");
                buy = false;
            }
            if(buy) {
                warrior.upgrade();
                storage.reduceFood(warrior.getFoodUpgradeCost());
                storage.reduceGold(warrior.getGoldUpgradeCost());
                storage.reduceIron(warrior.getIronUpgradeCost());
                sb.append("Уровень: ").append(warrior.getLevel()).append("\n")
                        .append("Колличество: ").append(NumberConverter.toString(warrior.getAmount())).append("\n")
                        .append("HP: ").append(warrior.getHealth()).append("&#129505;\n")
                        .append("Атака: ").append(warrior.getAttack()).append("&#9876;\n")
                        .append("Защита: ").append(warrior.getArmor()).append("&#128737;\n\n")
                        .append("Улучшить:\n")
                        .append(NumberConverter.toString(warrior.getFoodUpgradeCost())).append("&#127830;")
                        .append(storage.getFood() - warrior.getFoodUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                        .append(NumberConverter.toString(warrior.getGoldUpgradeCost())).append("&#128176;")
                        .append(storage.getGold() - warrior.getGoldUpgradeCost() > 0 ? " ✔" : " ❌").append("\n")
                        .append(NumberConverter.toString(warrior.getIronUpgradeCost())).append("&#9725;")
                        .append(storage.getIron() - warrior.getIronUpgradeCost() > 0 ? " ✔" : " ❌").append("\n\n");
            }
        }

        bot.sendMessage(peerId, sb.toString(), null);
    }
}
