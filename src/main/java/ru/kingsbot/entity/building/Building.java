package ru.kingsbot.entity.building;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@ToString
@EqualsAndHashCode
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
    }

}
