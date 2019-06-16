package ru.kingsbot.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "perk")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Perk {

    @Id
    @Getter
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "attack", nullable = false)
    private Double attack;

    @Getter
    @Setter
    @Column(name = "attack_cancel", nullable = false)
    private Long attackCancel;

    @Getter
    @Setter
    @Column(name = "shield_cancel", nullable = false)
    private Long shieldCancel;

    @Getter
    @Setter
    @Column(name = "recource_bonus", nullable = false)
    private Double resourceBonus;

    @Getter
    @Setter
    @Column(name = "recource_bonus_cancel", nullable = false)
    private Long resourceBonusCancel;

    public Perk(Integer id) {
        this.id = id;
        attack = 1.0;
        attackCancel = Instant.now().getEpochSecond();
        shieldCancel = Instant.now().plusSeconds(60 * 60 * 24).getEpochSecond();
        resourceBonus = 1.0;
        resourceBonusCancel = Instant.now().getEpochSecond();
    }


}
