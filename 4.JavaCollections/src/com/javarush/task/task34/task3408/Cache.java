package com.javarush.task.task34.task3408;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V obj = cache.get(key);

        if (obj == null) {
            String fieldName = "";

            for (Field f : clazz.getDeclaredFields()) {
                fieldName = f.getName();
            }
            Field f = clazz.getDeclaredField(fieldName);
            f.setAccessible(true);
            V newObj = clazz.newInstance();
            f.set(newObj, key);
            cache.put(key, newObj);

            return newObj;
        }

        return obj;
    }

    public boolean put(V obj) throws InvocationTargetException, IllegalAccessException {
        //TODO add your code here
        K key = null;

        for (Method m : obj.getClass().getDeclaredMethods()) {
            if (m.getName().contains("getKey")) {
                m.setAccessible(true);
                key = (K) m.invoke(obj);
            }
        }
        cache.put(key, obj);

        return key != null;
    }

    public int size() {
        return cache.size();
    }
}
