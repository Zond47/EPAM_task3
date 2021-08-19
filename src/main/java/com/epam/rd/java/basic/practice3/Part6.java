package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * All the recurring words should be preceded by underscore.
 */

public class Part6 {

    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        convert(input);
    }

    public static boolean isUnique(String input, String word) {
        input = input.replaceAll("\r\n", " ");
        String[] array = input.split("[^a-zA-Z\\p{IsCyrillic}]+");
        int count = 0;
        for (String item : array) {
            if (item.equals(word)) {
                count++;
            }
        }
        return count == 1;
    }

    public static String convert(String input) {
        StringBuffer buffer = new StringBuffer();
        Pattern pattern = Pattern.compile("(?m)([a-zA-Z\\p{IsCyrillic}]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if (isUnique(input, matcher.group())) {
                matcher.appendReplacement(buffer, matcher.group());
            } else {
                matcher.appendReplacement(buffer, "_" + matcher.group());
            }
        }
        return buffer.toString();
    }
}
