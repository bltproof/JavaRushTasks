package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
        ArrayList<Woman> women = new ArrayList<Woman>();
        women.add(new Woman(18, 0, 45, 170, "Ann"));
        women.add(new Woman(21, 1, 57, 168, "Iren"));
        women.add(new Woman(5, 0, 20, 110, "Angelina"));

        CustomizedComparator<Woman> compareBy = new CustomizedComparator<Woman>() {

            public int compare(Woman o1, Woman o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Collections.sort(women, compareBy);

        for (Woman w : women) {
            System.out.println(w);
        }
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... varargs) {
            this.comparators = varargs;
        }

        @Override
        public int compare(T o1, T o2) {
            int equals = 0;

            for (Comparator<T> comparator : comparators) {
                equals = comparator.compare(o1, o2);
                if (equals != 0) break;
            }
            return equals;
        }
    }

    public static class Woman {
        public int age;
        public int childrenCount;
        public int weight;
        public int height;
        public String name;

        public Woman(int age, int childrenCount, int weight, int height, String name) {
            this.age = age;
            this.childrenCount = childrenCount;
            this.weight = weight;
            this.height = height;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Woman{" +
                    "age=" + age +
                    ", childrenCount=" + childrenCount +
                    ", weight=" + weight +
                    ", height=" + height +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}