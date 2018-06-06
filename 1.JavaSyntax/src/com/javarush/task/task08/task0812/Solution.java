package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            arrayList.add(scanner.nextInt());
        }

        int max = 1;
        int max2 = 1;

        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i).equals(arrayList.get(i + 1))) {
                max++;
                if (max > max2) {
                    max2 = max;
                }
            }
            else {
                max = 1;
            }
        }
        System.out.println(max2);
    }
}