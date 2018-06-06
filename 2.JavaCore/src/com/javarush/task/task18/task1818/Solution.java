package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String fileName, fileName2, fileName3;
        fileName = scanner.nextLine();
        fileName2 = scanner.nextLine();
        fileName3 = scanner.nextLine();
        FileOutputStream file = new FileOutputStream(fileName);
        FileInputStream file2 = new FileInputStream(fileName2);
        FileInputStream file3 = new FileInputStream(fileName3);


        while (file2.available() > 0) {
            int data = file2.read();
            file.write(data);
        }

        while (file3.available() > 0) {
            int data = file3.read();
            file.write(data);
        }

        scanner.close();
        file.close();
        file2.close();
        file3.close();
    }
}
