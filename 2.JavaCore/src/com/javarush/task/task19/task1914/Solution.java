package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(console);

        String[] s = result.split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);

        if(s[1].equals("+")) {
            System.out.println(result + (a + b));
        }
        else if(s[1].equals("-")) {
            System.out.println(result + (a - b));
        }

        else if(s[1].equals("*")) {
            System.out.println(result + (a * b));
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

