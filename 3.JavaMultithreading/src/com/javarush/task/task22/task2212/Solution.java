package com.javarush.task.task22.task2212;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (telNumber.isEmpty()) return false;
        int digits = telNumber.replaceAll("\\D", "").length();
        if ((telNumber.charAt(0) == '+' && digits == 12) || (telNumber.charAt(0) != '+' && digits == 10)) {
            return telNumber.matches("(\\+\\d+)?\\d*(\\(\\d{3}\\))?\\d+(-?\\d+){0,2}");
        } else return false;
    }

    public static void main(String[] args) throws IOException {
        String path = "/PROJECTS/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2212/telephones.txt";
        List<String> telephones = Files.readAllLines(Paths.get(path));

        for (String s : telephones) {
            System.out.println(s + " - " + checkTelNumber(s));
        }

    }
}