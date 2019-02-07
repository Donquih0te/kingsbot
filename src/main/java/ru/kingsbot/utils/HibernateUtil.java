package ru.kingsbot.utils;


import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    public static EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void clearCache() {
        entityManager.flush();
        entityManager.clear();
        entityManagerFactory.getCache().evictAll();
    }

}

