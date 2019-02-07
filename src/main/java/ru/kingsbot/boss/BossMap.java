package ru.kingsbot.boss;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

@Log4j2
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
        }catch(CloneNotSupportedException e) {
            log.error("Can't create bosses clone", e);
        }
        return null;
    }

}
