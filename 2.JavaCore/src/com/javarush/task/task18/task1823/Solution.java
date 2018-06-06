package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        List<Integer> list = new ArrayList<>();

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

                while (fileInputStream.available() > 0) {
                    list.add(fileInputStream.read());
                }
                int max = list.get(0);
                for (Integer element : list) {
                    if (Collections.frequency(list, element) > Collections.frequency(list, max)) {
                        max = element;
                    }
                    resultMap.put(fileName, max);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
