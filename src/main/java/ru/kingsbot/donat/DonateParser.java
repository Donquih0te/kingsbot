package ru.kingsbot.donat;

import lombok.extern.log4j.Log4j2;
import ru.kingsbot.Bot;
import ru.kingsbot.Emoji;
import ru.kingsbot.entity.Perk;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.donate.Donate;
import ru.kingsbot.service.DonateService;
import ru.kingsbot.service.PlayerService;
import ru.kingsbot.utils.Utils;

import java.time.Instant;
import java.util.List;

@Log4j2
public class DonateParser extends Thread {

    private final Bot bot;
    private final PlayerService playerService;
    private final DonateService donateService;

    public DonateParser(Bot bot) {
        this.bot = bot;
        this.playerService = bot.getPlayerService();
        this.donateService = bot.getDonateService();

        setName("DonateParser");
        setDaemon(true);
    }

    public void run() {
        List<String > lines = null;
        while(true) {
            try {
                Thread.sleep(10000);
            }catch(InterruptedException ignore) {

            }

            List<Donate> donateList = donateService.findByNotCompleted();
            donateList.forEach(donate -> {
                String[] words = donate.getCommand().split(" ");
                int id = donate.getCustomer();
                switch(words[0].toLowerCase()) {
                    case "addgold": {
                        int amount = Utils.parseInt(words[1]);
                        Player player = playerService.getById(id);
                        if(player == null) {
                            return;
                        }
                        player.getStorage().setGold(amount + player.getStorage().getGold());
                        playerService.sendMessage(id, "На склад добавлено " + amount + Emoji.GOLD, null);
                        break;
                    }
                    case "setattack": {
                        double attack = Double.parseDouble(words[1]);
                        int hours = Utils.parseInt(words[2]);
                        Player player = playerService.getById(id);
                        if(player == null) {
                            return;
                        }
                        Perk perk = player.getPerk();
                        perk.setAttack(attack);
                        perk.setAttackCancel(Instant.now().plusSeconds(60 * 60 * hours).getEpochSecond());
                        playerService.sendMessage(id, "Атака увеличена на " + (attack - 1) * 100 + "%", null);
                        break;
                    }
                    case "setshield": {
                        int hours = Integer.parseInt(words[1]);
                        Player player = playerService.getById(id);
                        if(player == null) {
                            return;
                        }
                        Perk perk = player.getPerk();
                        perk.setShieldCancel(Instant.now().plusSeconds(60 * 60 * hours).getEpochSecond());
                        playerService.sendMessage(id, "Активирован щит на " + hours + "часа(ов).\n Не нападайте на другие королевства, чтобы щит не пропал!", null);
                        break;
                    }
                    case "setresourcebonus": {
                        double bonus = Utils.parseDouble(words[1]);
                        Player player = playerService.getById(id);
                        if(player == null) {
                            return;
                        }
                        Perk perk = player.getPerk();
                        perk.setResourceBonus(bonus);
                        perk.setResourceBonusCancel(Instant.now().plusSeconds(60 * 60 * 24).getEpochSecond());
                        playerService.sendMessage(id, "Добыча ресурсов ускорена на " + (bonus - 1) * 100 + "%", null);
                        break;
                    }
                    default: {
                        log.error("Unknown donat command\n" + donate.getCommand());
                        break;
                    }
                }
                donate.setCompleted(true);
            });

        }
    }

}
