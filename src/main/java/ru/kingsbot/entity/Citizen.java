package ru.kingsbot.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "citizen")
@ToString
@EqualsAndHashCode
public class Citizen {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Column(name = "level", nullable = false)
    private int level;

    @Getter
    @Column(name = "health", nullable = false)
    private int health;

    @Getter
    @Column(name = "food_per_minute", nullable = false)
    private int foodPerMinute;

    @Getter
    @Column(name = "gold_per_minute", nullable = false)
    private int goldPerMinute;

    @Getter
    @Column(name = "iron_per_minute", nullable = false)
    private int ironPerMinute;

    @Getter
    @Column(name = "stone_per_minute", nullable = false)
    private int stonePerMinute;

    @Getter
    @Column(name = "wood_per_minute", nullable = false)
    private int woodPerMinute;

    @Getter
    @Column(name = "food_cost", nullable = false)
    private int foodCost;

    @Getter
    @Column(name= "gold_cost", nullable = false)
    private int goldCost;

    @Getter
    @Column(name = "food_upgrade_cost")
    private int foodUpgradeCost;

    @Getter
    @Column(name = "gold_upgrade_cost")
    private int goldUpgradeCost;

    public Citizen() {
        level = 1;
        health = 50;
        foodPerMinute = 10;
        ironPerMinute = 10;
        goldPerMinute = 10;
        stonePerMinute = 10;
        woodPerMinute = 10;
        foodCost = 7_000;
        goldCost = 7_000;
        foodUpgradeCost = 100;
        goldUpgradeCost = 100;
    }

    public void upgrade() {
        level++;
        health = 50 + (level - 1) * 10;
        foodPerMinute = 10 + (level - 1) * 10;
        goldPerMinute = 10 + (level - 1) * 10;
        ironPerMinute = 10 + (level - 1) * 10;
        stonePerMinute = 10 + (level - 1) * 10;
        woodPerMinute = 10 + (level - 1) * 10;
        foodUpgradeCost = 100 + (level - 1) * (100 + (level - 1) * 100);
        goldUpgradeCost = 100 + (level - 1) * (100 + (level - 1) * 50);
    }

}
