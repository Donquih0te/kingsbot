package ru.kingsbot.entity.army;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "army")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Army {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    private Integer id;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "clubman")
    private Clubman clubman;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "rock_thrower")
    private RockThrower rockThrower;

    public Army(Integer id) {
        this.id = id;
        clubman = new Clubman(id);
        rockThrower = new RockThrower(id);
    }

    public double getSumAttack() {
        return clubman.getAmount() * clubman.getAttack()
                + rockThrower.getAmount() * rockThrower.getAttack();
    }

    public double getSumArmor() {
        return clubman.getAmount() * clubman.getArmor()
                + rockThrower.getAmount() * rockThrower.getArmor();
    }

    public long getWarriorsAmount() {
        return clubman.getAmount() + rockThrower.getAmount();
    }

}
