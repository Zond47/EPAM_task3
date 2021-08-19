package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that convert data from the decimal system to the Roman number system and vice versa.
 */

public class Part5 {
    static int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 94, 95, 96, 97, 98, 99, 100};
        for (int item : numbers) {
            System.out.print(item + " --> " + decimal2Roman(item) + " --> "
                    + roman2Decimal(decimal2Roman(item)) + "\n");
        }
    }

    public static String decimal2Roman(int dec) {
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (dec >= values[i]) {
                dec -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    public static int roman2Decimal(String roman) {
        Matcher matcher = Pattern.compile("C|XC|L|XL|X|IX|V|IV|I").matcher(roman);
        int result = 0;
        while (matcher.find()) {
            for (int i = 0; i < romanLiterals.length; i++) {
                if (romanLiterals[i].equals(matcher.group(0))) {
                    result += values[i];
                }
            }
        }
        return result;
    }
}
