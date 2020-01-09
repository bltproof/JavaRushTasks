package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream sOut = System.out;

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);
            testString.printSomething();

            String[] strings = baos.toString().split("\n");
            System.setOut(sOut);
            int count=0;

            for (String string : strings) {
                System.out.println(string);
                count++;
                if ((count % 2 == 0)) System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
