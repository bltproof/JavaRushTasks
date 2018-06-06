package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {

    public static void main(String[] args) {

        String fileName = null;
        FileInputStream fileInputStream = null;

        try {
            fileName = new Scanner(System.in).nextLine();

            try {
                fileInputStream = new FileInputStream(fileName);

                //массив где будут индексы - "высота байта", значения - счетчик частоты этих байт
                byte[] bytes = new byte[256];
                int byteHigh;

                try {
                    //заносим в массив
                    while (fileInputStream.available() > 0) {

                        byteHigh = fileInputStream.read();
                        bytes[byteHigh] += 1;
                    }

                    //вычисляем "наибольшую частоту встречаемости байта"
                    int maxValue = bytes[0];

                    for (int i = 0; i < bytes.length; i++) {

                        int tmpData = bytes[i];

                        if (tmpData > maxValue) {
                            maxValue = tmpData;
                        }

                    }

                    //в соответствии с частотой выводим байт
                    for (int i = 0; i < bytes.length; i++) {

                        if (bytes[i] == maxValue) {
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
