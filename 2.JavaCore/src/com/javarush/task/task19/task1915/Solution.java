package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine())) {

            PrintStream consolreader = System.out;
            ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArr);
            PrintStream printFile = new PrintStream(fileOutputStream);
            System.setOut(printStream);
            testString.printSomething();
            System.setOut(consolreader);
            String s = byteArr.toString();
            printFile.println(s);
            System.out.println(s);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

