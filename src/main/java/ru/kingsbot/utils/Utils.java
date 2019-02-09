package ru.kingsbot.utils;

import ru.kingsbot.entity.Player;

import java.util.Base64;
import java.util.List;
import java.util.Random;

public class Utils {

    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final Random RANDOM = new Random();

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
            return list.get(RANDOM.nextInt(list.size()));
        }
        return null;
    }

    public static String encodeSignature(String src) {
        return encoder.encodeToString(encoder.encodeToString(src.getBytes()).getBytes());
    }

    public static String decodeSignature(String src) {
        return new String(decoder.decode(decoder.decode(src))).intern();
    }

    public static boolean checkSignature(String key, int id, String command) {
        if(key == null) {
            return false;
        }
        String[] keys = Utils.decodeSignature(key).split("-");
        return parseInt(keys[0]) == id && keys[1].equals(command);
    }

    public static int parseInt(String s) {
        int i;
        try {
            i = Integer.parseInt(s);
        }catch(NumberFormatException ignore) {
            i = 0;
        }
        return i;
    }

    public static double parseDouble(String s) {
        double i;
        try {
            i = Double.parseDouble(s);
        }catch(NumberFormatException ignore) {
            i = 0;
        }
        return i;
    }

}
