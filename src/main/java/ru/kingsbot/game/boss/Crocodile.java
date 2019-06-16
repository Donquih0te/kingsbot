package ru.kingsbot.boss;

public class Crocodile extends Boss {

    public Crocodile() {
        name = "crocodile";
        customName = "Крокодил";
        hp = 500_000L;
        maxHp = hp;
        armor = 0;
        foodReward = 150_000L;
        goldReward = 150_000L;
        ironReward = 100_000L;
        stoneReward = 100_000L;
        woodReward = 100_000L;
    }

}
