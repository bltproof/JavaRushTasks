package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        String fileName3 = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName3);

        // 1 вариант
        /*if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available() / 2]; //Здесь меньше байт
            byte[] buffer2 = new byte[fileInputStream.available() - (fileInputStream.available() / 2)]; //Здесь больше байт

            fileInputStream.read(buffer2);
            fileOutputStream.write(buffer2);

            fileInputStream.read(buffer);
            fileOutputStream2.write(buffer);
        }*/

        // 2 вариант
        /*int count = fileInputStream.available();
        int evenCount = count / 2; //здесь меньше байт
        int oddCount = count - evenCount; //здесь больше байт

        if (fileInputStream.available() > 0 && (fileInputStream.available() % 2 != 0)) {

            byte[] buffer = new byte[oddCount];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);

            buffer = new byte[evenCount];
            fileInputStream.read(buffer);
            fileOutputStream2.write(buffer);

        } else if (fileInputStream.available() > 0) {

            byte[] buffer = new byte[evenCount];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);

            buffer = new byte[evenCount];
            fileInputStream.read(buffer);
            fileOutputStream2.write(buffer);
        }*/

        // 3 вариант
        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer, 0, (buffer.length + 1) / 2);
            fileOutputStream2.write(buffer, (buffer.length + 1) / 2,
                    buffer.length / 2); // 3-й параметр в методе write -  это количество символов, а не номер последнего символа
        }

        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream2.close();
    }
}
// Итог: Все 3 варианта рабочие. Валидатор не принимал решение из-за того, что ввод имен файлов из консоли я осуществлял сразу
// в аргумент потоков Stream'ов