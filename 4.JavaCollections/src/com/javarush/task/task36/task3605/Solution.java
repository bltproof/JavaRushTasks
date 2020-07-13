package com.javarush.task.task36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String str = String.join("", Files.readAllLines(Paths.get(args[0])));

        Set<Character> treeSet = new TreeSet<>();

        for (Character ch : str.toLowerCase().toCharArray()) {
            treeSet.add(ch);
        }

        treeSet.stream()
                .filter(Character::isLetter)
                .limit(5)
                .forEach(System.out::print);
    }
}