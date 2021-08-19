package com.epam.rd.java.basic.practice3;

import java.io.File;
import java.util.Scanner;

/**
 * class Util.
 */
public class Util {
    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String input = Util.getInput("part1.txt");
            System.out.print(input);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
