package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.parseInt(reader.readLine());
            if (x >= 1 && x <= 999) {
                if (x % 2 == 0) {

                    if (x <= 9) {
                        System.out.println("четное однозначное число");
                    } else if (x <= 99) {
                        System.out.println("четное двузначное число");
                    } else {
                        System.out.println("четное трехзначное число");
                    }

                } else {

                    if (x <= 9) {
                        System.out.println("нечетное однозначное число");
                    } else if (x <= 99) {
                        System.out.println("нечетное двузначное число");
                    } else {
                        System.out.println("нечетное трехзначное число");
                    }
                }
            }
        }
    }
}