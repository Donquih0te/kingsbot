package ru.kingsbot.utils;

import ru.kingsbot.entity.Player;

import java.util.List;
import java.util.Random;

public class Utils {

    public static String createLink(Player player) {
        StringBuilder sb = new StringBuilder();
        if(player.getFirstName() == null) {
            return "";
        }
        if(player.isNotify()) {
            sb.append("@id").append(player.getId()).append("(").append(player.getFirstName()).append(")");
        }else{
            sb.append(player.getFirstName());
        }
        return sb.toString();
    }

    public static <T> T getRandomValueFromList(List<T> list) {
        if(!list.isEmpty()) {
            return list.get(new Random().nextInt(list.size()));
        }
        return null;
    }

}
