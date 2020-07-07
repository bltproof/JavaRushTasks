package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max(16, (int) (collection.size()/.75f) + 1));
        addAll(collection);
    }

    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}