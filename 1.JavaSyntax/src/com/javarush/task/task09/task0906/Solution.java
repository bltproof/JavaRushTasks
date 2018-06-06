package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[] stk = Thread.currentThread().getStackTrace();
        System.out.println(stk[2].getClassName() + ": " + stk[2].getMethodName() + ": " + s);

    }
}
