package ru.kingsbot.game.attack;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class BossAttackMap {

    @Getter
    private Map<Integer, BossAttack> attacks = new HashMap<>();

    public void put(Integer id, BossAttack bossAttack) {
        attacks.put(id, bossAttack);
    }

    public void remove(Integer id) {
        attacks.remove(id);
    }

    public boolean inAttack(Integer id) {
        return attacks.containsKey(id);
    }

    public BossAttack get(Integer id) {
        return attacks.get(id);
    }

}
