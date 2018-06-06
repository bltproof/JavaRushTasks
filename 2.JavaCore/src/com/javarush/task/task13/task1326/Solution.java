package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> list = new ArrayList<>();
            String fileName = reader.readLine();

            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));){

                while (fileReader.ready()) {
                    String value = fileReader.readLine();
                    int x = Integer.valueOf(value);
                    if (x % 2 == 0) {
                        list.add(x);
                    }
                }
                Collections.sort(list);

                for (Integer value : list) {
                    System.out.println(value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
