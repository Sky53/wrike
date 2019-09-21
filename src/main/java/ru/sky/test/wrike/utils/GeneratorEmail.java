package ru.sky.test.wrike.utils;

public class GeneratorEmail {
    private static final String mask = "+wpt@wriketask.qaa";
    private static final String symbol = "abcdefghijklmnopqrstuvwxyz";


    public static String getTestEmail(int count) {

        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()* symbol.length());
            builder.append(symbol.charAt(character));
        }
        return builder.toString() + mask;
    }


}
