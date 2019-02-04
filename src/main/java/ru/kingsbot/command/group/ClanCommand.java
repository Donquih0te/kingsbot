package ru.kingsbot.command.group;

import ru.kingsbot.Emoji;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.command.Command;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.utils.NumberConverter;
import ru.kingsbot.utils.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClanCommand extends Command {

    private final DateFormat formatter = new SimpleDateFormat("dd:MM:yy HH:mm:ss");

    private Keyboard.Builder builder;

    public ClanCommand() {
        super("clan");
        builder = Keyboard.newKeyboard();
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.INFO).append("Инфомация о клане:\n\n");
        if(player.getClan() == null) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Клан отсутствует\n\n")
                    .append("Вы можете создать свой клан или присоединиться к существующему\n")
                    .append("Чтобы присоединиться к клану тебе должны отправить заявку на вступление\n\n");
            if(player.getClanRequest() == null) {
                sb.append(Emoji.DENY).append("Заявки на вступление в клан отсутствуют\n");
            }else{
                Player target = bot.getPlayerRepository().load(player.getClanRequest());
                Clan clan = target.getClan();
                sb.append(Emoji.ACCEPT).append("Приглашение на вступление в клан <").append(clan.getName()).append(">\n");
                builder.row(List.of(
                        new Button(new Action("Принять", Map.of("command", "clan_request", "action", "accept", "from", String.valueOf(clan.getId()))), Color.GREEN),
                        new Button(new Action("Отклонить", Map.of("command", "clan_request", "action", "deny", "from", String.valueOf(clan.getId()))), Color.RED)
                ));
            }
        }else{
            Clan clan = player.getClan();
            sb.append(Emoji.CLAN).append("Клан: ").append(clan.getName()).append("\n")
                    .append(Emoji.TOP).append("Рейтинг: ").append(NumberConverter.toString(clan.updateRating())).append("\n")
                    .append("Создан: ").append(formatter.format(new Date(clan.getCreateDate()))).append("\n")
                    .append("Создатель: ").append(Utils.createLink(bot.getPlayerRepository().load(clan.getOwnerId()))).append("\n")
                    .append("Заместитель: ")
                    .append(clan.getViceId() == null ? "не назначен" : Utils.createLink(bot.getPlayerRepository().load(clan.getViceId()))).append("\n")
                    .append("Участники:\n");
            String collect = clan.getMembers().stream()
                    .map(member -> Utils.createLink(bot.getPlayerRepository().get(member)))
                    .collect(Collectors.joining(", "));
            sb.append(collect);
        }
        builder.row(List.of(
                new Button(new Action(Emoji.MARK + "Команды", Map.of("command", "clan_commands")), Color.WHITE),
                new Button(new Action(Emoji.TOP + "Топ", Map.of("command", "clan_rating")), Color.WHITE),
                new Button(new Action("Главная", Map.of("command", "info")), Color.BLUE)
        ));
        keyboard = builder.build();
        bot.sendMessage(peerId, sb.toString(), keyboard);
    }
}
