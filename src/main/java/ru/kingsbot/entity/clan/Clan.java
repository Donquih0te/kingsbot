package ru.kingsbot.entity.clan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kingsbot.Bot;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clan")
@NoArgsConstructor
public class Clan {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Column(name = "level", nullable = false)
    private Integer level;

    @Getter
    @Setter
    @Column(name = "owner_id", nullable = false)
    private Integer ownerId;

    @Getter
    @Setter
    @Column(name = "vice_id", nullable = true)
    private Integer viceId;

    @Setter
    @Getter
    @Column(name = "create_date", nullable = false)
    private Long createDate;

    @Getter
    @Column(name = "wins", nullable = false)
    private int wins;

    @Getter
    @Column(name = "lesions", nullable = false)
    private int lesions;

    @Getter
    @Column(name = "last_attack", nullable = false)
    private Long lastAttack;

    @Getter
    @Setter
    @Column(name = "last_update", nullable = false)
    private Long lastUpdate;

    @Getter
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Integer> members = new ArrayList<>();

    @Getter
    @Column(name = "limit_members", nullable = false)
    private Integer limitMembers;

    @Getter
    @Column(name = "create_cost", nullable = false)
    private Long createCost;

    @Getter
    @Column(name = "upgrade_cost", nullable = false)
    private Long upgradeCost;

    @Getter
    @Column(name = "set_name_cost", nullable = false)
    private Long setNameCost;

    @Getter
    @Column(name = "rating", nullable = false)
    private Long rating;

    public Clan(Integer id, String name) {
        this.id = id;
        this.ownerId = id;
        this.name = name;
        members.add(id);
        level = 1;
        wins = 0;
        lesions = 0;
        limitMembers = 30;
        createDate = Instant.now().getEpochSecond();
        lastAttack = createDate;
        createCost = 7_000_000L;
        upgradeCost = 10_000_000L;
        setNameCost = 20_000_000L;
        rating = 0L;
    }

    public void upgrade() {
        //TODO: upgradeClans
    }

    public long updateRating() {
        Bot bot = Bot.getInstance();
        rating = 0L;
        members.forEach(id -> {
            rating += bot.getPlayerRepository().get(id).getTerritory();
        });
        return rating;
    }

    public boolean isOwner(Integer id) {
        return ownerId.intValue() == id.intValue();
    }

    public boolean isVice(Integer id) {
        return viceId.intValue() == id.intValue();
    }

    public boolean isMember(Integer id) {
        return members.contains(id);
    }

    public void addMember(Integer member) {
        members.add(member);
    }

    public void removeMember(Integer member) {
        members.remove(member);
    }

    public void addWin() {
        wins++;
    }

    public void addLesion() {
        lesions++;
    }

}
