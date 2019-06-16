package ru.kingsbot.game.attack;

import ru.kingsbot.Emoji;
import ru.kingsbot.entity.Perk;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Army;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.time.Instant;

public class PlayerAttack {

    private static final double ATTACK_BONUS = 0.10;
    private static final double ARMY_SAVE = 0.95;
    private static final int SHIELD_TIME = 60 * 60 * 12;

    private final StringBuilder whoResult = new StringBuilder();
    private final StringBuilder targetResult = new StringBuilder();

    private Player who;
    private Player target;

    public PlayerAttack(Player who, Player target) {
        this.who = who;
        this.target = target;
    }

    public String getWhoResult() {
        return whoResult.toString();
    }

    public String getTargetResult() {
        return targetResult.toString();
    }

    public void doAttack() {
        Storage whoStorage = who.getStorage();
        Storage targetStorage = target.getStorage();
        Army whoArmy = who.getArmy();
        Army targetArmy = target.getArmy();
        long whoDefense = who.getWall().getDefense() + who.getTower().getDefense();
        long targetDefense = target.getWall().getDefense() + target.getTower().getDefense();

        double whoAttack = whoArmy.getSumAttack() * bonusAttack(who) > targetDefense ?
                whoArmy.getSumAttack() * bonusAttack(who) - targetDefense : 10;
        double targetAttack = targetArmy.getSumAttack() * bonusAttack(target) > + whoDefense ?
                targetArmy.getSumAttack() * bonusAttack(target) - whoDefense : 10;

        whoResult.append("Вы атаковали королевство игрока ").append(Utils.createLink(target)).append(".\n");
        targetResult.append("Ваше королевство атаковал игрок ").append(Utils.createLink(who)).append(".\n");

        double whoArmyLosses;
        double targetArmyLosses;

        if(whoAttack + whoArmy.getSumArmor() >= targetAttack + targetArmy.getSumArmor()) {
            whoResult.append("Атака завершилась победой\n\n");
            targetResult.append("Ваши воины слабы и не смогли противостоять армии противника.\n\n");

            whoArmyLosses = (targetAttack + targetArmy.getSumArmor()) / (whoAttack + whoArmy.getSumArmor());
            targetArmyLosses = 1 - whoArmyLosses;

            whoResult.append("Полученные ресурсы:\n");
            attackResources(target, whoResult);

            targetResult.append("Потерянные ресурсы:\n");
            attackResources(target, targetResult);

            whoStorage.addFood((int) (targetStorage.getFood() * ATTACK_BONUS));
            whoStorage.addGold((int) (targetStorage.getGold() * ATTACK_BONUS));
            whoStorage.addIron((int) (targetStorage.getIron() * ATTACK_BONUS));
            whoStorage.addStone((int) (targetStorage.getStone() * ATTACK_BONUS));
            whoStorage.addWood((int) (targetStorage.getWood() * ATTACK_BONUS));
            targetStorage.reduceFood((int) (targetStorage.getFood() * ATTACK_BONUS));
            targetStorage.reduceGold((int) (targetStorage.getGold() * ATTACK_BONUS));
            targetStorage.reduceIron((int) (targetStorage.getIron() * ATTACK_BONUS));
            targetStorage.reduceStone((int) (targetStorage.getStone() * ATTACK_BONUS));
            targetStorage.reduceWood((int) (targetStorage.getWood() * ATTACK_BONUS));

            who.addTerritory((int) (target.getTerritory() * ATTACK_BONUS));
            target.reduceTerritory((int) (target.getTerritory() * ATTACK_BONUS));

            who.addWin();
        }else{
            whoResult.append("Атака завершилась неудачей.\n\n");
            targetResult.append("Ваши воины смогли отстоять королевство.\n\n");

            targetArmyLosses = (whoAttack + whoArmy.getSumArmor()) / (targetAttack + targetArmy.getSumArmor());
            whoArmyLosses = 1 - targetArmyLosses;

            who.addLesion();
        }

        armyLosses(whoArmy, whoArmyLosses, whoResult, targetResult);
        armyLosses(targetArmy, targetArmyLosses, targetResult, whoResult);

        who.getPerk().setShieldCancel(Instant.now().getEpochSecond());
        target.getPerk().setShieldCancel(Instant.now().plusSeconds(SHIELD_TIME).getEpochSecond());
    }

    private double bonusAttack(Player player) {
        Perk perk = player.getPerk();
        if(Instant.now().getEpochSecond() > perk.getAttackCancel()) {
            perk.setAttack(1.0);
        }
        return perk.getAttack();
    }

    private void armyLosses(Army army, double losses, StringBuilder who, StringBuilder target) {
        int clubmanLosses;
        int rockThrowerLosses;

        clubmanLosses = (int) Math.ceil(army.getClubman().getAmount() * losses(army, losses) * ARMY_SAVE);
        rockThrowerLosses = (int) Math.ceil(army.getRockThrower().getAmount() * losses(army, losses) * ARMY_SAVE);

        who.append("Ваши потери:\n");
        attackResults(army, clubmanLosses, rockThrowerLosses, who);

        target.append("Потери противника: \n");
        attackResults(army, clubmanLosses, rockThrowerLosses, target);

        army.getClubman().remove(clubmanLosses);
        army.getRockThrower().remove(rockThrowerLosses);
    }

    private double losses(Army army, double losses) {
        double clubman = army.getClubman().getLevel() * army.getClubman().getAmount();
        double rockThrower = army.getRockThrower().getLevel() * army.getRockThrower().getAmount();
        double r = (clubman + rockThrower) / 2;
        if(losses > 0.5) {
            return losses + r > 1 ? losses : losses + r;
        }else{
            return losses - r < 0 ? losses : losses - r;
        }
    }

    private void attackResults(Army army, int clubmanLosses, int rockThrowerLosses, StringBuilder result) {
        result.append(Emoji.CLUBMAN).append("[").append(army.getClubman().getLevel()).append("] Воин с дубиной: ")
                .append(NumberConverter.toString(clubmanLosses))
                .append(" из ")
                .append(NumberConverter.toString(army.getClubman().getAmount())).append("\n")
                .append(Emoji.ROCK_THROWER).append("[").append(army.getRockThrower().getLevel()).append("] Метатель камней: ")
                .append(NumberConverter.toString(rockThrowerLosses))
                .append(" из ")
                .append(NumberConverter.toString(army.getRockThrower().getAmount())).append("\n\n");
    }

    private void attackResources(Player player, StringBuilder result) {
        Storage storage = player.getStorage();
        result.append(NumberConverter.toString((int)(storage.getFood() * ATTACK_BONUS))).append(Emoji.FOOD).append("  ")
                .append(NumberConverter.toString((int)(storage.getGold() * ATTACK_BONUS))).append(Emoji.GOLD).append("  ")
                .append(NumberConverter.toString((int)(storage.getIron() * ATTACK_BONUS))).append(Emoji.IRON).append("  ")
                .append(NumberConverter.toString((int)(storage.getStone() * ATTACK_BONUS))).append(Emoji.STONE).append("  ")
                .append(NumberConverter.toString((int)(storage.getWood() * ATTACK_BONUS))).append(Emoji.WOOD).append("\n")
                .append(NumberConverter.toString((int)(target.getTerritory() * ATTACK_BONUS))).append(Emoji.TERRITORY).append("\n\n");
    }

}
