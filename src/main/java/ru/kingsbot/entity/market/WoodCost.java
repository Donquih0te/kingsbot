package ru.kingsbot.entity.market;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wood_cost")
public class WoodCost extends ResourceCost {

    public WoodCost() {
        buyCost = 150;
        buyAmount = 100;
        sellCost = 50;
        sellAmount = 100;
    }

}
