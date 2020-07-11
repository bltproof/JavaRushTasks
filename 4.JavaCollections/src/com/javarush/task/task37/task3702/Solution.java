package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.MaleFactory;

public class Solution {
    public static void main(String[] args) {
        MaleFactory mf = new MaleFactory();

        System.out.println(mf.getPerson(99));
        System.out.println(mf.getPerson(4));
        System.out.println(mf.getPerson(15));
    }
}