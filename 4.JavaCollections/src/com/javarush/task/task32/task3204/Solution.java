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

        for (int i = 0; i < 8; i++) {
            out.write("abcdefghijklmnopqrstuvwxyz".charAt(new Random().nextInt(26)));
            out.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(new Random().nextInt(26)));
            if (out.size() == 8) return out;
            out.write("1234567890".charAt(new Random().nextInt(10)));
        }
        return out;
    }
}