package ru.kingsbot.api.keyboard;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.kingsbot.Emoji;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Keyboards {

    @Getter
    private static Keyboard groupKeyboard;
    @Getter
    private static Keyboard chatKeyboard;

    public static void init() {
        groupKeyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.INFO + "Инфо", Map.of("command", "info")), Color.GREEN),
                        new Button(new Action(Emoji.BUILDINGS + "Строения", Map.of("command", "building")), Color.WHITE),
                        new Button(new Action(Emoji.RESOURCES + "Ресурсы", Map.of("command", "resource")), Color.WHITE)
                        )
                )
                .row(List.of(
//                        new Button(new Action(Emoji.HEROES + "Герои", Map.of("command", "hero")), Color.WHITE),
                        new Button(new Action(Emoji.AGE + "Эпоха", Map.of("command", "age")), Color.WHITE),
                        new Button(new Action(Emoji.ARMY + "Армия", Map.of("command", "army")), Color.WHITE),
                        new Button(new Action(Emoji.CLAN + "Клан", Map.of("command", "clan")), Color.WHITE)
                        )
                )
                .row(List.of(
                        new Button(new Action(Emoji.MARKET + "Рынок", Map.of("command", "market")), Color.WHITE),
                        new Button(new Action(Emoji.BOSS + "Босс", Map.of("command", "boss")), Color.WHITE),
                        new Button(new Action(Emoji.TOP + "Топ", Map.of("command", "top")), Color.WHITE)
                        )
                )
                .row(List.of(
                        //new Button(new Action("Донат", Map.of("command", "donat")), Color.WHITE),
                        //new Button(new Action("Настройки", Map.of("command", "settings")), Color.WHITE),
                        new Button(new Action("Помощь", Map.of("command", "help")), Color.GREEN)
                        )
                )
                .build();

        chatKeyboard = Keyboard.newKeyboard()
                .row(List.of(
                        new Button(new Action(Emoji.INFO + "Инфо", Map.of("command", "info")), Color.GREEN),
                        new Button(new Action(Emoji.ROCK_THROWER + "Охота", Map.of("command", "hunting")), Color.WHITE),
                        new Button(new Action(Emoji.ARMY + "Набег", Map.of("command", "raid")), Color.WHITE)
                        )
                )
                .row(List.of(
                        new Button(new Action(Emoji.GOLD + "Дань", Map.of("command", "tribute")), Color.WHITE),
                        new Button(new Action(Emoji.TOP + "Топ", Map.of("command", "top")), Color.WHITE)
                        )
                )
                .build();
    }

}
