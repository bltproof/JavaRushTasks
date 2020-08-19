package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private Retriever originalRetriever;
    private LRUCache<Long, Object> lruCache;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
        this.lruCache = new LRUCache<>(10);
    }

    @Override
    public Object retrieve(long id) {
        Object cache = lruCache.find(id);

        if (cache == null) {
            cache = originalRetriever.retrieve(id);
            lruCache.set(id, cache);
        }

        return lruCache.find(id);
    }
}