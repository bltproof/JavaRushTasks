package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> filesTreeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = Integer.parseInt(o1.split("part")[1]);
                int b = Integer.parseInt(o2.split("part")[1]);
                return a - b;
            }
        });
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
            while (!"end".equals(fileName)) {
                filesTreeSet.add(fileName);
                fileName = reader.readLine();
            }
        }
        String fileOut = "";
        FileOutputStream fileOutputStream = null;
        for (String elementSet : filesTreeSet) {
            if ("".equals(fileOut)) {
                fileOut = elementSet.substring(0, elementSet.lastIndexOf('.'));
                fileOutputStream = new FileOutputStream(fileOut);
            }
            try (FileInputStream fileInputStream = new FileInputStream(elementSet)) {
                byte[] buffer = new byte[fileInputStream.available()];
                while (fileInputStream.available() > 0) {
                    int count = fileInputStream.read(buffer);
                    fileOutputStream.write(buffer, 0, count);
                }
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
