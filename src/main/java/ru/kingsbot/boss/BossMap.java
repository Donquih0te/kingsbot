package ru.kingsbot.boss;

import java.util.HashMap;
import java.util.Map;

public class BossMap {

    private Map<String, Boss> bossMap = new HashMap<>();

    public BossMap() {
        registerBosses();
    }

    private void registerBosses() {
        bossMap.put("krieg", new Krieg());
        bossMap.put("arlong", new Arlong());
        bossMap.put("crocodile", new Crocodile());
    }

    public Boss getBoss(String name) {
        return bossMap.get(name);
    }

    public Boss getBossToAttack(String name) {
        try {
            return bossMap.get(name).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
