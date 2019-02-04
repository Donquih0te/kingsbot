package ru.kingsbot.entity.market;

import javax.persistence.*;

@Entity
@Table(name = "iron_cost")
public class IronCost extends ResourceCost {

    public IronCost() {
        buyCost = 150;
        buyAmount = 100;
        sellCost = 50;
        sellAmount = 100;
    }

}
