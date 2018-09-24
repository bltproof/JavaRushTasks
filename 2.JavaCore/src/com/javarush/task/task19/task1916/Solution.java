package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()))) {

            List<String> file1 = new ArrayList<>();
            List<String> file2 = new ArrayList<>();

            while (fileReader.ready()) {
                file1.add(fileReader.readLine());
            }
            while (fileReader2.ready()) {
                file2.add(fileReader2.readLine());
            }

            for (String s : file1) {
                for (String s2 : file2) {

                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
