package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Putin", 100_000);
        map.put("Medvedev", 78_000);
        map.put("Shuvalov", 70_000);
        map.put("Zyuganov", 400);
        map.put("Gref", 250);
        map.put("Vivaldi", 20_000);
        map.put("Shoygu", 10_000);
        map.put("Vasilieva", 3_000);
        map.put("Soloviev", 1_000);
        map.put("Zhirinovski", 499);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        //HashMap<String, Integer> mapCopy = new HashMap<>(map);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}