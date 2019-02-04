package ru.kingsbot.entity.army;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clubman")
@NoArgsConstructor
public class Clubman extends Warrior {

    public Clubman(Integer id) {
        super(id);
        name = "Воин с дубиной";
        amount = 0;
        level = 1;
        health = 135;
        attack = 8;
        armor = 0;
        foodCost = 10;
        goldCost = 20;
        ironCost = 20;
        foodUpgradeCost = 1000;
        goldUpgradeCost = 1000;
        ironUpgradeCost = 1000;
    }

    public void upgrade() {
        super.upgrade();
    }

}
