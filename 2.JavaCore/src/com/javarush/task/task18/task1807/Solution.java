package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());

        List<Integer> intArray = new ArrayList<>();
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            intArray.add(data);
        }
        inputStream.close();

        /*int count = 0;
        for (Integer value : intArray) {
            if (value == (int)',') count++;
        }
        System.out.println(count);*/

        //То же самое, что и в закомментированном блоке кода
        System.out.println(Collections.frequency(intArray, 44));
    }
}
