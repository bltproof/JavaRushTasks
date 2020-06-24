package com.javarush.task.task26.task2601;

import java.util.*;
import java.util.function.Function;

/*
Почитать в инете про медиану выборки
*/

//13, 8, 15, 5, 17
//13, 15, 17, 8, 5
public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{13, 8, 15, 5, 17};
        arr = sort(arr);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }

    public static Integer medianSearch(Integer[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 1) return array[array.length / 2];
        return (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        int median = medianSearch(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] - median;
            System.out.print(array[i] + " ");
        }
        System.out.println();

        list.sort(Comparator.comparing(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return Math.abs(integer - median);
            }
        }));

        return list.toArray(new Integer[0]);
    }
}
