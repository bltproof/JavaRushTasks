package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        Path downloadDirectory = Paths.get("/Users/Zaurbek/MyDownloads");

        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt",
                downloadDirectory);

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);

        Path tmpFile = Files.createTempFile("temp_", ".tmp");

        Files.copy(url.openStream(), tmpFile, StandardCopyOption.REPLACE_EXISTING);

        if (Files.notExists(downloadDirectory)) {
            Files.createDirectory(downloadDirectory);
        }

        Path downloadFile = downloadDirectory.resolve(Paths.get(url.getPath()).getFileName());

        return Files.move(tmpFile, Files.createFile(downloadFile), StandardCopyOption.REPLACE_EXISTING);

//        Files.move
//                (
//                        tmpFile,
//                        downloadFile,
//                        StandardCopyOption.REPLACE_EXISTING
//                );
//
//        return downloadFile;
    }
}
