package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //add your code here
        String url = reader.readLine();
        reader.close();

        String line = url.substring(url.indexOf("?") + 1);

        String[] array = line.split("&");

        for (String a : array) {
            System.out.print(a.split("=")[0] + " ");
        }

        System.out.println();

        for (String a : array) {
            try {
                if (a.split("=")[0].equals("obj")) {
                    alert(Double.parseDouble(a.split("=")[1]));
                }
            } catch (Exception e) {
                alert(a.split("=")[1]);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

