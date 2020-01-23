package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null, new File("/PROJECTS/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User fransis = new User();
            fransis.setFirstName("Fransis Ford");
            fransis.setLastName("Coppola");
            fransis.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("11.12.1948"));
            fransis.setCountry(User.Country.OTHER);
            fransis.setMale(true);
            javaRush.users.add(fransis);

            User puten = new User();
            puten.setFirstName("Vova");
            puten.setLastName("Puten");
            puten.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("19.09.1952"));
            puten.setCountry(User.Country.RUSSIA);
            puten.setMale(false);
            javaRush.users.add(puten);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            try (PrintWriter writer = new PrintWriter(outputStream)) {
                if (!users.isEmpty()) {
                    for (User user : users) {
                        writer.println(user.getFirstName());
                        writer.println(user.getLastName());
                        writer.println(user.getBirthDate().getTime());
                        writer.println(user.getCountry().getDisplayName());
                        writer.println(user.isMale());
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                while (reader.ready()) {
                    User fransis = new User();
                    fransis.setFirstName(reader.readLine());
                    fransis.setLastName(reader.readLine());
                    fransis.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    fransis.setCountry(User.Country.valueOf(reader.readLine().toUpperCase()));
                    fransis.setMale(reader.readLine().equals("true"));
                    users.add(fransis);

                    User puten = new User();
                    puten.setFirstName(reader.readLine());
                    puten.setLastName(reader.readLine());
                    puten.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    puten.setCountry(User.Country.valueOf(reader.readLine().toUpperCase()));
                    puten.setMale(reader.readLine().equals("true"));
                    users.add(puten);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
