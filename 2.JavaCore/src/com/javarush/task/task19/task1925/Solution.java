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
        String[] array;
        StringBuilder lines = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                array = fileReader.readLine().split("\\s");
                for (String line : array) {
                    lines.append(line);
                    lines.append(" ");
                }
            }
        }

        List<String> list = Arrays.stream(lines.toString().split("\\s"))
                .filter(s -> s.length() > 6)
                .collect(Collectors.toList());

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if ((list.size() - 1) - i == 0) {
                    break;
                }
                sb.append(",");
            }
            fileWriter.write(sb.toString());
        }
    }
}