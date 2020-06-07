package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
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
        int lengthOverall = 0;
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return sb;
        Random random = new Random();
        sb.append(words[random.nextInt(words.length)]);

        for (String w : words) {
            if (sb.toString().toLowerCase().endsWith(String.valueOf(w.toLowerCase().charAt(0))) && !sb.toString().contains(w)) {
                sb.append(" ").append(w);
                lengthOverall++;
            }

            for (String w2 : words) {
                if (w2.toLowerCase().startsWith(sb.substring(sb.length() - 1).toLowerCase()) && !sb.toString().contains(w2)) {
                    sb.append(" ").append(w2);
                    lengthOverall++;
                    break;
                }
            }
            lengthOverall += w.length();

        }
        if (sb.length() != lengthOverall) {
            return getLine(words);
        }
        return sb;
//        return new StringBuilder(sb.toString().replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2"));
    }
}