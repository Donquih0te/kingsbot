package ru.kingsbot.command;

import ru.kingsbot.Bot;
import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Keyboards;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.army.Clubman;
import ru.kingsbot.entity.army.RockThrower;
import ru.kingsbot.entity.building.Storage;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.entity.conversation.Conversation;
import ru.kingsbot.service.ConversationService;
import ru.kingsbot.service.PlayerService;
import ru.kingsbot.utils.HibernateUtil;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextCommandParser {

    private final Bot bot;
    private final PlayerService playerService;
    private final ConversationService conversationService;

    public TextCommandParser(Bot bot) {
        this.bot = bot;
        this.playerService = bot.getPlayerService();
        this.conversationService = bot.getConversationService();
    }

    public void parse(Integer peerId, Integer fromId, String message) {
        StringBuilder sb = new StringBuilder();
        Player player = playerService.load(fromId);
        String[] words = message.split(" ");
        switch(words[0].toLowerCase()) {
            case "реф":
            case "реферал": {
                if(words.length < 2) {
                    return;
                }
                int id = Utils.parseInt(words[1]);
                if(player.getId() == id) {
                    playerService.sendMessage(peerId, "Нельзя пригласить самого себя", null);
                    return;
                }
                if(player.getInvitedBy() != null) {
                    playerService.sendMessage(peerId, "Ты уже вводил код приглашения", null);
                    return;
                }
                Player target = playerService.getById(id);
                if(target == null) {
                    playerService.sendMessage(peerId, "Игрок не зарегистрирован", null);
                    return;
                }
                player.setInvitedBy(target.getId());
                player.getStorage().addGold(100_000);
                target.addInvite(player.getId());
                target.getStorage().addGold(100_000);
                StringBuilder playerResult = new StringBuilder();
                playerResult.append("Ты отметил игрока ").append(Utils.createLink(target)).append(" как пригласившего тебя.\n")
                        .append("За это вы оба получаете по 100к").append(Emoji.GOLD).append("\n\n");
                StringBuilder targetResult = new StringBuilder();
                targetResult.append(Utils.createLink(player)).append(" указал тебя, как пригласившего его.\n")
                        .append("За это вы оба получаете по 100к").append(Emoji.GOLD).append("\n\n")
                        .append("Ты пригласил: ").append(target.getInviteList().size());
                playerService.sendMessage(peerId, playerResult.toString(), null);
                playerService.sendMessage(target, targetResult.toString(), null);
                break;
            }
//            case "передать": {
//                if(words.length < 3) {
//                    playerService.sendMessage(peerId, "передать <id игрока> <кол-во золота>\n", null);
//                    return;
//                }
//                Player target = playerService.getPlayerRepository().toHttp(Integer.valueOf(words[1]));
//                if(target == null) {
//                    playerService.sendMessage(peerId, "Игрок не найден в базе", null);
//                    return;
//                }
//                int gold = Integer.valueOf(words[2]);
//                if(player.getStorage().getGold() < gold) {
//                    playerService.sendMessage(peerId, "У тебя на складе нет столько золота", null);
//                    return;
//                }
//                target.getStorage().addGold(gold);
//                player.getStorage().reduceGold(gold);
//                playerService.sendMessage(peerId, "Передано", null);
//                playerService.sendMessage(target.getId(), Utils.createLink(player) + " передал тебе сундучек с золотом", null);
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
                    case "создать": {
                        if(player.getClan() != null) {
                            return;
                        }
                        Storage storage = player.getStorage();
                        if(storage.getGold() >= 7_000_000) {
                            List<String> wordsList = new ArrayList<>(Arrays.asList(words));
                            wordsList.remove(0);
                            wordsList.remove(1);
                            String clanName = String.join(" ", wordsList);
                            if(clanName.length() > 15) {
                                playerService.sendMessage(player.getId(), "Название клана очень длинное", Keyboards.getGroupKeyboard());
                                return;
                            }
                            player.setClan(new Clan(player.getId(), words[2]));
                            storage.reduceGold(7_000_000);
                            sb.append(Emoji.ACCEPT).append("Клан <").append(words[2]).append("> успешно создан");
                        }else{
                            sb.append(Emoji.RED_EXCLAMATION_MARK)
                                    .append("Для создания клана необходимо 7кк").append(Emoji.GOLD).append("\n")
                                    .append("Тебе не хватает ")
                                    .append(NumberConverter.toString(7_000_000 - storage.getGold())).append(Emoji.GOLD);
                        }
                        playerService.sendMessage(player, sb.toString(), Keyboards.getGroupKeyboard());
                        break;
                    }
                    case "пригласить": {
                        Clan clan = player.getClan();
                        if(clan == null) {
                            return;
                        }
                        if(!clan.isOwner(player.getId()) || !clan.isVice(player.getId())) {
                            return;
                        }
                        Player target = playerService.getById(Utils.parseInt(words[2]));
                        if(target == null) {
                            playerService.sendMessage(peerId, "Игрок не надйен.", null);
                        }else{
                            if(target.getClan() != null) {
                                playerService.sendMessage(peerId, "Игрок уже состоит в клане", null);
                                return;
                            }
                            target.setClanRequest(player.getId());
                            playerService.sendMessage(peerId, "Заявка на вступление в клан отправлена", null);
                            playerService.sendMessage(target, "Тебя приглашают в клан " + player.getClan().getName(), null);
                        }
                        break;
                    }
                    case "зам": {
                        Clan clan = player.getClan();
                        if(clan == null) {
                            return;
                        }
                        if(!clan.isOwner(player.getId())) {
                            return;
                        }
                        Player vice = playerService.getById(Utils.parseInt(words[2]));
                        if(vice == null) {
                            playerService.sendMessage(peerId, "Игрок не надйен.", null);
                        }else{
                            if(!clan.isMember(vice.getId())) {
                                return;
                            }
                            if(clan.isVice(vice.getId())) {
                                return;
                            }
                            clan.setViceId(vice.getId());
                            playerService.sendMessage(clan.getMembers(), "Заместителем клана назначен " + Utils.createLink(vice), null);
                            playerService.sendMessage(vice, "Ты назвачен заместителем клана " + clan.getName(), null);
                        }
                        break;
                    }
                    case "глава": {
                        Clan clan = player.getClan();
                        if(clan == null) {
                            return;
                        }
                        if(!clan.isOwner(player.getId())) {
                            return;
                        }
                        Player owner = playerService.getById(Utils.parseInt(words[2]));
                        if(owner == null) {
                            playerService.sendMessage(peerId, "Игрок не надйен.", null);
                        }else{
                            if(!clan.isMember(owner.getId())) {
                                return;
                            }
                            if(clan.isOwner(owner.getId())) {
                                return;
                            }
                            clan.setOwnerId(owner.getId());
                            playerService.sendMessage(clan.getMembers(), "Главой клана назначен " + Utils.createLink(owner), null);
                            playerService.sendMessage(owner, "Ты назвачен новым главой клана " + clan.getName(), null);
                        }
                        break;
                    }
                    case "покинуть": {
                        Clan clan = player.getClan();
                        if(clan == null) {
                            return;
                        }
                        int id = player.getId();
                        if(clan.isOwner(id)) {
                            clan.removeMember(id);
                            player.setClan(null);
                            if(clan.getViceId() != null) {
                                clan.setOwnerId(clan.getViceId());
                            }else{
                                if(!clan.getMembers().isEmpty()) {
                                    clan.setOwnerId(Utils.getRandomValueFromList(clan.getMembers()));
                                }
                            }
                            playerService.sendMessage(clan.getMembers(), Utils.createLink(player) + " покинул клан.", null);
                            return;
                        }
                        if(clan.isVice(player.getId())) {
                            clan.removeMember(id);
                            clan.setViceId(null);
                            playerService.sendMessage(clan.getMembers(), Utils.createLink(player) + " покинул клан.", null);
                            return;
                        }
                        clan.removeMember(id);
                        playerService.sendMessage(clan.getMembers(), Utils.createLink(player) + " покинул клан.", null);
                        break;
                    }
                    case "инфо": {

                        break;
                    }
                }
            }else{
                playerService.sendMessage(peerId, "Для игры используйте кнопки", null);
            }
        }else{
            Conversation conversation = conversationService.getBuId(peerId.longValue());
            if(conversation == null) {
                conversation = new Conversation(peerId.longValue());
                conversationService.save(conversation);
                playerService.sendMessage(peerId, "Здарова бандиты!\nС вами как всегда KingsBot", Keyboards.getChatKeyboard());
            }
            if(message.startsWith("/")){
                String[] t = message.split(" ");
                switch(t[0].substring(1)) {
                    case "setres": {
                        if(!player.isAdmin()) {
                            return;
                        }
                        if(t.length < 2) {
                            return;
                        }
                        long amount = Utils.parseInt(t[1]);
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

                        playerService.sendMessage(peerId, "ресурсы обновлены", null);
                        break;
                    }
                    case "setage":

                        break;
                    case "setarmy": {
                        if(!player.isAdmin()) {
                            return;
                        }
                        if(t.length < 2) {
                            return;
                        }
                        int a = Utils.parseInt(t[1]);
                        Clubman clubman = player.getArmy().getClubman();
                        RockThrower rockThrower = player.getArmy().getRockThrower();
                        clubman.setAmount(a);
                        rockThrower.setAmount(a);
                        playerService.sendMessage(peerId, "армия обновлена", null);
                        break;
                    }
                    case "cache": {
                        if(!player.isAdmin()) {
                            return;
                        }
                        HibernateUtil.clearCache();
                        break;
                    }
                    case "admin": {
                        if(!player.isAdmin()) {
                            return;
                        }
                        int id = Utils.parseInt(t[1]);
                        Player target = playerService.getById(id);
                        if(target == null) {
                            return;
                        }
                        player.setAdmin(!player.isAdmin());
                        playerService.sendMessage(peerId, "admin: " + (player.isNotify() ? "true" : "false"), null);
                        break;
                    }
                    case "notify": {
                        if(!player.isAdmin()) {
                            return;
                        }
                        player.setNotify(!player.isNotify());
                        playerService.sendMessage(peerId, "notify: " + (player.isNotify() ? "on" : "off"), null);
                        break;
                    }
                    case "ref": {
                        if(!player.isAdmin()) {
                            return;
                        }
                        player.setInvitedBy(null);
                        break;
                    }
                }
            }
        }
    }

}
