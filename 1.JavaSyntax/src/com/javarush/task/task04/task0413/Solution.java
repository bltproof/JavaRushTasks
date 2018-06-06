package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        if (num > 7 || num < 1) System.out.println("такого дня недели не существует");
        if (num == 1) System.out.println("понедельник");
        if (num == 2) System.out.println("вторник");
        if (num == 3) System.out.println("среда");
        if (num == 4) System.out.println("четверг");
        if (num == 5) System.out.println("пятница");
        if (num == 6) System.out.println("суббота");
        if (num == 7) System.out.println("воскресенье");

        reader.close();
    }
}