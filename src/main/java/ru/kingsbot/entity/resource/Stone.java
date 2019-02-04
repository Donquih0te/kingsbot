package ru.kingsbot.entity.resource;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stone")
@NoArgsConstructor
public class Stone extends Resource {

    public Stone(int amount) {
        maxAmount = amount;
        currentAmount = maxAmount;
    }

}
