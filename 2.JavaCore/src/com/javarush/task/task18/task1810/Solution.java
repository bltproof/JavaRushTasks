package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inFile;

        while (reader.ready()) {
            String fileName = reader.readLine();
            inFile = new FileInputStream(fileName);
            if (inFile.available() < 1000) {
                reader.close();
                inFile.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
