package ru.kingsbot;

import lombok.extern.log4j.Log4j2;
import ru.kingsbot.donat.DonateParser;
import ru.kingsbot.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.FileNotFoundException;

@Log4j2
public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        Bot bot = new Bot();
        new DonateParser(bot).start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Сохранение данных...");
            bot.getPlayerService().sendMessage(2000000139, "Произошло выключение бота", null);
            EntityManager entityManager = HibernateUtil.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.flush();
            entityManager.clear();
            transaction.commit();
            HibernateUtil.shutdown();
            bot.shutdown();
        }));

        bot.run();
    }

    /*
    {"ts":"22","updates":[{"type":"message_new","object":{"date":1543569026,"from_id":145565650,"id":21,"out":0,"peer_id":145565650,"text":"f","conversation_message_id":21,"fwd_messages":[],"important":false,"random_id":0,"attachments":[],"is_hidden":false},"group_id":174156055}]}
    {"ts":"30","updates":[{"type":"message_new","object":{"date":1543569474,"from_id":145565650,"id":0,"out":0,"peer_id":2000000001,"text":"ds","conversation_message_id":10,"fwd_messages":[],"important":false,"random_id":0,"attachments":[],"is_hidden":false},"group_id":174156055}]}

     */

}
