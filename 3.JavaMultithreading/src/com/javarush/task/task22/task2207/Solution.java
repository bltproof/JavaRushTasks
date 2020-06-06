package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())))) {

            List<String> words = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            while (reader.ready()) {
                words.addAll(Arrays.asList(reader.readLine().split("\\s+")));
            }

            for (Iterator<String> i = words.iterator(); i.hasNext(); ) {
                String s = i.next();
                i.remove();

                for (String s2 : words) {
                    sb.append(s2);

                    if (sb.reverse().toString().equals(s)) {
                        Pair pair = new Pair();
                        pair.first = s;
                        pair.second = s2;

                        if (!result.contains(pair)) {
                            result.add(pair);
                        }
                    }
                    sb.delete(0, sb.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Вариант 2
        /*
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        Collection<String> words = new HashSet<>();
        try(Scanner s = new Scanner(new File(fileName))) {
            while (s.hasNext()) {
                String line = s.nextLine();
                if(line != null) {
                    String[] ww = line.split("\\s+");
                    words.addAll(Arrays.asList(ww));
                }
            }
        }
        scanner.close();

        for(String word: words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            if(words.contains(reverseWord)) {
                Pair pair = new Pair();
                pair.first = word;
                pair.second = reverseWord;

                Pair pair2 = new Pair();
                pair2.first = reverseWord;
                pair2.second = word;

                if (!result.contains(pair) && !result.contains(pair2)) {
                    result.add(pair);
                }
            }
        }
        */
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}