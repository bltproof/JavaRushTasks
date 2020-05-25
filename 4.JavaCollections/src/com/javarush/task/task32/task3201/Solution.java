package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        int number = Integer.parseInt(args[1]);

        RandomAccessFile randFile = new RandomAccessFile(args[0], "rw");

        if (randFile.length() < number) {

            randFile.seek(randFile.length());

        } else {

            randFile.seek(number);
        }

        randFile.write(args[2].getBytes());
        randFile.close();
    }
}