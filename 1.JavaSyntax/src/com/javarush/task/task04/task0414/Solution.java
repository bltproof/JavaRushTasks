package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int num;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            num = Integer.parseInt(reader.readLine());
        }

        if (num % 400 == 0 || num % 4 == 0 && num % 100 != 0) {
            System.out.println("количество дней в году: 366");

        } else {
            System.out.println("количество дней в году: 365");
        }
    }
}