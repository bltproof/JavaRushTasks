package com.javarush.task.task22.task2209;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
Составить цепочку слов
*/
public class Example {
    public static void main(String[] args) throws IOException {
        String fileName = new Scanner(System.in).nextLine();

        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line != null) {
                    String[] ww = line.split("\\s+");

                    words.addAll(Arrays.asList(ww));
                }
            }
        }

        StringBuilder result = getLine(words.toArray(new String[0]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null) {
            return new StringBuilder();
        }

        List<String> result = new ArrayList<>();
        List<String> shuffled = Arrays.asList(words);
        Collections.shuffle(shuffled);
        fill(shuffled, result);

        return new StringBuilder(String.join(" ", result));
    }

    private static boolean fill(List<String> source, List<String> target) {
        if (source.isEmpty()) {
            return true;
        }

        for (String word : source) {
            if (target.isEmpty()) {
                if (process(new ArrayList<>(source), target, word)) {
                    return true;
                }
            } else {
                String lastWord = target.get(target.size() - 1);
                if (lastWord.toLowerCase().charAt(lastWord.length() - 1) == word.toLowerCase().charAt(0)) {
                    if (process(new ArrayList<>(source), target, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean process(List<String> source, List<String> target, String word) {
        source.remove(word);

        List<String> target2 = new ArrayList<>(target);
        target2.add(word);

        if (fill(source, target2)) {
            target.clear();
            target.addAll(target2);
            return true;
        }
        return false;
    }
}
//муд доМ мандарин Нет трам март труД
//муд доМ март трам мандарин Нет труД
//март трам мандарин Нет труД доМ муд
//март трам муд доМ мандарин Нет труД
//мандарин Нет трам муд доМ март труД
//мандарин Нет труД доМ март трам муд
