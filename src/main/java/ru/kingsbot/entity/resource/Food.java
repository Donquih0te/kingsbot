package ru.kingsbot.entity.resource;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "food")
@NoArgsConstructor
public class Food extends Resource {

    public Food(int amount) {
        maxAmount = amount;
        currentAmount = maxAmount;
    }

}
