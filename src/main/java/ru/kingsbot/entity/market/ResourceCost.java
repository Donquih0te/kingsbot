package ru.kingsbot.entity.market;

import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
public class ResourceCost {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Getter
    @Column(name = "buy_cost", nullable = false)
    protected int buyCost;

    @Getter
    @Column(name = "buy_amount", nullable = false)
    protected int buyAmount;

    @Getter
    @Column(name = "sell_cost", nullable = false)
    protected int sellCost;

    @Getter
    @Column(name = "sell_amount", nullable = false)
    protected int sellAmount;

}
