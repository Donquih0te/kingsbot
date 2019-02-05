package ru.kingsbot.command;

import ru.kingsbot.Bot;
import ru.kingsbot.Emoji;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Clubman;
import ru.kingsbot.entity.army.RockThrower;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.entity.conversation.Conversation;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

public class TextCommandParser {

    private Bot bot;

    public TextCommandParser() {
        bot = Bot.getInstance();
    }

    public void parse(Integer peerId, Integer fromId, String message) {
        StringBuilder sb = new StringBuilder();
        Player player = bot.getPlayerRepository().load(fromId);
        String[] words = message.split(" ");
        switch(words[0].toLowerCase()) {
            case "реф":
            case "реферал": {
                if(words.length < 2) {
                    return;
                }
                int id = Utils.parseInt(words[1]);
                if(player.getId() == id) {
                    bot.sendMessage(peerId, "Нельзя пригласить самого себя", null);
                    return;
                }
                Player target = bot.getPlayerRepository().get(id);
                if(target == null) {
                    bot.sendMessage(peerId, "Игрок не найден в базе", null);
                    return;
                }
                if(player.getInvitedBy() != null) {
                    bot.sendMessage(peerId, "Ты уже вводил код приглашения\n", null);
                    return;
                }
                player.setInvitedBy(target.getId());
                player.getStorage().addGold(100_000);
                target.addInvite(player.getId());
                target.getStorage().addGold(100_000);
                StringBuilder playerResult = new StringBuilder();
                sb.append("Ты отметил игрока ").append(Utils.createLink(target)).append(" как пригласившего тебя.\n")
                        .append("За это вы оба получаете по 100к").append(Emoji.GOLD).append("\n\n");
                StringBuilder targetResult = new StringBuilder();
                sb.append(Utils.createLink(player)).append(" указал тебя, как пригласившего его.\n")
                        .append("За это вы оба получаете по 100к").append(Emoji.GOLD).append("\n\n")
                        .append("Ты пригласил: ").append(target.getInviteList().size());
                bot.sendMessage(peerId, playerResult.toString(), null);
                bot.sendMessage(target.getId(), targetResult.toString(), null);
                break;
            }
//            case "передать": {
//                if(words.length < 3) {
//                    bot.sendMessage(peerId, "передать <id игрока> <кол-во золота>\n", null);
//                    return;
//                }
//                Player target = bot.getPlayerRepository().get(Integer.valueOf(words[1]));
//                if(target == null) {
//                    bot.sendMessage(peerId, "Игрок не найден в базе", null);
//                    return;
//                }
//                int gold = Integer.valueOf(words[2]);
//                if(player.getStorage().getGold() < gold) {
//                    bot.sendMessage(peerId, "У тебя на складе нет столько золота", null);
//                    return;
//                }
//                target.getStorage().addGold(gold);
//                player.getStorage().reduceGold(gold);
//                bot.sendMessage(peerId, "Передано", null);
//                bot.sendMessage(target.getId(), Utils.createLink(player) + " передал тебе сундучек с золотом", null);
//                break;
//            }
        }

        if(peerId.intValue() == fromId.intValue()) {

            /*
             *   Команды кланов
             */
            if(words[0].toLowerCase().equals("клан")) {
                if(words.length < 3) {
                    return;
                }
                switch(words[1].toLowerCase()) {
                    case "создать":
                        if(player.getClan() != null) {
                            return;
                        }
                        Storage storage = player.getStorage();
                        if(storage.getGold() >= 7_000_000) {
                            player.setClan(new Clan(player.getId(), words[2]));
                            storage.reduceGold(7_000_000);
                            sb.append(Emoji.ACCEPT).append("Клан <").append(words[2]).append("> успешно создан");
                        }else{
                            sb.append(Emoji.RED_EXCLAMATION_MARK)
                                    .append("Для создания клана необходимо 7кк").append(Emoji.GOLD).append("\n")
                                    .append("Тебе не хватает ")
                                    .append(NumberConverter.toString(7_000_000 - storage.getGold())).append(Emoji.GOLD);
                        }
                        bot.sendMessage(player.getId(), sb.toString(), bot.getKeyboard());
                        break;
                    case "пригласить":
                        if(player.getClan() == null) {
                            return;
                        }
                        if(!player.getClan().isOwner(player.getId()) || !player.getClan().isVice(player.getId())) {
                            return;
                        }
                        Player target = bot.getPlayerRepository().get(Integer.valueOf(words[2]));
                        if(target == null) {
                            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Игрок с id ").append(Integer.valueOf(words[2])).append(" не найден");
                        }else{
                            if(target.getClan() != null) {
                                bot.sendMessage(peerId, "Игрок уже состоит в клане", null);
                                return;
                            }
                            if(player.getClan().isMember(target.getId())) {
                                return;
                            }
                            target.setClanRequest(player.getId());
                            bot.sendMessage(peerId, "Заявка на вступление в клан отправлена", null);
                            bot.sendMessage(target.getId(), "Тебя приглашают в клан " + player.getClan().getName(), null);
                        }
                        break;
                    case "зам":
                        if(player.getClan() == null) {
                            return;
                        }
                        if(!player.getClan().isOwner(player.getId())) {
                            return;
                        }
                        Player vice = bot.getPlayerRepository().get(Integer.valueOf(words[2]));
                        if(vice == null) {
                            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Игрок с id ").append(Integer.valueOf(words[2])).append(" не найден");
                        }else{
                            if(player.getClan().isMember(vice.getId())) {
                                return;
                            }
                            player.getClan().setViceId(vice.getId());
                            bot.sendMessage(player.getId(), "Заместителем клана назначен " + Utils.createLink(vice), null);
                            bot.sendMessage(vice.getId(), "Ты назвачен заместителем клана " + player.getClan().getName(), null);
                        }
                        break;
                    case "глава":
                        if(player.getClan() == null) {
                            return;
                        }
                        if(!player.getClan().isOwner(player.getId())) {
                            return;
                        }
                        Player owner = bot.getPlayerRepository().get(Integer.valueOf(words[2]));
                        if(owner == null) {
                            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Игрок с id ").append(Integer.valueOf(words[2])).append(" не найден");
                        }else{
                            if(player.getClan().isMember(owner.getId())) {
                                return;
                            }
                            player.getClan().setOwnerId(owner.getId());
                            bot.sendMessage(player.getId(), "Главой клана назначен " + Utils.createLink(owner), null);
                            bot.sendMessage(owner.getId(), "Ты назвачен новым главой клана " + player.getClan().getName(), null);
                        }
                        break;
                    case "инфо":

                        break;
                }
            }else{
                bot.sendMessage(peerId, "Для игры используйте кнопки", null);
            }
        }else{
            Conversation conversation = bot.getConversationRepository().get(peerId.longValue());
            if(conversation == null) {
                conversation = new Conversation(peerId.longValue());
                bot.getConversationRepository().save(conversation);
                bot.sendMessage(peerId, "Здарова бандиты!\nС вами как всегда KingsBot", bot.getChatKeyboard());
            }
            if(message.startsWith("/")){
                String[] t = message.split(" ");
                switch(t[0].substring(1)) {
                    case "setres":
                        if(!player.isAdmin()) {
                            return;
                        }
                        if(t.length < 2) {
                            return;
                        }
                        long amount = Long.parseLong(t[1]);
                        Storage storage = player.getStorage();
                        if(amount > storage.getMaxFood() + storage.getFood()) {
                            storage.setMaxFood(amount);
                        }
                        storage.addFood(amount);
                        if(amount > storage.getMaxGold() + storage.getGold()) {
                            storage.setMaxGold(amount);
                        }
                        storage.addGold(amount);
                        if(amount > storage.getMaxIron() + storage.getIron()) {
                            storage.setMaxIron(amount);
                        }
                        storage.addIron(amount);
                        if(amount > storage.getMaxStone() + storage.getStone()) {
                            storage.setMaxStone(amount);
                        }
                        storage.addStone(amount);
                        if(amount > storage.getMaxWood() + storage.getWood()) {
                            storage.setMaxWood(amount);
                        }
                        storage.addWood(amount);

                        bot.sendMessage(peerId, "ресурсы обновлены", null);
                        break;
                    case "setage":

                        break;
                    case "setarmy":
                        if(!player.isAdmin()) {
                            return;
                        }
                        if(t.length < 2) {
                            return;
                        }
                        int a = Integer.parseInt(t[1]);
                        Clubman clubman = player.getArmy().getClubman();
                        RockThrower rockThrower = player.getArmy().getRockThrower();
                        clubman.setAmount(a);
                        rockThrower.setAmount(a);
                        bot.sendMessage(peerId, "армия обновлена", null);
                        break;
                    case "cache":
                        if(!player.isAdmin()) {
                            return;
                        }
                        HibernateUtil.removeCache();
                        break;
                    case "notify":
                        if(!player.isAdmin()) {
                            return;
                        }
                        player.setNotify(!player.isNotify());
                        bot.sendMessage(peerId, "notify: " + (player.isNotify() ? "on" : "off"), null);
                        break;
                }
            }
        }
    }

}
