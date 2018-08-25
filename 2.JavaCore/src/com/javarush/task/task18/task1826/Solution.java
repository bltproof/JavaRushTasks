package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream(args[1]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[2])) {

            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            if ("-e".equals(args[0])) {
                for (int i = 0; i < buffer.length; ++i) {
                    ++buffer[i];
                }
            } else if ("-d".equals(args[0])) {
                for (int i = 0; i < buffer.length; ++i) {
                    --buffer[i];
                }
            }
            fileOutputStream.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
