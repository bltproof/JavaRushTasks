package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String fileName = reader.readLine();
                try (FileReader fileReader = new FileReader(fileName)) {
                } catch (FileNotFoundException e) {
                    System.out.println(fileName);
                    break;
                }
            }
        }
    }
}
