package ru.kingsbot.repository;

import ru.kingsbot.entity.donate.Donate;
import ru.kingsbot.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DonateRepository implements Repository<Donate, Integer> {

    private EntityManager manager;

    public DonateRepository() {
        manager = HibernateUtil.getEntityManager();
    }

    @Override
    public void save(Donate donate) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(donate);
        transaction.commit();
    }

    @Override
    public Donate get(Integer id) {
        return manager.find(Donate.class, id);
    }

    @Override
    public void update(Donate donate) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(donate);
        transaction.commit();
    }

    @Override
    public Donate load(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        //TODO: add delete Donate operation
    }

    public List<Donate> getByCustomer(Integer id) {
        TypedQuery<Donate> query = manager.createQuery("from Donate donate where donate.customer = :id", Donate.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Donate> findByNotCompleted() {
        TypedQuery<Donate> query = manager.createQuery("from Donate donate where donate.completed = false", Donate.class);
        return query.getResultList();
    }

}
