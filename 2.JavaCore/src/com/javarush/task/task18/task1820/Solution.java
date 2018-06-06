package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        //мое тупое решение
        /*Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            data = (int) Math.round(data);
            fileOutputStream.write(data);
        }
        scanner.close();
        fileInputStream.close();
        fileOutputStream.close();*/

        //решение участников из комментов на странице задачи
        BufferedReader readBuff = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readBuff.readLine();
        String fileName2 = readBuff.readLine();
        readBuff.close();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName1)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName2)))) {

            String line;

            if ((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");

                for (String num : numbers) {
                    try {
                        int res = (int) Math.round(Double.parseDouble(num));
                        writer.write(res + " ");
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
