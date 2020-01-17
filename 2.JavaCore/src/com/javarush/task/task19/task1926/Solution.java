package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName;

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        }

        StringBuilder sb = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                sb.append(fileReader.readLine());
                sb.append("\n");
            }
        }
        String[] reverse = sb.reverse().toString().split("\n");

        for (int i = reverse.length - 1; i > 0; i--) {
            System.out.println(reverse[i]);
        }
    }
}
