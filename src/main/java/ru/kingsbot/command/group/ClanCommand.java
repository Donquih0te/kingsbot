package ru.kingsbot.command.group;

import ru.kingsbot.utils.Emoji;
import ru.kingsbot.command.Command;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
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

    public ClanCommand() {
        super("clan");
    }

    @Override
    public void execute(Player player, Integer peerId, Map<String, String> payload) {
        Utils.checkSignature(payload.get("key"), player.getId(), name);
        Keyboard.Builder builder = Keyboard.newKeyboard();
        StringBuilder sb = new StringBuilder();
        sb.append(Emoji.INFO).append("Инфомация о клане:\n\n");
        if(player.getClan() == null) {
            sb.append(Emoji.RED_EXCLAMATION_MARK).append("Клан отсутствует\n\n")
                    .append("Вы можете создать свой клан или присоединиться к существующему\n")
                    .append("Чтобы присоединиться к клану тебе должны отправить заявку на вступление\n\n");
            if(player.getClanRequest() == null) {
                sb.append(Emoji.DENY).append("Заявки на вступление в клан отсутствуют\n");
            }else{
                Player target = playerService.getById(player.getClanRequest());
                Clan clan = target.getClan();
                sb.append(Emoji.ACCEPT).append("Приглашение на вступление в клан <").append(clan.getName()).append(">\n");
                builder.row(List.of(
                        Button.newButton()
                                .label("Прнять")
                                .payload("command", "clan_request")
                                .payload("action", "accept")
                                .payload("from", String.valueOf(clan.getId()))
                                .color(Color.GREEN)
                                .create(),
                        Button.newButton()
                                .label("Отклонить")
                                .payload("command", "clan_request")
                                .payload("action", "deny")
                                .payload("from", String.valueOf(clan.getId()))
                                .color(Color.RED)
                                .create()
                ));
            }
        }else{
            Clan clan = player.getClan();
            sb.append(Emoji.CLAN).append("Клан: ").append(clan.getName()).append("\n")
                    .append(Emoji.TOP).append("Рейтинг: ").append(NumberConverter.toString(clan.updateRating())).append("\n")
                    .append("Создан: ").append(formatter.format(new Date(clan.getCreateDate()))).append("\n")
                    .append("Создатель: ").append(Utils.createLink(playerService.getById(clan.getOwnerId()))).append("\n")
                    .append("Заместитель: ")
                    .append(clan.getViceId() == null ? "не назначен" : Utils.createLink(playerService.getById(clan.getViceId()))).append("\n")
                    .append("Участники:\n");
            String collect = clan.getMembers().stream()
                    .map(member -> Utils.createLink(playerService.getById(member)))
                    .collect(Collectors.joining(", "));
            sb.append(collect);
        }
        builder.row(List.of(
                Button.newButton()
                        .label(Emoji.MARK + "Команды")
                        .payload("command", "clan_commands")
                        .color(Color.WHITE)
                        .create(),
                Button.newButton()
                        .label(Emoji.TOP + "Топ")
                        .payload("command", "clan_rating")
                        .color(Color.WHITE)
                        .create(),
                Button.newButton()
                        .label("Главная")
                        .payload("command", "info")
                        .color(Color.BLUE)
                        .create()
        ));
        keyboard = builder.build();
        playerService.sendMessage(peerId, sb.toString(), keyboard);
    }
}
