package ru.kingsbot.attack;

import lombok.Getter;
import lombok.Setter;
import ru.kingsbot.boss.Boss;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BossAttack {

    @Getter
    private Boss boss;
    @Getter
    private Map<Integer, Long> attackers = new HashMap<>();
    @Getter
    @Setter
    private boolean isRewarded = false;

    private static final Date DATE = new Date();

    public BossAttack(Boss boss) {
        this.boss = boss;
        boss.setStartAttack(DATE.getTime() / 1000);
    }

    public void addAttacker(Integer id) {
        attackers.put(id, 0L);
    }

    public boolean isWin() {
        return boss.getHp() <= 0;
    }

    public boolean isLose() {
        long time = DATE.getTime() / 1000;
        return time - boss.getStartAttack() > boss.getAttackPeriod() && boss.getHp() > 0;
    }

    public void doAttack(Integer id, Long sumAttack) {
        if(sumAttack > boss.getHp()) {
            boss.setHp(0L);
        }else{
            boss.removeHp(sumAttack);
        }
        attackers.put(id, attackers.get(id) + sumAttack);
    }

}
