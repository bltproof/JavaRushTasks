package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(14, 7);

    }

    public static void closeToTen(int a, int b) {
        //::CODE:
        //System.out.println(Math.min(abs(a - 10), abs(b - 10)));

        if (abs(a-10) < abs(b - 10)) {
            System.out.println(a);
        }
        else
            System.out.println(b);


    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}