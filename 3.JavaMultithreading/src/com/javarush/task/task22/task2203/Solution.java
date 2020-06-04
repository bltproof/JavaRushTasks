package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int tabCount = 0;

            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == 9) {
                    tabCount++;
                }
            }

            int[] tabIndexArray = new int[tabCount];

            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == 9) {
                    tabIndexArray[--tabCount] = i;
                }
            }

            return string.substring(tabIndexArray[tabIndexArray.length - 1], tabIndexArray[tabIndexArray.length - 2]).trim();

        } catch (Exception ex) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("Начало \tЯвляется - лучшим временем \tконец худшим\t."));
        System.out.println(getPartOfString("Начало \tНужно для того \t - лучшим \t временем \tконец худшим\t."));
        System.out.println(getPartOfString("Начало \tНужно для того"));
    }
}