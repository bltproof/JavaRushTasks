package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    static double countAll = 0;
    static double countSym = 0;
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        for (int i = 0; fileInputStream.available() > 0; i++) {
            int data = fileInputStream.read();
            if (data != 2 && data != 10 && data != 13) {
                ++countAll;
            }
            if (data == 32) {
                ++countSym;
            }
        }

        double result = (countSym / countAll) * 100;
        System.out.printf("%.2f", result);

        fileInputStream.close();
    }

}
