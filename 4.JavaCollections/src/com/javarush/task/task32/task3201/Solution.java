package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        int number = Integer.parseInt(args[1]);
        File file = new File("/PROJECTS/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task32/task3201/file.txt");

        RandomAccessFile rand = new RandomAccessFile(file, "rw");

        if (rand.length()<number) rand.seek(rand.length()); else rand.seek(number);
        rand.write(args[2].getBytes());
    }
}