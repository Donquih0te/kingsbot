package ru.kingsbot.repository;

import ru.kingsbot.entity.conversation.Conversation;
import ru.kingsbot.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ConversationRepository {

    private EntityManager manager;

    public ConversationRepository() {
        manager = HibernateUtil.getEntityManager();
    }

    public void save(Conversation conversation) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(conversation);
        transaction.commit();
    }

    public void update(Conversation conversation) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(conversation);
        transaction.commit();
    }

    public Conversation get(Long id) {
        return manager.find(Conversation.class, id);
    }

}
