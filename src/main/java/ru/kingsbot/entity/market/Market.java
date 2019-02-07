package ru.kingsbot.entity.market;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "market")
@ToString
@EqualsAndHashCode
public class Market {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "food_cost", nullable = false)
    private FoodCost food;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gold_cost", nullable = false)
    private GoldCost gold;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "iron_cost", nullable = false)
    private IronCost iron;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stone_cost", nullable = false)
    private StoneCost stone;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wood_cost", nullable = false)
    private WoodCost wood;

    public Market() {
        food = new FoodCost();
        gold = new GoldCost();
        iron = new IronCost();
        stone = new StoneCost();
        wood = new WoodCost();
    }

}
