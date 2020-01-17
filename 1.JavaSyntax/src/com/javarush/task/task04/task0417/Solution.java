package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int x;
        int y;
        int z;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            x = Integer.parseInt(reader.readLine());
            y = Integer.parseInt(reader.readLine());
            z = Integer.parseInt(reader.readLine());
        }

        if (x == y && y == z) {
            System.out.print(x + " " + y + " " + z);
        }

        else if (x == y) {
            System.out.print(x + " " + y);
        }
        else if (y == z) {
            System.out.print(y + " " + z);
        }
        else if (x == z) {
            System.out.print(x + " " + z);
        }
    }
}