package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a;
        int b;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        }
        System.out.println(a > 0 ? (b > 0 ? 1 : 4) : (b > 0 ? 2 : 3));
    }
}
