package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);

        int median = array.length % 2 == 1 ? array[array.length / 2] : (array[array.length / 2] + array[array.length / 2 - 1]) / 2;

        Arrays.sort(array, Comparator.comparingInt(o -> Math.abs(o - median)));

        return array;
    }
}