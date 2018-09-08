package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(
                "/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1904/file.txt"));
        PersonScanner personScanner = new PersonScannerAdapter(scanner);
        Person ivan = personScanner.read();
        Person petr = personScanner.read();
        System.out.println(ivan.toString());
        System.out.println(petr.toString());
        personScanner.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Date birthDay = null;
            String[] sArr = fileScanner.nextLine().split(" ");
            try {
                birthDay = new SimpleDateFormat("dd MM yyyy")
                        .parse(String.format("%s %s %s", sArr[3], sArr[4], sArr[5]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(sArr[1], sArr[2], sArr[0], birthDay);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
