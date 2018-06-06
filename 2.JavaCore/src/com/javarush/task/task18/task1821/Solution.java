package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);

        //создаю map для отсортированного списка по ключу (байту)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();

            if (treeMap.containsKey(data)){ //если  байт есть в карте
                for (Map.Entry<Integer, Integer> pair : treeMap.entrySet()) { //ищу ключ
                    if (pair.getKey().equals(data))
                        pair.setValue(pair.getValue()+1); //нахожу и увеличиваю значение Value
                }
            } else
                treeMap.put(data, 1); //если ключа нет добавляю в карту и ставлю значение 1
        }
        inputStream.close();

        for (Map.Entry<Integer,Integer> pair : treeMap.entrySet()) {
            int a = pair.getKey();
            int b = pair.getValue();
            char ch = (char) a;

            System.out.println(ch + " " + b); //преобразую байт в строку и вывожу результат
        }
    }
}
