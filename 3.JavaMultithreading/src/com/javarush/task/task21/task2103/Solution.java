package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        return c;
    }

    public static void main(String[] args) {
        boolean[] bb = {true, false};
        for (boolean b1 : bb) {
            for (boolean b2 : bb) {
                for (boolean b3 : bb) {
                    for (boolean b4 : bb) {

                        System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + " = " + calculate(b1, b2, b3, b4));
                    }
                }
            }
        }
    }
}