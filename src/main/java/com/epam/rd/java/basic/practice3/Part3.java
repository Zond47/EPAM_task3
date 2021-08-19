package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * First character of each word, that consists of three or more characters, should be inverted.
 */

public class Part3 {

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.print(convert(input));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile("(?m)([a-zA-ZА-Яа-я]+)");
        Matcher matcher = p.matcher(input);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            if (matcher.group().length() > 2) {
                char letter = matcher.group().charAt(0);
                if (matcher.group().matches("[^A-ZА-Я]+")) {
                    matcher.appendReplacement(buffer, Character.toUpperCase(letter) + matcher.group().substring(1));
                } else {
                    matcher.appendReplacement(buffer, Character.toLowerCase(letter) + matcher.group().substring(1));
                }
            } else {
                matcher.appendReplacement(buffer, matcher.group());
            }
        }
        return buffer.toString();
    }
}
