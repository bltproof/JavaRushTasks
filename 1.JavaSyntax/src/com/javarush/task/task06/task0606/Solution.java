package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = null;
        int num;
        String line;
        char[] chars;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            chars = line.toCharArray();
            for (char element : chars){
                num = Integer.parseInt(String.valueOf(element));
                if (num % 2 == 0) {
                    even++;
                } else odd++;
                reader.close();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println("Even: "+even+" Odd: "+odd);
    }
}