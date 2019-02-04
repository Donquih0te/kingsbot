package ru.kingsbot.command.group.boss;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.attack.BossAttack;
import ru.kingsbot.attack.BossAttackMap;
import ru.kingsbot.boss.Boss;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class BossAttackCommand extends Command {

    private static final Date DATE = new Date();

    private final SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");

    private BossAttackMap attackMap;

    public BossAttackCommand() {
        super("boss_attack");
        attackMap = bot.getBossAttackMap();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        if(payload.get("boss") == null) {
            return;
        }
        Boss boss = bot.getBossMap().getBossToAttack(payload.get("boss"));
        if(boss == null) {
            return;
        }
        Keyboard.Builder builder = Keyboard.newKeyboard();
        StringBuilder sb = new StringBuilder();
        if(attackMap.inAttack(player.getId())) {
            BossAttack bossAttack = attackMap.get(player.getId());
            if(!bossAttack.getBoss().getName().equals(boss.getName())) {
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Ты уже атакуешь босса ")
                        .append(bossAttack.getBoss().getCustomName()).append("\n")
                        .append("Сначала тебе следует победить его");
            }else{
                if(bossAttack.isWin()) {
                    sb.append(Emoji.TOP).append("Босс побежден\n")
                            .append("Итоги боя:\n");
                    bossAttack.getAttackers().forEach((id, damage) -> {
                        Player p = bot.getPlayerRepository().get(id);
                        sb.append(Utils.createLink(p)).append(": ")
                                .append(NumberConverter.toString(damage)).append(" урона");
                        if(!bossAttack.isRewarded()) {
                            Storage storage = p.getStorage();
                            storage.addFood(boss.getFoodReward());
                            storage.addGold(boss.getGoldReward());
                            storage.addIron(boss.getIronReward());
                            storage.addStone(boss.getStoneReward());
                            storage.addWood(boss.getWoodReward());
                            p.getBossInfo().addWin(boss);
                        }
                    });
                    attackMap.remove(player.getId());

                    if(!bossAttack.isRewarded()) {
                        StringBuilder result = new StringBuilder();
                        result.append(Emoji.TIME).append("Сражение над боссом ").append(boss.getCustomName()).append(" завершено\n\n")
                                .append("Награда за победу:\n")
                                .append(boss.getFoodReward()).append(Emoji.FOOD).append("  ")
                                .append(boss.getGoldReward()).append(Emoji.GOLD).append("  ")
                                .append(boss.getIronReward()).append(Emoji.IRON).append("  ")
                                .append(boss.getStoneReward()).append(Emoji.STONE).append("  ")
                                .append(boss.getWoodReward()).append(Emoji.WOOD).append("\n")
                                .append("+1").append(Emoji.KEY);
                        bot.sendMessage(new ArrayList<>(bossAttack.getAttackers().keySet()), result.toString(), null);
                        bossAttack.setRewarded(true);
                    }
                    sb.append("\n\nАтаковать еще раз?");
                    builder.row(List.of(
                            new Button(new Action(Emoji.ARMORY + "Атаковать", Map.of("command", "boss_attack", "boss", payload.get("boss"))), Color.WHITE)
                    ));
                }else{
                    if(bossAttack.isLose()) {
                        sb.append(Emoji.TIME).append("Бой проигран\n")
                                .append("Итоги боя:\n");

                    }else{
                        long time = DATE.getTime() / 1000;
                        String formatDate = formatter.format(new Date((bossAttack.getBoss().getAttackPeriod() - (time - bossAttack.getBoss().getStartAttack())) * 1000));
                        sb.append(Emoji.BOSS_TYPE).append(boss.getCustomName()).append(":\n")
                                .append("HP: ").append(boss.getHp()).append(Emoji.HEARTH).append("\n")
                                .append("Бой закончится через: ").append(formatDate).append("\n");
                    }
                }
            }
        }else{
            BossAttack bossAttack = null;
            Clan clan = player.getClan();
            if(clan != null) {
                if(player.getBossInfo().getKeysToAttack(boss) < 3) {
                    sb.append(Emoji.RED_EXCLAMATION_MARK).append("Не хватает ключей для атаки\n")
                            .append("Ключи можно заработать нападая на боссов по слабее.\n")
                            .append("Для атаки необходимо как минимум 3").append(Emoji.KEY);
                }else{
                    List<Integer> members = clan.getMembers();
                    Optional<Integer> first = members.stream()
                            .filter(id -> attackMap.inAttack(id) && !attackMap.get(id).isWin() && attackMap.get(id).getBoss().getName().equals(payload.get("boss")))
                            .findFirst();
                    if(first.isPresent()) {
                        bossAttack = attackMap.get(first.get());
                    }else{
                        bossAttack = new BossAttack(boss);
                        attackMap.put(player.getId(), bossAttack);
                    }
                    player.getBossInfo().removeKeys(boss);
                    bossAttack.addAttacker(player.getId());
                    sb.append(Emoji.INFO).append("Ты атаковал босса ").append(boss.getCustomName()).append("\n\n")
                            .append("HP: ").append(boss.getMaxHp()).append(Emoji.HEARTH).append("\n\n")
                            .append(Emoji.RED_EXCLAMATION_MARK).append("Чтобы нанести урон выбери войска и атакуй");
                    builder.row(List.of(
                            new Button(new Action(Emoji.CLUBMAN + "Воин", Map.of("command", "add_damage", "warrior", "clubman")), Color.WHITE),
                            new Button(new Action(Emoji.ROCK_THROWER + "Метатель", Map.of("command", "add_damage", "warrior", "rock_thrower")), Color.WHITE)
                    ));
                }
            }else{
                sb.append(Emoji.RED_EXCLAMATION_MARK).append("Нельзя атаковать боссов без клана");
            }
        }
        builder.row(List.of(new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)));
        keyboard = builder.build();
        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
