package ru.kingsbot.entity.resource;

import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@MappedSuperclass
public class Resource {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Getter
    @Setter
    @Column(name = "max_amount", nullable = false)
    protected long maxAmount;

    @Getter
    @Setter
    @Column(name = "current_amount", nullable = false)
    protected long currentAmount;

    @Getter
    @Setter
    @Column(name = "citizens_amount", nullable = false)
    protected int citizensAmount;

    @Getter
    @Setter
    @Column(name = "max_citizens_amount", nullable = false)
    protected int maxCitizensAmount;

    @Getter
    @Setter
    @Column(name = "mined", nullable = false)
    protected boolean mined;

    public Resource() {
        citizensAmount = 0;
        maxCitizensAmount = 5;
    }

    public void reduce(int amount) {
        currentAmount -= amount;
    }

    public void addCitizen() {
        citizensAmount++;
    }

    public void removeCitizen() {
        citizensAmount--;
    }

}
