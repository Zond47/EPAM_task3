package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The task should show words of the minimum length and the maximum length in the format specified.
 */

public class Part2 {

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        System.out.print(convert(input));
    }

    public static String convert(String input) {
        String[] array = input.split("[\\W\n]+");

        Pattern p = Pattern.compile("(?m)([a-zA-ZА-Яа-я]+)");
        Matcher matcher = p.matcher(input);
        int min = array[0].length();
        int max = min;
        while (matcher.find()) {
            int length = matcher.group().length();
            if (min > length) {
                min = length;
            } else if (max < length) {
                max = length;
            }
        }

        StringBuilder sbMin = new StringBuilder("Min: ");
        StringBuilder sbMax = new StringBuilder("Max: ");

        p = Pattern.compile("(?m)([a-zA-ZА-Яа-я]+)");
        matcher = p.matcher(input);
        while (matcher.find()) {
            int length = matcher.group().length();
            if (length == min || length == max) {
                if (length == min && !sbMin.toString().contains(matcher.group())) {
                    sbMin.append(matcher.group() + ", ");
                } else if (length == max && !sbMax.toString().contains(matcher.group())) {
                    sbMax.append(matcher.group() + ", ");
                }
            }
        }

        sbMin.setLength(sbMin.length() - 2);
        sbMin.append("\n").append(sbMax.substring(0, sbMax.length() - 2));
        return sbMin.toString();
    }
}
