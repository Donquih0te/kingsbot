package ru.kingsbot.entity.resource;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wood")
@NoArgsConstructor
public class Wood extends Resource {

    public Wood(int amount) {
        maxAmount = amount;
        currentAmount = maxAmount;
    }

}
