package ru.kingsbot.repository;

import ru.kingsbot.entity.conversation.Conversation;
import ru.kingsbot.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ConversationRepository implements Repository<Conversation, Long> {

    private EntityManager manager;

    public ConversationRepository() {
        manager = HibernateUtil.getEntityManager();
    }

    @Override
    public void save(Conversation conversation) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(conversation);
        transaction.commit();
    }

    @Override
    public Conversation get(Long id) {
        return manager.find(Conversation.class, id);
    }

    @Override
    public void update(Conversation conversation) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(conversation);
        transaction.commit();
    }

    @Override
    public Conversation load(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        //TODO: add delete Conversation operation
    }

}
