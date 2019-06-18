package ru.kingsbot.game;

import lombok.extern.log4j.Log4j2;
import ru.kingsbot.Bot;
import ru.kingsbot.client.exception.InvalidResponseException;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.service.PlayerService;

import java.util.List;

@Log4j2
public class Tutorial {

    private final Player player;
    private final PlayerService playerService;
    private final Keyboard keyboard;

    public Tutorial(Player player) {
        this.player = player;
        playerService = Bot.getInstance().getPlayerService();
        keyboard = Keyboard.newKeyboard()
                .withRowButtons(List.of(
                        Button.newButton()
                                .label("Создать королевство")
                                .payload("command", "start")
                                .color(Color.BLUE)
                                .create()
                ))
                .create();
    }

    public void start() {
        player.setTutorial(true);
        try {
            playerService.validateName(player);
        } catch (InvalidResponseException e) {
            log.error(e.getVkError().getErrorMessage(), e);
            throw new RuntimeException(e.getVkError().getErrorMessage());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("На протяжении тысячелетий судьба человечества зависела от деяний отдельных людей.\n")
                .append("В каждом обществе был человек, который стоит во главе этого общества.\n")
                .append("Ты можешь стать таким человеком.\n")
                .append("Создай свой королевтсво и стань лучшим королем.\n");
        playerService.sendMessage(player.getId(), sb.toString(), keyboard);
        playerService.update(player);
    }

}
