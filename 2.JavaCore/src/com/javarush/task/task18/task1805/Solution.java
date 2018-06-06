package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        FileInputStream fileInputStream = null;

        try {
            fileName = new Scanner(System.in).nextLine();

            try {
                fileInputStream = new FileInputStream(fileName);

                Set<Byte> bytes = new TreeSet<>();

                try {
                    //заносим в массив
                    while (fileInputStream.available() > 0) {

                        bytes.add((byte)fileInputStream.read());
                    }

                    //Сначала я пытался сделать через ArrayLis, потом сделал через TreeSet по рекомендации форума

                    //Сортируем массив
                    /*Collections.sort(bytes);*/

                    //Выводим уникальные элементы
                    /*for (int i = 0; i < bytes.size() - 1; ++i) {
                        *//*System.out.print(bytes.get(i));
                        System.out.print(" ");*//*
                        if (bytes.get(i) != bytes.get(i + 1)) {
                            System.out.print(bytes.get(i));
                            System.out.print(" ");
                        }
                    }*/
                    for (byte b : bytes) {
                        System.out.print(b + " ");
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());

        }
    }
}
