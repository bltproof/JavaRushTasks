package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> keySet = new HashSet<>();
        strings.forEach(s -> keySet.add(shortener.getId(s)));

        return keySet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> valueSet = new HashSet<>();
        keys.forEach(l -> valueSet.add(shortener.getString(l)));

        return valueSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        long start = System.currentTimeMillis();
        Set<Long> idSet = getIds(shortener, strings);
        long end = System.currentTimeMillis() - start;
        System.out.println("getIds time: " + end + "ms");


        long start2 = System.currentTimeMillis();
        Set<String> stringSet = getStrings(shortener, idSet);
        long end2 = System.currentTimeMillis() - start2;
        System.out.println("getStrings time: " + end2 + "ms");

        if (strings.containsAll(stringSet)) System.out.println("Тест пройден.");
        else System.out.println("Тест не пройден.");
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10_000L);
    }
}