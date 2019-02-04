package ru.kingsbot.repository;

import ru.kingsbot.entity.Player;
import ru.kingsbot.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PlayerRepository  {

    private EntityManager manager;
    private static int i = 0;

    public PlayerRepository() {
        manager = HibernateUtil.getEntityManager();
    }

    public void save(Player player) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(player);
        i++;
        if(i % 50 == 0) {
            manager.flush();
            manager.clear();
            i = 0;
        }
        transaction.commit();
    }

    public void update(Player player) {
        i++;
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        if(i % 300 == 0) {
            manager.flush();
            manager.clear();
            HibernateUtil.getEntityManagerFactory().getCache().evictAll();
            i = 0;
        }
        manager.merge(player);
        transaction.commit();
    }

    public Player load(Integer id) {
        Player player = manager.find(Player.class, id);
        if(player == null) {
            player = new Player(id);
            save(player);
        }
        return player;
    }

    public Player get(Integer id) {
        return manager.find(Player.class, id);
    }

}
