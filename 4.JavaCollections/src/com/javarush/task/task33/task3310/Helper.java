package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(36);
    }

    public static String generateRandomString() {
        return new Helper().nextSessionId();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}