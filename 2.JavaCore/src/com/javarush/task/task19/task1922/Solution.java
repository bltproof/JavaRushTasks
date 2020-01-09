package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String fileName = reader.readLine();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {

                String line;

                while ((line = fileReader.readLine()) != null) {
                    int count = 0;

                    for (String s : line.split(" ")) {
                        for (String w : words) {
                            Matcher m = Pattern.compile("\\b" + w + "\\b").matcher(s);
                            if (m.find()) {
                                count++;
                            }
                        }
                    }
                    if (count == 2) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
