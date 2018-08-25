package com.javarush.task.task18.task1828;

/*
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        List<String> linesList = new ArrayList<>();
        List<String> updatedLines = new ArrayList<>();
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                while (fileReader.ready()) {
                    linesList.add(fileReader.readLine());
                }
            }
        }

        if (args[0].equals("-u") && args.length > 2) {
            int position = 0;
            String newLine = String.format("%-8s%-30.30s%-8s%-4s", args[1], args[2], args[3], args[4]);
            for (String value : linesList) {
                String stringId = value.substring(0, 8).trim();
                if (stringId.equals(args[1])) {
                    updatedLines.add(position, newLine);
                } else {
                    updatedLines.add(position, value);
                }
                position++;
            }
            writeToFile(updatedLines, fileName);
        }
        if (args[0].equals("-d") && args.length == 2) {
            for (int i = 0; i < linesList.size(); i++) {
                String stringId = linesList.get(i).substring(0, 8).trim();
                if (stringId.equals(args[1])) {
                    linesList.remove(i);
                }
            }
            writeToFile(linesList, fileName);
        }
    }

    private static void writeToFile(List<String> list, String fileName) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i));
                if (i < list.size() - 1) {
                    fileWriter.newLine();
                }
            }
        }
    }
}