package ru.kingsbot.repository;

import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.Instant;
import java.util.List;

public class PlayerRepository implements Repository<Player, Integer>  {

    private EntityManager manager;
    private static int i = 0;

    public PlayerRepository() {
        manager = HibernateUtil.getEntityManager();
    }

    @Override
    public void save(Player player) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(player);
        transaction.commit();
    }

    @Override
    public Player get(Integer id) {
        return manager.find(Player.class, id);
    }

    @Override
    public void update(Player player) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(player);
        if(i % 300 == 0) {
            HibernateUtil.clearCache();
            i = 0;
        }
        transaction.commit();
        i++;
    }

    @Override
    public Player load(Integer id) {
        Player player = manager.find(Player.class, id);
        if(player == null) {
            player = new Player(id);
            save(player);
        }
        return player;
    }

    @Override
    public void delete(Integer id) {
        //TODO: add delete Player operation
    }

    public List<Player> getEnemyToPlayerByCancelledShieldAndTerritory(Player player) {
        TypedQuery<Player> query = manager
                .createQuery("Select p from Player p inner join Perk perk on perk.id = p.id " +
                        "where p.id != :id " +
                        "and p.id > 0 " +
                        "and perk.shieldCancel < :time " +
                        "and p.age = :age " +
                        "and round(p.territory) > round(:territory / 1.2) " +
                        "and round(p.territory) < round(:territory * 1.2)", Player.class);

        query.setParameter("id", player.getId());
        query.setParameter("time", Instant.now().getEpochSecond());
        query.setParameter("age", player.getAge());
        query.setParameter("territory", (double) player.getTerritory());
        query.setMaxResults(5);
        return query.getResultList();
    }

    public List<Clan> getClansOrderByRating() {
        TypedQuery<Clan> query = manager
                .createQuery("select clan from Clan clan order by clan.rating desc", Clan.class);
        query.setMaxResults(10);
        return query.getResultList();
    }

}
