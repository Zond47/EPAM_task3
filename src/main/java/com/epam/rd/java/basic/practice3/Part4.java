package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Method returns hash as a byte array.
 */
public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.print(hash("asdf", "MD5"));
        System.out.print(hash("asdf", "SHA-256"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        String generatedPassword;
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            sb.append(String.format("%02X", hash[i]));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
    }
}

