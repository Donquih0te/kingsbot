package ru.kingsbot.entity.building;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "armory")
@NoArgsConstructor
public class Armory extends Building {

    public Armory(Integer id) {
        this.id = id;
        name = "Казармы";
        level = 1;
        purchased = false;
        goldCost = 5_000;
        ironCost = 5_000;
        stoneCost = 5_000;
        woodCost = 5_000;
        goldUpgradeCost = 1_000;
        ironUpgradeCost = 1_000;
        stoneUpgradeCost = 1_000;
        woodUpgradeCost = 1_000;
    }

    public void upgrade() {
        super.upgrade();
        goldUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
        ironUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
        stoneUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
        woodUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
    }

}
