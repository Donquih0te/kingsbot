package ru.kingsbot.entity.building;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kingsbot.entity.Citizen;

import javax.persistence.*;

@Entity
@Table(name = "capitol")
@NoArgsConstructor
public class Capitol extends Building {

    @Getter
    @Column(name = "free_citizens_amount")
    private Integer freeCitizensAmount;

    @Getter
    @Column(name = "citizens_amount")
    private Integer citizensAmount;

    @Getter
    @Setter
    @Column(name = "max_citizens_amount")
    private Integer maxCitizensAmount;

    @Getter
    @Setter
    @Column(name = "limit_citizens_amount")
    private Integer limitCitizensAmount;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "citizen")
    private Citizen citizen;

    public Capitol(Integer id) {
        this.id = id;
        name = "Капитолий";
        level = 1;
        purchased = true;
        goldUpgradeCost = 2_000;
        ironUpgradeCost = 2_000;
        stoneUpgradeCost = 2_000;
        woodUpgradeCost = 2_000;
        citizensAmount = 20;
        freeCitizensAmount = 20;
        maxCitizensAmount = 25;
        limitCitizensAmount = 50;
        citizen = new Citizen();
    }

    public void upgrade() {
        super.upgrade();
        if(maxCitizensAmount < limitCitizensAmount) {
            if(level % 3 == 0)
                maxCitizensAmount++;
        }
    }

    public void addFreeCitizens(int citizens) {
        freeCitizensAmount += citizens;
    }

    public void removeFreeCitizens(int citizens) {
        freeCitizensAmount -= citizens;
    }

    public void addCitizens(int citizens) {
        citizensAmount += citizens;
    }

    public void removeCitizens(int citizens) {
        citizensAmount -= citizens;
    }

}
