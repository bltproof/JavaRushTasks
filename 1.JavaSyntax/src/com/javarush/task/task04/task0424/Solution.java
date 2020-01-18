package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a;
        int b;
        int c;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
            c = Integer.parseInt(reader.readLine());
        }

        if (b == c && b != a) {
            System.out.print("1");
        }
        else if (a == c && b != c) {
            System.out.print("2");
        }
        else if (a == b && b != c){
            System.out.print("3");
        }
    }
}
