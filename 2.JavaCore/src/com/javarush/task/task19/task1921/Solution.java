package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String name = line.replaceAll("[0-9]", "").trim();
                String date = line.replaceAll("[^0-9 ]", "").trim();
                SimpleDateFormat birthDate = new SimpleDateFormat("dd MM yyy");

                PEOPLE.add(new Person(name, birthDate.parse(date)));
            }
        }
    }
}
