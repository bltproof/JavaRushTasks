package com.javarush.task.task34.task3408;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V object = cache.get(key);

        if (object == null) {
            V newObject = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, newObject);

            return newObject;
        }

        return object;
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method m = obj.getClass().getDeclaredMethod("getKey");
            m.setAccessible(true);
            K key = (K) m.invoke(obj);
            cache.put(key, obj);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}