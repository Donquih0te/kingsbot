package ru.kingsbot.entity.army;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@ToString
@EqualsAndHashCode
@MappedSuperclass
@NoArgsConstructor
public class Warrior {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    private Integer id;

    @Getter
    @Column(name = "name")
    protected String name;

    @Setter
    @Getter
    @Column(name = "amount")
    protected int amount;

    @Setter
    @Getter
    @Column(name = "level")
    protected int level;

    @Getter
    @Column(name = "health")
    protected int health;

    @Getter
    @Column(name = "attack")
    protected int attack;

    @Getter
    @Column(name = "armor")
    protected int armor;

    @Getter
    @Column(name = "food_cost")
    protected int foodCost;

    @Getter
    @Column(name = "gold_cost")
    protected int goldCost;

    @Getter
    @Column(name = "iron_cost")
    protected int ironCost;

    @Getter
    @Column(name = "food_upgrade_cost")
    protected int foodUpgradeCost;

    @Getter
    @Column(name = "gold_upgrade_cost")
    protected int goldUpgradeCost;

    @Getter
    @Column(name = "iron_upgrade_cost")
    protected int ironUpgradeCost;

    public Warrior(Integer id) {
        this.id = id;
        foodUpgradeCost = 200;
        goldUpgradeCost = 200;
        ironUpgradeCost = 200;
    }

    public void upgrade() {
        level++;
        health += 15;
        attack += 1;
        armor += 1;
        foodUpgradeCost = 200 + (level - 1) * (150 + (level - 1) * 150);
        goldUpgradeCost = 200 + (level - 1) * (100 + (level - 1) * 100);
        ironUpgradeCost = 200 + (level - 1) * (100 + (level - 1) * 100);
    }

    public void add(int amount) {
        this.amount += amount;
    }

    public void remove(int amount) {
        this.amount -= amount;
    }

}
