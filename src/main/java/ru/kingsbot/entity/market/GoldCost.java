package ru.kingsbot.entity.market;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gold_cost")
public class GoldCost extends ResourceCost {

    public GoldCost() {
        buyCost = 150;
        buyAmount = 100;
        sellCost = 50;
        sellAmount = 100;
    }

}
