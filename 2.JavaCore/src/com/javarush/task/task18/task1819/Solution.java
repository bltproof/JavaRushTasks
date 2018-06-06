package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        FileInputStream fileIn = new FileInputStream(fileName);

        byte[] buffer = new byte[fileIn.available()];

        while (fileIn.available() > 0) {
            fileIn.read(buffer);
        }

        fileIn.close();

        FileOutputStream fileOut = new FileOutputStream(fileName);
        FileInputStream file2In = new FileInputStream(fileName2);


        while (file2In.available() > 0) {
            int data = file2In.read();
            fileOut.write(data);
        }

        fileOut.write(buffer);

        scanner.close();
        file2In.close();
        fileOut.close();
    }
}
