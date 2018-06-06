package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());

        int max = 0;

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();

            if (data > max) {
                max = data;
            }
        }
        System.out.println(max);
        fileInputStream.close();

    }
}
