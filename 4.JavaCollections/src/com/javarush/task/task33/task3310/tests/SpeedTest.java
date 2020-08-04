package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.greaterThan;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long time = System.currentTimeMillis();

        for (String s : strings) {
            ids.add(shortener.getId(s));
        }

        return System.currentTimeMillis() - time;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long time = System.currentTimeMillis();

        for (Long l : ids) {
            strings.add(shortener.getString(l));
        }

        return System.currentTimeMillis() - time;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();

        for (int i = 0; i < 10_000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long time = getTimeToGetIds(shortener1, origStrings, ids);
        long time2 = getTimeToGetIds(shortener2, origStrings, ids2);

        Assert.assertThat(time, greaterThan(time2));

        Set<String> stringsHashMapStorageStrategy = new HashSet<>();
        Set<String> stringsHashBiMapStorageStrategy = new HashSet<>();

        long time3 = getTimeToGetStrings(shortener1, ids, stringsHashMapStorageStrategy);
        long time4 = getTimeToGetStrings(shortener2, ids2, stringsHashBiMapStorageStrategy);

        Assert.assertEquals(time3, time4, 30);

    }
}
