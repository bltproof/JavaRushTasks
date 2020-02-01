package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            try (InputStream inputStream = new FileInputStream(reader.readLine())) {
                load(inputStream);
            }

            try (OutputStream outputStream = new FileOutputStream(reader.readLine())) {
                save(outputStream);
            }
        }
    }

    public void save(OutputStream outputStream) throws IOException {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();

        if (!properties.isEmpty()) {
            p.putAll(properties);
        }

        p.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);

        for (String str : p.stringPropertyNames()) {
            properties.put(str, p.getProperty(str));
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().fillInPropertiesMap();
    }
}