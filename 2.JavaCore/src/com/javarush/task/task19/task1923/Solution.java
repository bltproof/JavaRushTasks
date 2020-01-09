package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        while (bufferedReader.ready()){
            String[] line = bufferedReader.readLine().split(" ");
            for (String s : line) {
                if (s.matches(".*[0-9]+.*")){
                    bufferedWriter.write(s + " ");
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
