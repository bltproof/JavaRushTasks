package com.javarush.task.task18.task1802;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());

        int min = Integer.MAX_VALUE;

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();

            if (data < min) {
                min = data;
            }
        }
        System.out.println(min);
        fileInputStream.close();
    }
}
