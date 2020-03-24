package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
//        System.out.println(new Solution(4));
        Solution savedObject = new Solution(4);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/PROJECTS/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/file.txt"))) {

            objectOutputStream.writeObject(savedObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/PROJECTS/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/file.txt"))) {

            Solution loadedObject = (Solution) objectInputStream.readObject();

            System.out.println(loadedObject.string.equals(savedObject.string));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
