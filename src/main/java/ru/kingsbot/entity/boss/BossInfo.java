package ru.kingsbot.entity.boss;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.kingsbot.boss.Boss;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "boss_info")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BossInfo {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    private Integer id;

    @Getter
    @Column(name = "krieg_wins")
    private Integer kriegWins;

    @Getter
    @Column(name = "krieg_keys")
    private Integer kriegKeys;

    @Getter
    @Column(name = "arlong_wins")
    private Integer arlongWins;

    @Getter
    @Column(name = "arlong_keys")
    private Integer arlongKeys;

    @Getter
    @Column(name = "crocodile_wins")
    private Integer crocodileWins;

    @Getter
    @Column(name = "crocodile_keys")
    private Integer crocodileKeys;

    public BossInfo(Integer id) {
        this.id = id;
        kriegKeys = 0;
        kriegWins = 0;
        arlongKeys = 0;
        arlongWins = 0;
        crocodileKeys = 0;
        crocodileWins = 0;
    }

    public void addWin(Boss boss) {
        switch(boss.getName()) {
            case "krieg":
                kriegWins++;
                kriegKeys++;
                break;
            case "arlong":
                arlongWins++;
                arlongKeys++;
                break;
            case "crocodile":
                crocodileWins++;
                crocodileKeys++;
                break;
        }
    }

    public Integer getKeysToAttack(Boss boss) {
        switch(boss.getName()) {
            case "krieg":
                return 3;
            case "arlong":
                return kriegKeys;
            case "crocodile":
                return arlongKeys;
        }
        return 0;
    }

    public Integer getKeys(Boss boss) {
        switch(boss.getName()) {
            case "krieg":
                return kriegKeys;
            case "arlong":
                return arlongKeys;
            case "crocodile":
                return crocodileKeys;
        }
        return 0;
    }

    public void removeKeys(Boss boss) {
        switch(boss.getName()) {
            case "krieg":
                break;
            case "arlong":
                kriegKeys -= 3;
                break;
            case "crocodile":
                arlongKeys -= 3;
                break;
        }
    }

    public Integer getWins(Boss boss) {
        switch(boss.getName()) {
            case "krieg":
                return kriegWins;
            case "arlong":
                return arlongWins;
            case "crocodile":
                return crocodileWins;
        }
        return 0;
    }

}
