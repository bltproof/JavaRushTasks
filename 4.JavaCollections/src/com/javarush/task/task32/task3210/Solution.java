package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        int number = Integer.parseInt(args[1]);
        int textLen = args[2].length();

        RandomAccessFile randFile = new RandomAccessFile(args[0], "rw");
        randFile.seek(number);

        byte[] buffer = new byte[args[2].getBytes().length];
        randFile.read(buffer, 0, textLen);

        String txt = new String(buffer);

        randFile.seek(randFile.length());

        if (txt.equals(args[2])) {
            randFile.write("true".getBytes());
        } else {
            randFile.write("false".getBytes());
        }
        randFile.close();
    }
}