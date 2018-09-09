package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<Character> charList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileNameRead = reader.readLine();
            String fileNameWrite = reader.readLine();
            readFile(fileNameRead);
            writeFile(fileNameWrite);
        }
    }

    private static void readFile(String fileNameRead) {
        try (FileReader fileReader = new FileReader(fileNameRead)) {
            int readed;
            while ((readed = fileReader.read()) != -1) {
                charList.add((char) readed);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void writeFile(String fileNameWrite) {
        try (FileWriter fileWriter = new FileWriter(fileNameWrite)) {
            int index = 1;
            for (Character ch : charList) {
                if (index % 2 == 0) {
                    fileWriter.write(ch);
                }
                index++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
