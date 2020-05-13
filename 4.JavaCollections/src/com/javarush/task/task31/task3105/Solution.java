package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Path path = Files.createTempFile(Paths.get(args[0]).getParent(), "temp_", ".zip");

        ZipEntry entry;

        try (ZipInputStream zIn = new ZipInputStream(new FileInputStream(args[1]));
             ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(path.toFile()))) {


            zOut.putNextEntry(new ZipEntry("test/new/" + Paths.get(args[0]).getFileName()));

            Files.copy(Paths.get(args[0]), zOut);
            Files.move(path, Paths.get(args[1]), StandardCopyOption.REPLACE_EXISTING);

            while ((entry = zIn.getNextEntry()) != null) {

                if (!entry.isDirectory()) {
                    zOut.putNextEntry(new ZipEntry(entry.getName()));

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    byte[] buffer = new byte[1024];

                    int length;

                    while ((length = zIn.read(buffer)) != -1) {
                        baos.write(buffer, 0, length);
                    }

                    baos.writeTo(zOut);
                }
            }
        }

        /*String newFileName = Paths.get(args[0]).getFileName().toString();
        String newPathInArchive = "new/" + newFileName;
        ZipEntry entry;
        Map<String, ByteArrayOutputStream> filesInArchive = new HashMap<>();

        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
        while ((entry = zipIn.getNextEntry()) != null) {
            if (entry.getName().endsWith(newFileName)) {
                newPathInArchive = entry.getName();
            } else {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int length = 0;
                byte[] buffer = new byte[1024];
                while ((length = zipIn.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }
//                baos.write(zipIn.readAllBytes());
                filesInArchive.put(entry.getName(), baos);
            }
        }
        zipIn.close();

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]));
        zipOut.putNextEntry(new ZipEntry(newPathInArchive));
        Files.copy(Paths.get(args[0]), zipOut);
        for (Map.Entry<String, ByteArrayOutputStream> pair : filesInArchive.entrySet()) {
            zipOut.putNextEntry(new ZipEntry(pair.getKey()));
            pair.getValue().writeTo(zipOut);
        }
        zipOut.close();*/
    }
}
