package ru.kingsbot.utils;

import java.text.DecimalFormat;

public class NumberConverter {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.#");

    public static String toString(Integer number) {
        return toString(number.longValue());
    }

    public static String toString(Long number) {
        if(number < 1000) {
            return String.valueOf(number);
        }
        StringBuilder sb = new StringBuilder();
        int thousandths = String.valueOf(number).length() / 3;
        if((number / Math.pow(1000, thousandths)) < 1) {
            thousandths--;
        }
        for(int i = 0; i < thousandths; i++) {
            if(i + 1 == thousandths) {
                String d = FORMAT.format(number / Math.pow(1000d, thousandths));
                sb.insert(0, d);
            }
            sb.append("k");
        }
        return sb.toString().replace(",", ".");
    }

    public static Long toInt(String number) {
        //TODO: для TextCommandParser
        return 0L;
    }

}
