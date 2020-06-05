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

            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            while (reader.ready()) {
                list.addAll(Arrays.asList(reader.readLine().split("\\s+")));
            }

            for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
                String s = i.next();
                i.remove();

                for (Iterator<String> i2 = list.iterator(); i2.hasNext(); ) {
                    String s2 = i2.next();
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
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
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