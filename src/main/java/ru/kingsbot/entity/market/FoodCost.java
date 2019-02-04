package ru.kingsbot.entity.market;

import javax.persistence.*;

@Entity
@Table(name = "food_cost")
public class FoodCost extends ResourceCost {

    public FoodCost() {
        buyCost = 150;
        buyAmount = 100;
        sellCost = 50;
        sellAmount = 100;
    }

}
