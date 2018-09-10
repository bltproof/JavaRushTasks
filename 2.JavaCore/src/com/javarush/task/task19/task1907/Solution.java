package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileNameRead = reader.readLine();
            readFile(fileNameRead);
            printCount();
        }
    }

    private static void readFile(String fileNameRead) {
        try (FileReader fileReader = new FileReader(fileNameRead)) {
            while (fileReader.ready()) {
                sb.append((char) fileReader.read());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void printCount() {
        int wordCount = 0;
        String[] sArray = sb.toString().split("[\\W]");
        for (String word : sArray) {
            if ("world".equals(word)) {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
}
