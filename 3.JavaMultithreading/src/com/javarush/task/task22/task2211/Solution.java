package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        OutputStream outputStream = new FileOutputStream(new File(args[1]));

        byte[] buffer = Files.readAllBytes(Paths.get(args[0]));

        String s = new String(buffer, windows1251);

        buffer = s.getBytes(utf8);
        outputStream.write(buffer);
        outputStream.close();
    }
}