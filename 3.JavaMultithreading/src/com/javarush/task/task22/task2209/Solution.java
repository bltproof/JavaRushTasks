package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        String[] words = null;

        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())))) {

            while (reader.ready()) {
                words = reader.readLine().split("\\s+");
            }

        }

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words == null) return sb;
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        sb.append(wordsList.get(words.length - 1));

        for (String w : wordsList) {
            if (sb.toString().endsWith(String.valueOf(w.toLowerCase().charAt(0))) && !sb.toString().contains(w)) {
                sb.append(w);
            }

            for (String w2 : wordsList) {
                if (w2.startsWith(sb.substring(sb.length() - 1).toUpperCase()) && !sb.toString().contains(w2)) {
                    sb.append(w2);
                }
            }
        }
        String s = sb.toString().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
        return new StringBuilder(s);
    }
}