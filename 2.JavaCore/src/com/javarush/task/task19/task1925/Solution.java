package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder lines = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                lines.append(fileReader.readLine());
                lines.append(" ");
            }
        }

        List<String> list = Arrays.stream(lines.toString().split("\\s"))
                .filter(s -> s.length() > 6)
                .collect(Collectors.toList());

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
            fileWriter.write(String.join(",", list));
        }
    }
}