package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args.length < 2) return;

        if ("-c".equals(args[0]) && "м".equals(args[2])) {
            Date strDate = sdf.parse(args[3]);
            Person person = Person.createMale(args[1], strDate);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if ("-c".equals(args[0]) && args[2].equals("ж")) {
            Date strDate = sdf.parse(args[3]);
            Person person = Person.createFemale(args[1], strDate);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
        if ("-u".equals(args[0])) {
            Date strDate = sdf.parse(args[4]);
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            person.setBirthDay(strDate);

            if (args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else if (args[3].equals("ж")) {
                person.setSex(Sex.FEMALE);
            }
        }

        if ("-d".equals(args[0])) {
            Person per = allPeople.get(Integer.parseInt(args[1]));
            per.setName(null);
            per.setSex(null);
            per.setBirthDay(null);
        }

        if ("-i".equals(args[0])) {
            Person person = allPeople.get(Integer.parseInt(args[1]));

            String sex = "";
            if (person.getSex().equals(Sex.MALE)) {
                sex = "м";
            } else if (person.getSex().equals(Sex.FEMALE)) {
                sex = "ж";
            }

            sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

            String bd = sdf.format(person.getBirthDay());

            System.out.println(person.getName() + " " + sex + " " + bd);
        }
    }
}
