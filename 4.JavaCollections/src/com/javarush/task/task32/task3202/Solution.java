package com.javarush.task.task32.task3202;

import java.io.*;
import java.util.stream.Collectors;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/PROJECTS/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task32/task3202/file.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String s = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            StringWriter writer = new StringWriter();

            /*String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }*/

            writer.write(s);
            writer.close();

            return writer;

        } catch (NullPointerException ex) {
            return new StringWriter();
        }
    }
}