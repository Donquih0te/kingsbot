package ru.kingsbot.command.keyboard;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.kingsbot.utils.Emoji;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Keyboards {

    @Getter
    private static Keyboard groupKeyboard;
    @Getter
    private static Keyboard chatKeyboard;

    public static void init() {
        groupKeyboard = Keyboard.newKeyboard()
                .withRowButtons(0, List.of(
                        Button.newButton().label(Emoji.INFO + "Инфо").color(Color.GREEN).payload("command", "info").create(),
                        Button.newButton().label(Emoji.BUILDINGS + "Строения").color(Color.WHITE).payload("command", "building").create(),
                        Button.newButton().label(Emoji.RESOURCES + "Ресурсы").color(Color.WHITE).payload("command", "resource").create()
                ))
                .withRowButtons(1, List.of(
                        Button.newButton().label(Emoji.AGE + "Эпоха").color(Color.WHITE).payload("command", "age").create(),
                        Button.newButton().label(Emoji.ARMY + "Армия").color(Color.WHITE).payload("command", "army").create(),
                        Button.newButton().label(Emoji.CLAN + "Клан").color(Color.WHITE).payload("command", "clan").create()
                ))
                .withRowButtons(2, List.of(
                        Button.newButton().label(Emoji.MARKET + "Рынок").color(Color.WHITE).payload("command", "market").create(),
                        Button.newButton().label(Emoji.BOSS + "Босс").color(Color.WHITE).payload("command", "boss").create(),
                        Button.newButton().label(Emoji.TOP + "Топ").color(Color.WHITE).payload("command", "top").create()
                ))
                .withRowButtons(3, List.of(
                        Button.newButton().label("Друзья").color(Color.WHITE).payload("command", "friend").create(),
                        Button.newButton().label("Помощь").color(Color.GREEN).payload("command", "help").create()
                ))
                .create();

        chatKeyboard = Keyboard.newKeyboard()
                .withRowButtons(List.of(
                        Button.newButton().label(Emoji.INFO + "Инфо").color(Color.GREEN).payload("command", "info").create(),
                        Button.newButton().label(Emoji.ROCK_THROWER + "Охота").color(Color.WHITE).payload("command", "hunting").create(),
                        Button.newButton().label(Emoji.ARMY + "Набег").color(Color.WHITE).payload("command", "raid").create()
                ))
                .withRowButtons(List.of(
                        Button.newButton().label(Emoji.GOLD + "Дань").color(Color.GREEN).payload("command", "tribute").create(),
                        Button.newButton().label(Emoji.TOP + "Топ").color(Color.WHITE).payload("command", "top").create()
                ))
                .create();
    }

}
