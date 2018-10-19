package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> map = new TreeMap<>();

            while (fileReader.ready()) {
                String[] line = fileReader.readLine().split(" ");
//                if (map.containsKey(line[0])) {
//                    map.put(line[0], map.get(line[0]) + Double.parseDouble(line[1]));
//                } else {
//                    map.put(line[0], Double.parseDouble(line[1]));
//                }
                map.put(line[0], map.containsKey(line[0]) ? map.get(line[0]) + Double.parseDouble(line[1]) : Double.parseDouble(line[1]));
            }
//            for (Map.Entry<String, Double> pair : map.entrySet()) {
//                System.out.println(pair.getKey() + " " + pair.getValue());
//            }
            map.forEach((k, v) -> System.out.println(k + " " + v));
        }
    }
}
