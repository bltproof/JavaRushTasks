package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName = null;
        FileInputStream fileInputStream = null;

        try {
            fileName = new Scanner(System.in).nextLine();

            try {
                fileInputStream = new FileInputStream(fileName);

                //массив где будут индексы - "высота байта", значения - счетчик частоты этих байт
                byte[] bytes = new byte[256];
                byte byteLow;

                try {
                    //заносим в массив
                    while (fileInputStream.available() > 0) {

                        byteLow = (byte) fileInputStream.read();
                        bytes[byteLow] += 1;
                    }

                    //вычисляем "наименьшую частоту встречаемости байта"
                    byte minValue = 127;

                    for (int i = 0; i < bytes.length; i++) {

                        if (bytes[i] < minValue && bytes[i] != 0) {
                            minValue = bytes[i];
                        }
                    }

                    //в соответствии с частотой выводим байт
                    for (int i = 0; i < bytes.length; i++) {

                        if (bytes[i] == minValue) {
                            System.out.print(i);
                            System.out.print(" ");
                        }
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());

        }

    }
}
