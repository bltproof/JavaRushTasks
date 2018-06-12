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
        String fileToWrite = "";
        FileOutputStream fileOutputStream = null;
        for (String setElement : filesTreeSet) {
            if (!setElement.contains(fileToWrite) || fileToWrite.equals("")) {
                fileToWrite = setElement.substring(0, setElement.lastIndexOf('.'));
                fileOutputStream = new FileOutputStream(fileToWrite);
            }
            FileInputStream fileInputStream = new FileInputStream(setElement);
            byte[] buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                int readed = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, readed);
            }
            fileInputStream.close();
        }
        if (fileOutputStream != null) fileOutputStream.close();
    }
}
