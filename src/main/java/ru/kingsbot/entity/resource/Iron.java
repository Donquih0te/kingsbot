package ru.kingsbot.entity.resource;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "iron")
@NoArgsConstructor
public class Iron extends Resource {

    public Iron(int amount) {
        maxAmount = amount;
        currentAmount = maxAmount;
    }

}
