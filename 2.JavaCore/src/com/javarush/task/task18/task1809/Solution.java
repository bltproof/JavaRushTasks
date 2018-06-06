package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {

    private static void reverseArray(byte[] b) {
        for (int i = b.length / 2 - 1, j = b.length - 1 - i; i >= 0; i--, j++) {
            byte temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream inFile = new FileInputStream(fileName);
        FileOutputStream outFile = new FileOutputStream(fileName2);

        if (inFile.available() > 0) {
            byte[] buffer = new byte[inFile.available()];
            inFile.read(buffer);
            reverseArray(buffer);
            outFile.write(buffer);
        }


        reader.close();
        inFile.close();
        outFile.close();
    }
}
