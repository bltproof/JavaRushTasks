package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader consoleInputReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(consoleInputReader.readLine()))) {

            StringBuilder stringBuilder = new StringBuilder();
            String text;

            while (fileReader.ready()) {
                stringBuilder.append(fileReader.readLine());
            }

            text = stringBuilder.toString();
            String tag = args[0];

            Document document = Jsoup.parse(text, "", Parser.xmlParser());
            Elements elements = document.select(tag);

            for (Element s : elements) {
                System.out.println(s);
            }

        }
    }
}
