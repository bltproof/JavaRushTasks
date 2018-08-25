package com.javarush.task.task19;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        //Создаем объект File
        File file = new File("D:/1.txt");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (InputStream input = new FileInputStream(file)) {
            //len - количество прочитанных в буфер байтов
            int len;
            //Читаем из входного потока до тех пор, пока не встретим -1
            byte[] bytes = new byte[1024];
            while ((len = input.read(bytes)) != -1) {
                //Записываем в поток вывода len байтов, начиная с начала буфера bytes
                output.write(bytes, 0, len);
            }
        }

        //Массив байтов в памяти, которые мы прочитали из файла
        byte[] bytes = output.toByteArray();
        //Создаем строку из массива байтов
        String string = new String(bytes, "UTF-8");
        //Распечатываем строку в консоль
        System.out.println(string);
    }
}
