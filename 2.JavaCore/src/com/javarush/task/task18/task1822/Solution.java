package com.javarush.task.task18.task1822;

import java.io.*;

/*
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bFileReader = new BufferedReader(new FileReader(reader.readLine()))){

            while (bFileReader.ready()) {
                String string = bFileReader.readLine();
                if (string.startsWith(args[0] + " ")){
                    System.out.println(string);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
