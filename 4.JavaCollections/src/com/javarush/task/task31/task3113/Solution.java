package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {

    private static int files = 0;
    private static int folders = 0;
    private static long totalFilesSize = 0;

    public static void main(String[] args) throws IOException {

        Path path;

        try (Scanner scanner = new Scanner(System.in)) {
            path = Paths.get(scanner.nextLine());
        }

        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
            return;
        }


        walkFolders(path);

//        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
//            @Override
//            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//                folders++;
//                return FileVisitResult.CONTINUE;
//            }
//
//            @Override
//            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                files++;
//                totalFilesSize += Files.size(file);
//                return FileVisitResult.CONTINUE;
//            }
//        });

        System.out.println("Всего папок - " + folders);
        System.out.println("Всего файлов - " + files);
        System.out.println("Общий размер - " + totalFilesSize);

    }

    private static void walkFolders(Path path) throws IOException {

        Files.list(path).forEach(p -> {
            if (Files.isDirectory(p)) {
                folders++;
                try {
                    walkFolders(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Files.isRegularFile(p)) {
                files++;
                try {
                    totalFilesSize += Files.size(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}