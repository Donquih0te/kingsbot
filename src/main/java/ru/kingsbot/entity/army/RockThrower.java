package ru.kingsbot.entity.army;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rock_thrower")
@NoArgsConstructor
public class RockThrower extends Warrior {

    public RockThrower(Integer id) {
        super(id);
        name = "Метатель камней";
        amount = 0;
        level = 1;
        health = 75;
        attack = 5;
        armor = 4;
        foodCost = 10;
        goldCost = 20;
        ironCost = 20;
        foodUpgradeCost = 1000;
        goldUpgradeCost = 1000;
        ironUpgradeCost = 1000;
    }

}
