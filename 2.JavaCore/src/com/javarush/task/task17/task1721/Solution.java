package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        try (BufferedReader allLinesReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while ((line = allLinesReader.readLine()) != null) {
                allLines.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedReader forRemoveLinesReader = new BufferedReader(new FileReader(new File(fileName2)))) {
            String line = null;
            while ((line = forRemoveLinesReader.readLine()) != null) {
                forRemoveLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        new Solution().joinData();

    }

    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);

        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
