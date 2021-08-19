package com.epam.rd.java.basic.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class with static methods that convert input data to output data.
 */

public class Part1 {

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.print(convert1(input));
        System.out.print(convert2(input));
        System.out.print(convert3(input));
        System.out.print(convert4(input));

    }

    public static String convert1(String input) {
        Pattern pattern = Pattern.compile("(?m)^(.+?);(.+?);(.+?)$");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            if (matcher.group(3).matches("(.*@.*)")) {
                sb.append(matcher.group(1) + ": " + matcher.group(3) + "\n");
            }
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        Pattern pattern = Pattern.compile("(?m)^(.+?);(.+?) (.+?);(.+?)$");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            sb.append(matcher.group(3) + " " + matcher.group(2) + " (email: " + matcher.group(4) + ")\n");
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        Pattern pattern = Pattern.compile("(?m)^(.+?)@(.+?)$");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        StringBuilder domens = new StringBuilder();

        while (matcher.find()) {
            if (!domens.toString().contains(matcher.group(2))) {
                domens.append(matcher.group(2) + " ");
            }
        }

        for (String e : domens.toString().split(" ")) {
            pattern = Pattern.compile("(?m)^(.+?);(.+?)@(" + e + ")$");
            matcher = pattern.matcher(input);
            sb.append(e + " ==> ");
            while (matcher.find()) {
                sb.append(matcher.group(1) + ", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String convert4(String input) {
        Pattern pattern = Pattern.compile("(?m)^(.+?)$");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();

        while (matcher.find()) {
            if (matcher.group(0).matches("(.*@.*)")) {
                String password = String.format("%04d", random.nextInt(10000));
                sb.append(matcher.group(0) + ";" + password + "\n");
            } else {
                sb.append(matcher.group(0) + ";Password\n");
            }
        }
        return sb.toString();
    }
}
