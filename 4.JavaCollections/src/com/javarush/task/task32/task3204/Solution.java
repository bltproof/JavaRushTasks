package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";

        for (int i = 0; i < 8; i++) {
            out.write(alphabetLowerCase.charAt(new Random().nextInt(alphabetLowerCase.length())));
            out.write(alphabetUpperCase.charAt(new Random().nextInt(alphabetUpperCase.length())));
            if (out.size() == 8) return out;
            out.write(numbers.charAt(new Random().nextInt(numbers.length())));
        }
        return out;
    }
}