package ru.kingsbot.entity.resource;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gold")
@NoArgsConstructor
public class Gold extends Resource {

    public Gold(int amount) {
        maxAmount = amount;
        currentAmount = maxAmount;
    }

}
