package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> map = new TreeMap<>();

            while (fileReader.ready()) {
                String[] line = fileReader.readLine().split(" ");

                map.put(line[0], map.containsKey(
                        line[0]) ? map.get(line[0]) + Double.parseDouble(line[1]
                ) : Double.parseDouble(line[1]));
            }
            double topSalary = Collections.max(map.values());

            for (Map.Entry<String, Double> pair : map.entrySet()){
                if (pair.getValue() == topSalary) {
                    System.out.println(pair.getKey());
                }
            }
        }
    }
}
