package ru.kingsbot.entity.building;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "storage")
@NoArgsConstructor
public class Storage extends Building {

    @Getter
    @Setter
    @Column(name = "food", nullable = false)
    private Long food;

    @Setter
    @Getter
    @Column(name = "max_food", nullable = false)
    private Long maxFood;

    @Getter
    @Setter
    @Column(name = "gold", nullable = false)
    private Long gold;

    @Setter
    @Getter
    @Column(name = "max_gold", nullable = false)
    private Long maxGold;

    @Getter
    @Setter
    @Column(name = "iron", nullable = false)
    private Long iron;

    @Setter
    @Getter
    @Column(name = "max_iron", nullable = false)
    private Long maxIron;

    @Getter
    @Setter
    @Column(name = "stone", nullable = false)
    private Long stone;

    @Setter
    @Getter
    @Column(name = "max_stone", nullable = false)
    private Long maxStone;

    @Getter
    @Setter
    @Column(name = "wood", nullable = false)
    private Long wood;

    @Setter
    @Getter
    @Column(name = "max_wood", nullable = false)
    private Long maxWood;

    public Storage(Integer id) {
        this.id = id;
        name = "Склад";
        level = 1;
        purchased = true;
        goldCost = 0;
        ironCost = 0;
        stoneCost = 0;
        woodCost = 0;
        goldUpgradeCost = 500;
        ironUpgradeCost = 500;
        stoneUpgradeCost = 500;
        woodUpgradeCost = 500;
        food = 2000L;
        maxFood = 100_000L;
        gold = 2000L;
        maxGold = 100_000L;
        iron = 2000L;
        maxIron = 100_000L;
        stone = 2000L;
        maxStone = 100_000L;
        wood = 2000L;
        maxWood = 100_000L;
    }

    public void upgrade() {
        super.upgrade();
        maxFood = 100_000 + (level - 1) * (10_000 + (level - 1) * 300L);
        maxGold = 100_000 + (level - 1) * (10_000 + (level - 1) * 350L);
        maxIron = 100_000 + (level - 1) * (10_000 + (level - 1) * 250L);
        maxStone = 100_000 + (level - 1) * (10_000 + (level - 1) * 250L);
        maxWood = 100_000 + (level - 1) * (10_000 + (level - 1) * 300L);
    }

    public void addFood(long amount) {
        if(food + amount <= maxFood) {
            food += amount;
        }else{
            food = maxFood;
        }
    }

    public void reduceFood(long amount) {
        food -= amount;
    }

    public void addGold(long amount) {
        if(gold + amount <= maxGold) {
            gold += amount;
        }else{
            gold = maxGold;
        }
    }

    public void reduceGold(long amount) {
        gold -= amount;
    }

    public void addIron(long amount) {
        if(iron + amount <= maxIron) {
            iron += amount;
        }else{
            iron = maxIron;
        }
    }

    public void reduceIron(long amount) {
        iron -= amount;
    }

    public void addStone(long amount) {
        if(stone + amount <= maxStone) {
            stone += amount;
        }else{
            stone = maxStone;
        }
    }

    public void reduceStone(long amount) {
        stone -= amount;
    }

    public void addWood(long amount) {
        if(wood + amount <= maxWood) {
            wood += amount;
        }else{
            wood = maxWood;
        }
    }

    public void reduceWood(long amount) {
        wood -= amount;
    }

}
