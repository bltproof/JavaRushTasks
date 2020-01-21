package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<String> list = new ArrayList<>();

        int previousLength = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 10; i++) {
                list.add(reader.readLine());
            }
        }

        for (int i = 0; i < 10; i++) {
            int length = list.get(i).length();

            if (length > previousLength) {
                previousLength = length;

            } else {
                System.out.println(i);
                break;
            }
        }
    }
}

