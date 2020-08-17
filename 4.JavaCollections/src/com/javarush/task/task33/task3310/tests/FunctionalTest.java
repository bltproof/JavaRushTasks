package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String one = "one";
        String two = "two";
        String three = "one";

        Long idOne = shortener.getId(one);
        Long idTwo = shortener.getId(two);
        Long idThree = shortener.getId(three);

        Assert.assertNotEquals(idTwo, idOne);
        Assert.assertNotEquals(idTwo, idThree);

        Assert.assertEquals(idOne, idThree);

        String s = shortener.getString(idOne);
        String s2 = shortener.getString(idTwo);
        String s3 = shortener.getString(idThree);

        Assert.assertEquals(one, s);
        Assert.assertEquals(two, s2);
        Assert.assertEquals(three, s3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        StorageStrategy hashMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);

        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        StorageStrategy ourHashMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);

        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        StorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);

        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        StorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);

        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        StorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);

        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        StorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);

        testStorage(shortener);
    }
}