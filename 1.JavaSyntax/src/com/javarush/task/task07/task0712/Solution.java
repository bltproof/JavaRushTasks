package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<String> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minFirst = 0;
        int maxFirst = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 10; i++) {
                String str = reader.readLine();
                int length = str.length();

                if (length < min) {
                    min = length;

                    minFirst = i;
                }
                if (length > max) {
                    max = length;

                    maxFirst = i;
                }
                list.add(str);
            }
        }

        if (minFirst < maxFirst) {
            System.out.println(list.get(minFirst));

        } else {
            System.out.println(list.get(maxFirst));

        }
    }
}
