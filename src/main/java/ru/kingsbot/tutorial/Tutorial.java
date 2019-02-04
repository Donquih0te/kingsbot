package ru.kingsbot.tutorial;

import ru.kingsbot.Bot;
import ru.kingsbot.api.keyboard.Action;
import ru.kingsbot.api.keyboard.Button;
import ru.kingsbot.api.keyboard.Color;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Map;

public class Tutorial {

    private Bot bot;
    private Keyboard keyboard;
    private Player player;

    public Tutorial(Player player) {
        bot = Bot.getInstance();
        this.player = player;
        keyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action("Создать", Map.of("command", "start")), Color.BLUE)
                ))
                .build();
    }

    public void start() {
        player.setTutorial(true);
        bot.setName(player);
        StringBuilder sb = new StringBuilder();
        sb.append("На протяжении тысячелетий судьба человечества зависела от деяний отдельных людей.\n")
                .append("В каждом обществе был человек, который стоит во главе этого общества.\n")
                .append("Ты можешь стать таким человеком.\n")
                .append("Создай свой королевтсво и стань лучшим королем.\n");
        bot.sendMessage(player.getId(), sb.toString(), keyboard);
        bot.getPlayerRepository().update(player);
    }

}
