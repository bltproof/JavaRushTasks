package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java Java Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java Java Java Java."));
        System.out.println(getPartOfString("JavaRush - лучший."));
    }

    public static String getPartOfString(String string) {
        String[] array;

        if (string == null || (array = string.split(" ")).length - 1 < 4) {
            throw new TooShortStringException();
        }

        if (array.length - 1 > 4) {
            return string.substring(string.indexOf(" "), string.indexOf(array[4]) + array[4].length()).trim();
        }
        return string.substring(string.indexOf(" ")).trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}