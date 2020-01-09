package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        String fileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        try (FileReader fileReader = new FileReader(fileName)){

            int a;

            while ((a = fileReader.read())!= -1) {
                sb.append((char)a);
            }
        }

        String[] str = sb.toString().split("\n");

        for (String s : str) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                s = s.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
            }
            list.add(s);
        }

        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}
