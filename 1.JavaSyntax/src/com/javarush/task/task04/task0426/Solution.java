package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            a = Integer.parseInt(reader.readLine());
        }

        if (Math.signum(a) == 1) {
            System.out.println(a % 2 == 0 ? "положительное четное число" : "положительное нечетное число");

        } else if (a == 0) {
            System.out.println("ноль");

        } else {
            System.out.println(a % 2 == 0 ? "отрицательное четное число" : "отрицательное нечетное число");

        }
    }
}
