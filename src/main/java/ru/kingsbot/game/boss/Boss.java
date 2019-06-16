package ru.kingsbot.game.boss;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Boss implements Cloneable {

    @Getter
    protected String name;

    @Getter
    protected String customName;

    @Getter
    @Setter
    protected Long startAttack;

    @Getter
    protected Integer attackPeriod;

    @Getter
    @Setter
    protected Long hp;

    @Getter
    protected Long maxHp;

    @Getter
    protected Integer armor;

    @Getter
    protected Long foodReward;

    @Getter
    protected Long goldReward;

    @Getter
    protected Long ironReward;

    @Getter
    protected Long stoneReward;

    @Getter
    protected Long woodReward;

    @Getter
    @Setter
    protected Map<Integer, Long> attackers = new HashMap<>();

    public Boss() {
        attackPeriod = 60 * 60 * 3;
    }

    public void removeHp(long amount) {
        hp -= amount;
    }

    public Boss clone() throws CloneNotSupportedException {
        return (Boss) super.clone();
    }

}
