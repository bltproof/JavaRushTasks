package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();

        for (Class clazz : classes) {

            if (List.class.isAssignableFrom(clazz) &&
                    Modifier.isPrivate(clazz.getModifiers())
                    && Modifier.isStatic(clazz.getModifiers())) {

                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    List list = (List) constructor.newInstance();
                    list.get(0);

                } catch (IndexOutOfBoundsException e) {
                    return clazz;

                } catch (Exception e) {
                }
            }
        }
        return null;
    }
}