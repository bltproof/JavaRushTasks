package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person;
        Person person2;
        switch (args[0]){
            case "-c" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        String name = args[i];
                        Sex sex = args[i + 1].equals("м") ? Sex.MALE : Sex.FEMALE;
                        Date strDate = sdf.parse(args[i + 2]);
                        if (sex == Sex.MALE) person = Person.createMale(name, strDate);
                        else  person = Person.createFemale(name, strDate);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;
            case "-u" :
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=4){
                        allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(sdf.parse(args[i + 3]));
                        allPeople.get(Integer.parseInt(args[i])).setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                    }
                }
                break;
            case "-d" :
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++){
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                    }
                }
                break;
            case "-i" :
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++){
                        String sx = allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE)? "м": "ж";
                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " + sx + " " + sdf2.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()) );
                    }
                }
                break;
        }
    }
}

/*
public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c": synchronized (allPeople) {create(args);} break;
            case "-u": synchronized (allPeople) {update(args);} break;
            case "-d": synchronized (allPeople) {delete(args);} break;
            case "-i": synchronized (allPeople) {display(args);} break;
        }
    }

    public static void create(String[] args) throws ParseException {

            for (int i = 1; i < args.length;) {
                String name = args[i];
                i += 2;
                Date strDate = sdf.parse(args[i]);
                String sex = args[i - 1];
                if ("м".equals(sex)) {
                    Person person = Person.createMale(name, strDate);
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                } else if ("ж".equals(sex)) {
                    Person person = Person.createFemale(name, strDate);
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
                i++;
            }
    }

    public static void update(String[] args) throws ParseException {
        for (int i = 1; i < args.length;) {
            int index = Integer.parseInt(args[i]);
            i++;
            String name = args[i];
            i += 2;
            Date strDate = sdf.parse(args[i]);
            String sex = args[i - 1];
            if ("м".equals(sex)) {
                Person person = Person.createMale(name, strDate);
                allPeople.set(index, person);
                System.out.println(allPeople.indexOf(person));
            } else if ("ж".equals(sex)) {
                Person person = Person.createFemale(name, strDate);
                allPeople.set(index, person);
                System.out.println(allPeople.indexOf(person));
            }
            i++;
        }
    }

    public static void delete(String[] args) {
        for (int i = 1; i < args.length; i++) {
            int index = Integer.parseInt(args[i]);
            Person person = allPeople.get(index);
            person.setName(null);
            person.setBirthDay(null);
            person.setSex(null);
        }
    }
    public static void display(String[] args) {
        for (int i = 1; i < args.length; i++) {
            int index = Integer.parseInt(args[i]);
            String name = allPeople.get(index).getName();
            String sex;
            if (allPeople.get(index).getSex().toString().equals("MALE")) {
                sex = "м";
            } else {
                sex = "ж";
            }

            String strDate = sdf2.format(allPeople.get(index).getBirthDay());

            System.out.println(name + " " + sex + " " + strDate);
        }
    }
}
*/
