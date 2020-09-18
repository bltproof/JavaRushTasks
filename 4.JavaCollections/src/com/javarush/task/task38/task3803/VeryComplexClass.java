package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        class A {

        }

        A a = (A) new Object();

    }

    public void methodThrowsNullPointerException() {
        String str = null;
        str.substring(0,1);
    }

    public static void main(String[] args) {

    }
}
