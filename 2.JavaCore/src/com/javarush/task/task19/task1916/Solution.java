package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()))) {

            while (true) {
                if (fileReader.ready()) {
                    if (fileReader2.ready()) {
                        fileReader.mark(500);
                        fileReader2.mark(500);
                        String line = fileReader.readLine();
                        String line2 = fileReader2.readLine();
                        if (line2.equals(line)) {
                            lines.add(new LineItem(Type.SAME, line));
                        } else {
                            if (line.equals(fileReader2.readLine())) {
                                fileReader.reset();
                                fileReader2.reset();
                                lines.add(new LineItem(Type.ADDED, fileReader2.readLine()));
                            } else {
                                lines.add(new LineItem(Type.REMOVED, line));
                                fileReader2.reset();
                            }
                        }
                    } else {
                        lines.add(new LineItem(Type.REMOVED, fileReader.readLine()));
                    }
                } else {
                    if (fileReader2.ready()) {
                        lines.add(new LineItem(Type.ADDED, fileReader2.readLine()));
                    }
                    else break;
                }
            }
            for (LineItem item : lines) System.out.println(item.type + " " + item.line);

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
