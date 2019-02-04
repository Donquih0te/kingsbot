package ru.kingsbot.entity.building;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tower")
@NoArgsConstructor
public class Tower extends Building implements Protection {

    @Getter
    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Getter
    @Column(name = "defense", nullable = false)
    private Integer defense;

    public Tower(Integer id) {
        this.id = id;
        name = "Башни";
        level = 1;
        defense = 100;
        amount = 0;
        purchased = false;
        goldCost = 5_000;
        ironCost = 5_000;
        stoneCost = 5_000;
        woodCost = 5_000;
        goldUpgradeCost = 2_000;
        ironUpgradeCost = 2_000;
        stoneUpgradeCost = 2_000;
        woodUpgradeCost = 2_000;
    }

    public void upgrade() {
        super.upgrade();
        defense = 100 + (level - 1) * 2000;
    }

}
