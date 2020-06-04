package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            //Говнокод без сплита
            /*
            int tabCount = 0;

            for (int i = 0; i < string.length(); i++) { //Получаю сумму символов табуляции из строки
                if (string.charAt(i) == '\t') {
                    tabCount++;
                }
            }

            int[] tabIndexArray = new int[tabCount];

            for (int i = 0; i < string.length(); i++) { //Заполняю массив индексами позиций каждого символа табуляции
                if (string.charAt(i) == '\t') {
                    tabIndexArray[--tabCount] = i;
                }
            }

            return string.substring(tabIndexArray[tabIndexArray.length - 1], tabIndexArray[tabIndexArray.length - 2]).trim();
            */

            String[] arr = string.split("\t");
            if (arr.length < 3) throw new TooShortStringException();

            return arr[1].trim();

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