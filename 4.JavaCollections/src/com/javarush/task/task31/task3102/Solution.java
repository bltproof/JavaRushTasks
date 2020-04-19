package com.javarush.task.task31.task3102;

import java.io.File;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) {

        Queue<File> queue = new ArrayDeque<>();
        List<String> list = new ArrayList<>();

        queue.add(new File(root));

        while (!queue.isEmpty()) {
            File file = queue.poll();

            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    if (f.isFile()) {
                        list.add(f.getAbsolutePath());
                    } else {
                        queue.add(f);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = getFileTree("/PROJECTS/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3102");

        for (String s : Objects.requireNonNull(list)) {
            System.out.println(s);
        }
    }
}
