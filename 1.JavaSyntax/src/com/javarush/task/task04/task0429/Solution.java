package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a;
        int b;
        int c;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
            c = Integer.parseInt(reader.readLine());
        }

        int positive = 0;
        int negative = 0;

        if (a < 0) negative++;
        if (b < 0) negative++;
        if (c < 0) negative++;

        System.out.println("количество отрицательных чисел: " + negative);

        if (a > 0) positive++;
        if (b > 0) positive++;
        if (c > 0) positive++;

        System.out.println("количество положительных чисел: " + positive);


    }
}
