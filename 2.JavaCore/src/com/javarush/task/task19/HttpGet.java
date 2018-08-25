package com.javarush.task.task19;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {
    public static void main(String[] args) throws IOException {
        //Конструируем ссылку на сайт
        URL url = new URL("https://ya.ru/");

        //Открываем соединение до сервера
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //Указываем, что мы собираемся читать данные с сервера
        connection.setDoInput(true);
        //Указываем, что мы собираемся послать GET-запрос
        connection.setRequestMethod("GET");

        //Отправляем запрос на сервер и читаем код состояния.
        int responseCode = connection.getResponseCode();
        //Если сервер вернул код 200 - OK - значит запрос корректный и сервер, обработав его, вернул данные
        if (responseCode == HttpURLConnection.HTTP_OK) {
            //Буфер в памяти, куда будем сохранять данные с сервера
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            //открываем поток ввода и читаем его, копируя данные в output
            try (InputStream input = connection.getInputStream()) {
                //Переносим данные из input в output порциями по 100 байт
                byte[] bytes = new byte[100];
                int read;
                while ((read = input.read(bytes)) != -1) {
                    output.write(bytes, 0, read);
                }
            }

            //Все байты, прочитанные с сервера конвертируем в строку и распечатываем в консоль
            String response = output.toString("UTF-8");
            System.out.println(response);
        }
    }
}
