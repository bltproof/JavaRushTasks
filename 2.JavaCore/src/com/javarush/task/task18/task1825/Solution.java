package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> filesTreeSet = new TreeSet<>((o1, o2) -> {
            int a = Integer.parseInt(o1.split("part")[1]);
            int b = Integer.parseInt(o2.split("part")[1]);
            return a - b;
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
                int count = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, count);
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader Reader;
        BufferedWriter writer;
        Set<String> set = new TreeSet<>();
        String s = "";
        while (!(s = br.readLine()).equals("end")) {
            set.add(s);
        }
        for (String i : set){
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(i.substring(0, i.indexOf (".part" )))));
            Reader = new BufferedReader(new InputStreamReader(new FileInputStream(i)));
            while (Reader.ready()){
                writer.write(Reader.readLine());
            }
            Reader.close();
            writer.close();
        }
    }
}*/
