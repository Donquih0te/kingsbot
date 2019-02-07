package ru.kingsbot.repository;

import ru.kingsbot.entity.market.Market;
import ru.kingsbot.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MarketRepository implements Repository<Market, Long> {

    private EntityManager manager;

    public MarketRepository() {
        manager = HibernateUtil.getEntityManager();
    }

    @Override
    public void save(Market market) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(market);
        transaction.commit();
    }

    @Override
    public Market get(Long id) {
        return manager.find(Market.class, id);
    }

    @Override
    public void update(Market market) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(market);
        transaction.commit();
    }

    @Override
    public Market load(Long id) {
        Market market = manager.find(Market.class, id);
        if(market == null) {
            market = new Market();
            save(market);
        }
        return market;
    }

    @Override
    public void delete(Long id) {
        //TODO: add delete Market operation
    }

}
