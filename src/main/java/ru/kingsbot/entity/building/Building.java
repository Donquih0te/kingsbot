package ru.kingsbot.entity.building;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@NoArgsConstructor
public class Building {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    protected Integer id;

    @Getter
    @Column(name = "name")
    protected String name;

    @Getter
    @Column(name = "level")
    protected int level;

    @Getter
    @Column(name = "gold_cost")
    protected int goldCost;

    @Getter
    @Column(name = "iron_cost")
    protected int ironCost;

    @Getter
    @Column(name = "stone_cost")
    protected int stoneCost;

    @Getter
    @Column(name = "wood_cost")
    protected int woodCost;

    @Getter
    @Column(name = "gold_upgrade_cost")
    protected int goldUpgradeCost;

    @Getter
    @Column(name = "iron_upgrade_cost")
    protected int ironUpgradeCost;

    @Getter
    @Column(name = "stone_upgrade_cost")
    protected int stoneUpgradeCost;

    @Getter
    @Column(name = "wood_upgrade_cost")
    protected int woodUpgradeCost;

    @Getter
    @Setter
    @Column(name = "purchased")
    protected boolean purchased;

    public Building(Integer id) {
        this.id = id;
    }

    public void upgrade() {
        level++;
        goldUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
        ironUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
        stoneUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
        woodUpgradeCost = 2000 + (level - 1) * (250 + (level - 1) * 150);
    }

}
