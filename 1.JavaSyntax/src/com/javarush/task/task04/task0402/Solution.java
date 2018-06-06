package com.javarush.task.task04.task0402;

/* 
Цена яблока
*/
public class Solution {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Apple.addPrice(50);
        Apple apple2 = new Apple();
        Apple.addPrice(100);
        System.out.println("Apples price is " + Apple.applesPrice);
    }

    public static class Apple {
        public static int applesPrice = 0;

        public static void addPrice(int applesPrice) {
            //напишите тут ваш код
            Apple.applesPrice = Apple.applesPrice + applesPrice;
            //Apple.applesPrice += applesPrice;

        }
    }
}
