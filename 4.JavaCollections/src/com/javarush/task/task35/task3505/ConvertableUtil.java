package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable> Map<K, V> convert(List<? extends Convertable<K>> list) {
        Map<K, Convertable<V>> map = new HashMap<>();

        for (Convertable<K> k : list) {
            map.put(k.getKey(), (V) k);
        }

        Map result = new HashMap(map);
        return result;
    }
}