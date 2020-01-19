package com.javarush.task.task05.task0507;

import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int count = 0;
        double result = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                double number = scanner.nextDouble();
                if (number == -1) {
                    break;
                }
                result += number;
                count++;
            }
        }
        if (count != 0) {
            System.out.println(result / count);
        } else {
            System.out.println(result);
        }
    }
}