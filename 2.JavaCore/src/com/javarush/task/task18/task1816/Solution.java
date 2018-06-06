package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File(args[0]));

        int count = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if ((data >= 65 && data <= 90) || (data >= 97 && data <= 122)) {
                count++;
            }
        }

        System.out.println(count);
        fileInputStream.close();
    }
}
