package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {

            String[] line = fileReader.readLine().split(" ");
            for (String element : line) {
                try {
                    int number = Integer.parseInt(element);
                    fileWriter.write(number + " ");

                } catch (NumberFormatException ex) {
                    continue;
                }
            }
        }
    }
}

