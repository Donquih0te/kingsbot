package ru.kingsbot.entity.market;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stone_cost")
public class StoneCost extends ResourceCost {

    public StoneCost() {
        buyCost = 150;
        buyAmount = 100;
        sellCost = 50;
        sellAmount = 100;
    }

}
