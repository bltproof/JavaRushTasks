package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        /*ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < abc.length(); i++) {
            alphabet.add(abc.charAt(i));
        }*/

        // ввод строк
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        reader.close();

        // напишите тут ваш код
        String stringsUnited; // переменная для слияния строк
        StringBuilder sb = new StringBuilder(list.size()); // используем StringBuilder для экономии памяти т.к. используя String для слияния ее расходуется много

        for (int i = 0; i < list.size(); i++) { // склеиваем все строки(слова) из list в переменную StringBuilder
            sb.append(list.get(i));
        }
        stringsUnited = sb.toString(); // присваиваем значение sb(одна большая строка) переменной stringsUnited

        for (int i = 0; i < abc.length(); i++) { // внешний цикл берет первую букву алфавита и сравнивает с каждой буквой склеенной строки по порядку во внутреннем
            int count = 0;                          // счетчик
            for (int j = 0; j < stringsUnited.length(); j++) {
                if (abc.charAt(i) == stringsUnited.charAt(j)) { // сравнение буквы из внешнего цикла с буквой из внутреннего
                    count++;             // если сравнение истинно - счетчик увеличивается на 1, если нет, то в тело условия не проникаем и счетчик остается в нуле
                }
            }

            System.out.println(abc.charAt(i) + " " + count); // выводим в консоль сравниваемую букву по порядку из алфавита + значение счетчика
        }

        // решение, найденное в комментариях участников на странице задачи (гениально блять)
        /*for (Character x : alphabet) {
            int count = 0;
            for (String s : list) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i)==x) {
                        count++;
                    }
                }
            }
            System.out.println(x + " " + count);
        }*/
    }

}
