package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
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

        Date start = new Date();
        Set<Long> idSet = getIds(shortener, strings);
        Date end = new Date();
        Helper.printMessage("'getIds' time: " + (end.getTime() - start.getTime()) + "ms");


        Date start2 = new Date();
        Set<String> stringSet = getStrings(shortener, idSet);
        Date end2 = new Date();
        Helper.printMessage("'getStrings' time: " + (end2.getTime() - start2.getTime()) + "ms");

        if (strings.containsAll(stringSet)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10_000L);
        testStrategy(new OurHashMapStorageStrategy(), 10_000L);
        testStrategy(new OurHashBiMapStorageStrategy(), 10_000L);
        testStrategy(new FileStorageStrategy(), 100L);
        testStrategy(new HashBiMapStorageStrategy(), 100L);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000L);
    }
}