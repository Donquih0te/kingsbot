package ru.kingsbot.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import ru.kingsbot.entity.age.Age;
import ru.kingsbot.entity.army.Army;
import ru.kingsbot.entity.boss.BossInfo;
import ru.kingsbot.entity.building.*;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.entity.resource.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "player")
@DynamicUpdate
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Player {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Getter
    @Column(name = "register_date", nullable = false)
    private Long registerDate;

    @Getter
    @Setter
    @Column(name = "invited_by", nullable = true)
    private Integer invitedBy;

    @Getter
    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "invite_list", nullable = true)
    private List<Integer> inviteList = new ArrayList<>();

    @Getter
    @Column(name = "level", nullable = false)
    private Integer level;

    @Getter
    @Setter
    @Column(name = "kingdom_name", nullable = true)
    private String kingdomName;

    @Getter
    @Column(name = "current_experience", nullable = false)
    private Integer currentExperience;

    @Getter
    @Column(name = "max_experience", nullable = false)
    private Integer maxExperience;

    @Getter
    @Setter
    @Column(name = "last_attack", nullable = false)
    private Long lastAttack;

    @Getter
    @Setter
    @Column(name = "attack_timeout", nullable = false)
    private Integer attackTimeout;

    @Getter
    @Setter
    @Column(name = "last_boss_attack", nullable = false)
    private Long lastBossAttack;

    @Getter
    @Setter
    @Column(name = "boss_attack_timeout", nullable = false)
    private Integer bossAttackTimeout;

    @Getter
    @Setter
    @Column(name = "last_update", nullable = false)
    private Long lastUpdate;

    @Getter
    @Column(name = "territory", nullable = false)
    private Long territory;

    @Setter
    @Getter
    @Column(name = "clan_request")
    private Integer clanRequest;

    @Getter
    @Column(name = "wins", nullable = false)
    private Integer wins;

    @Getter
    @Column(name = "lesions", nullable = false)
    private Integer lesions;

    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    @Column(name = "age", nullable = false)
    private Age age;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "capitol", nullable = false)
    private Capitol capitol;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "armory", nullable = false)
    private Armory armory;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "wall", nullable = false)
    private Wall wall;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "tower", nullable = false)
    private Tower tower;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "army", nullable = false)
    private Army army;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "food", nullable = false)
    private Food foodResource;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "gold", nullable = false)
    private Gold goldResource;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "iron", nullable = false)
    private Iron ironResource;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "stone", nullable = false)
    private Stone stoneResource;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "wood", nullable = false)
    private Wood woodResource;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "storage", nullable = false)
    private Storage storage;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "clan", nullable = true)
    private Clan clan;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "boss_info")
    private BossInfo bossInfo;

    @Getter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "perk")
    private Perk perk;

    @Setter
    @Getter
    @Column(name = "tutorial", nullable = false)
    private boolean tutorial;

    @Setter
    @Getter
    @Column(name = "admin", nullable = false)
    private boolean admin;

    @Getter
    @Setter
    @Column(name = "banned", nullable = false)
    private boolean banned;

    @Getter
    @Setter
    @Column(name = "notify", nullable = false)
    private boolean notify;

    public Player(Integer id) {
        this.id = id;
        registerDate = Instant.now().getEpochSecond();
        level = 1;
        currentExperience = 0;
        maxExperience = 50;
        lastUpdate = registerDate;
        territory = 1000L;
        wins = 0;
        lesions = 0;
        invitedBy = null;
        lastAttack = registerDate;
        attackTimeout = 60 * 15;
        lastBossAttack = registerDate;
        bossAttackTimeout = 60 * 60 * 3;
        age = Age.PREHISTORIC;
        capitol = new Capitol(id);
        armory = new Armory(id);
        storage = new Storage(id);
        wall = new Wall(id);
        tower = new Tower(id);
        army = new Army(id);
        foodResource = new Food(new Random().nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel());
        goldResource = new Gold(new Random().nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel());
        ironResource = new Iron(new Random().nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel());
        stoneResource = new Stone(new Random().nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel());
        woodResource = new Wood(new Random().nextInt(500_000 * capitol.getLevel() - 100_000 * capitol.getLevel()) + 100_000 * capitol.getLevel());
        bossInfo = new BossInfo(id);
        perk = new Perk(id);
        tutorial = false;
        admin = false;
        notify = true;
        banned = false;
    }

    private int updateResource(Resource resource, int resourcePerMinute, long time) {
        long sec = Instant.now().getEpochSecond();
        int amount;
        if(perk.getResourceBonusCancel() >= sec) {
            amount = (int) (time * resourcePerMinute * resource.getCitizensAmount() * perk.getResourceBonus() / 60);
        }else{
            amount = (int) (time * resourcePerMinute * resource.getCitizensAmount() / 60);
        }
        return amount;
    }

    public boolean updateResources() {
        long sec = Instant.now().getEpochSecond();
        long time = sec - lastUpdate;
        if(time > 60) {
            lastUpdate = sec;
            if(time > (60 * 60 * 24 * 2)) {
                time = (60 * 60 * 24 * 2);
            }
            int foodAmount = updateResource(foodResource, capitol.getCitizen().getFoodPerMinute(), time);
            if(foodResource.getCurrentAmount() - foodAmount >= 0) {
                if(storage.getFood() < storage.getMaxFood()) {
                    foodResource.reduce(foodAmount);
                    storage.addFood(foodAmount);
                }
            }else{
                if(storage.getFood() < storage.getMaxFood()) {
                    storage.addFood(foodResource.getCurrentAmount());
                    foodResource.setCurrentAmount(0);
                    foodResource.setMined(true);
                }
            }
            int goldAmount = updateResource(goldResource, capitol.getCitizen().getGoldPerMinute(), time);
            if(goldResource.getCurrentAmount() - goldAmount >= 0) {
                if(storage.getGold() < storage.getMaxGold()) {
                    goldResource.reduce(goldAmount);
                    storage.addGold(goldAmount);
                }
            }else{
                if(storage.getGold() < storage.getMaxGold()) {
                    storage.addGold(goldResource.getCurrentAmount());
                    goldResource.setCurrentAmount(0);
                    goldResource.setMined(true);
                }
            }
            int ironAmount = updateResource(ironResource, capitol.getCitizen().getIronPerMinute(), time);
            if(ironResource.getCurrentAmount() - ironAmount >= 0) {
                if(storage.getIron() < storage.getMaxIron()) {
                    ironResource.reduce(ironAmount);
                    storage.addIron(ironAmount);
                }
            }else{
                if(storage.getIron() < storage.getMaxIron()) {
                    storage.addIron(ironResource.getCurrentAmount());
                    ironResource.setCurrentAmount(0);
                    ironResource.setMined(true);
                }
            }
            int stoneAmount = updateResource(stoneResource, capitol.getCitizen().getStonePerMinute(), time);
            if(stoneResource.getCurrentAmount() - stoneAmount >= 0) {
                if(storage.getStone() < storage.getMaxStone()) {
                    stoneResource.reduce(stoneAmount);
                    storage.addStone(stoneAmount);
                }
            }else{
                if(storage.getStone() < storage.getMaxStone()) {
                    storage.addStone(stoneResource.getCurrentAmount());
                    stoneResource.setCurrentAmount(0);
                    stoneResource.setMined(true);
                }
            }
            int woodAmount = updateResource(woodResource, capitol.getCitizen().getWoodPerMinute(), time);
            if(woodResource.getCurrentAmount() - woodAmount >= 0) {
                if(storage.getWood() < storage.getMaxWood()) {
                    woodResource.reduce(woodAmount);
                    storage.addWood(woodAmount);
                }
            }else{
                if(storage.getWood() < storage.getMaxWood()) {
                    storage.addWood(woodResource.getCurrentAmount());
                    woodResource.setCurrentAmount(0);
                    woodResource.setMined(true);
                }
            }
            return true;
        }
        return false;
    }

    public void levelUp() {
        level++;
        currentExperience = 0;
        maxExperience += maxExperience / 3;
    }

    public void addExperience(Integer amount) {
        currentExperience += amount;
    }

    public void addWin() {
        wins++;
    }

    public void addLesion() {
        lesions++;
    }

    public void addTerritory(long amount) {
        territory += amount;
    }

    public void reduceTerritory(long amount) {
        territory -= amount;
    }

    public void addInvite(Integer id) {
        inviteList.add(id);
    }

}
