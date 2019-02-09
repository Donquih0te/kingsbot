package ru.kingsbot.attack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Army;
import ru.kingsbot.repository.PlayerRepository;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.NumberConverter;

public class PlayerAttackTest {

    private Player who;
    private Player target;
    private PlayerRepository playerRepository;

    @Before
    public void before() {
        HibernateUtil.build();
        playerRepository = new PlayerRepository();
        who = playerRepository.get(145565650);
        target = playerRepository.get(361515290);
    }

    @After
    public void after() {
        HibernateUtil.shutdown();
    }

    @Test
    public void doAttackTest() {
        Army whoArmy = who.getArmy();
        Army targetArmy = target.getArmy();

        long whoDefense = who.getWall().getDefense() + who.getTower().getDefense();
        long targetDefense = target.getWall().getDefense() + target.getTower().getDefense();

        double whoAttack = whoArmy.getSumAttack() > targetDefense ?
                whoArmy.getSumAttack() - targetDefense : 10;
        double targetAttack = targetArmy.getSumAttack() >  whoDefense ?
                targetArmy.getSumAttack() - whoDefense : 10;

        System.out.println("Твоя атака: " + whoAttack);
        System.out.println("Противника атака: " + targetAttack);

        double whoArmyLosses;
        double targetArmyLosses;

        if(whoAttack + whoArmy.getSumArmor() >= targetAttack + targetArmy.getSumArmor()) {
            whoArmyLosses = (targetAttack + targetArmy.getSumArmor()) / (whoAttack + whoArmy.getSumArmor());
            targetArmyLosses = 1 - whoArmyLosses;
        }else{
            targetArmyLosses = (whoAttack + whoArmy.getSumArmor()) / (targetAttack + targetArmy.getSumArmor());
            whoArmyLosses = 1 - targetArmyLosses;
        }

        System.out.println("Твои результаты: " + whoArmyLosses);
        armyLosses(whoArmy, whoArmyLosses);

        System.out.println("Противника результаты: " + targetArmyLosses);
        armyLosses(targetArmy, targetArmyLosses);
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

    private void armyLosses(Army army, double losses) {
        int clubmanLosses;
        int rockThrowerLosses;

        clubmanLosses = (int) Math.ceil(army.getClubman().getAmount() * losses(army, losses) * 0.95);
        rockThrowerLosses = (int) Math.ceil(army.getRockThrower().getAmount() * losses(army, losses) * 0.95);

        System.out.println(clubmanLosses + " : " + rockThrowerLosses);
        attackResults(army, clubmanLosses, rockThrowerLosses);
    }

    private void attackResults(Army army, int clubmanLosses, int rockThrowerLosses) {
        StringBuilder result = new StringBuilder();
        result.append("[").append(army.getClubman().getLevel()).append("] Воин с дубиной: ")
                .append(NumberConverter.toString(clubmanLosses))
                .append(" из ")
                .append(NumberConverter.toString(army.getClubman().getAmount())).append("\n")
                .append("[").append(army.getRockThrower().getLevel()).append("] Метатель камней: ")
                .append(NumberConverter.toString(rockThrowerLosses))
                .append(" из ")
                .append(NumberConverter.toString(army.getRockThrower().getAmount())).append("\n\n");
        System.out.println(result.toString());
    }

}