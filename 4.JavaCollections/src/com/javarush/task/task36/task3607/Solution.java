package com.javarush.task.task36.task3607;


import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Queue;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 10 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();

        for (Class clazz : classes) {
            if (Queue.class.isAssignableFrom(clazz)) {
                Constructor constructor = null;
                try {
                    constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return clazz;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}