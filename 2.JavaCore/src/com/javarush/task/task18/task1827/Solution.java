package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            return;
        }

        List<String> lineList = new ArrayList<>();
        List<Integer> idList = new ArrayList<>();
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                int count = 0;
                while (fileReader.ready()) {
                    lineList.add(fileReader.readLine());
                    idList.add(Integer.parseInt(lineList.get(count).substring(0, 8).trim()));
                    count++;
                }
            }
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            int max = idList.get(0);
            for (Integer value : idList) {
                if (value > max) {
                    max = value;
                }
            }
            if (args[0].equals("-c")) {
                fileWriter.newLine();
                fileWriter.write(String.format("%-8d%-30.30s%-8.8s%-4.4s", ++max, args[1], args[2], args[3]));
            }
        }
    }
}
