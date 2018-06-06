package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("zaur0", "zaur");
        map.put("zaur1", "zaur");
        map.put("zaur2", "zaur");
        map.put("zaur3", "zaur3");
        map.put("zaur4", "zaur4");
        map.put("zaur5", "zaur5");
        map.put("zaur6", "zaur6");
        map.put("zaur7", "zaur7");
        map.put("zaur8", "zaur8");
        map.put("zaur9", "zaur9");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код

        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            for (Map.Entry<String, String> pair2 : copy.entrySet()) {
                if (!pair2.getKey().equals(pair.getKey()) && pair2.getValue().equals(pair.getValue()))
                    removeItemFromMapByValue(map, pair.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
