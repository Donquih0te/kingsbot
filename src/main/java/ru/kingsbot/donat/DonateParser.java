package ru.kingsbot.donat;

import lombok.extern.log4j.Log4j2;
import ru.kingsbot.Bot;
import ru.kingsbot.Emoji;
import ru.kingsbot.entity.Perk;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.donate.Donate;

import java.time.Instant;
import java.util.List;

@Log4j2
public class DonateParser extends Thread {

    private static final String DIR = System.getProperty("user.dir") + "/";
    private static final String FILE_NAME = "donat.txt";

    private Bot bot;

    public DonateParser(Bot bot) {
        this.bot = bot;

        setName("DonateParser");
        setDaemon(true);
    }

    public void run() {
        List<String > lines = null;
        while(true) {
            try {
                Thread.sleep(30000);
            }catch(InterruptedException ignore) {

            }

            List<Donate> donateList = bot.getDonateRepository().findByNotCompleted();
            donateList.forEach(donate -> {
                String[] words = donate.getCommand().split(" ");
                int id = donate.getCustomer();
                switch(words[0].toLowerCase()) {
                    case "addgold": {
                        int amount = Integer.parseInt(words[1]);
                        Player player = bot.getPlayerRepository().get(id);
                        player.getStorage().setGold(amount + player.getStorage().getGold());
                        bot.sendMessage(id, "На склад добавлено " + amount + Emoji.GOLD, null);
                        break;
                    }
                    case "setattack": {
                        double attack = Double.parseDouble(words[1]);
                        int hours = Integer.parseInt(words[2]);
                        Player player = bot.getPlayerRepository().get(id);
                        Perk perk = player.getPerk();
                        perk.setAttack(attack);
                        perk.setAttackCancel(Instant.now().plusSeconds(60 * 60 * hours).getEpochSecond());
                        bot.sendMessage(id, "Атака увеличена на " + (attack - 1) * 100 + "%", null);
                        break;
                    }
                    case "setshield": {
                        int hours = Integer.parseInt(words[1]);
                        Player player = bot.getPlayerRepository().get(id);
                        Perk perk = player.getPerk();
                        perk.setShieldCancel(Instant.now().plusSeconds(60 * 60 * hours).getEpochSecond());
                        bot.sendMessage(id, "Активирован щит на " + hours + "часа(ов).\n Не нападайте на другие королевства, чтобы щит не пропал!", null);
                        break;
                    }
                    case "setresourcebonus": {
                        double bonus = Double.parseDouble(words[1]);
                        Player player = bot.getPlayerRepository().get(id);
                        Perk perk = player.getPerk();
                        perk.setResourceBonus(bonus);
                        perk.setResourceBonusCancel(Instant.now().plusSeconds(60 * 60 * 24).getEpochSecond());
                        bot.sendMessage(id, "Добыча ресурсов ускорена на " + (bonus - 1) * 100 + "%", null);
                        break;
                    }
                }
                donate.setCompleted(true);
            });

        }
    }

}
