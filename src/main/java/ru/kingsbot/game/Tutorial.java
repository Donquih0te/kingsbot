package ru.kingsbot.game;

import ru.kingsbot.Bot;
import ru.kingsbot.command.keyboard.Button;
import ru.kingsbot.command.keyboard.Color;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.service.PlayerService;

import java.util.List;

public class Tutorial {

    private final Player player;
    private final PlayerService playerService;
    private final Keyboard keyboard;

    public Tutorial(Player player) {
        this.player = player;
        playerService = Bot.getInstance().getPlayerService();
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        Button.newButton()
                                .label("Создать королевство")
                                .payload("command", "start")
                                .color(Color.BLUE)
                                .create()
                ))
                .build();
    }

    public void start() {
        player.setTutorial(true);
        playerService.validateName(player);
        StringBuilder sb = new StringBuilder();
        sb.append("На протяжении тысячелетий судьба человечества зависела от деяний отдельных людей.\n")
                .append("В каждом обществе был человек, который стоит во главе этого общества.\n")
                .append("Ты можешь стать таким человеком.\n")
                .append("Создай свой королевтсво и стань лучшим королем.\n");
        playerService.sendMessage(player.getId(), sb.toString(), keyboard);
        playerService.update(player);
    }

}
