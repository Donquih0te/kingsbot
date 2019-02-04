package ru.kingsbot.utils;


import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateUtil {

    @Getter
    private static EntityManagerFactory entityManagerFactory;
    @Getter
    private static EntityManager entityManager;

    public static void shutdown() {
        if(entityManager != null) {
            entityManager.close();
        }
        if(entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public static void build(){
        entityManagerFactory = Persistence.createEntityManagerFactory("KingsBot");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void removeCache() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.flush();
        transaction.commit();
        entityManagerFactory.getCache().evictAll();
        entityManager.clear();
    }

}

