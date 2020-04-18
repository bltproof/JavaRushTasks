package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
Проход по дереву файлов
*/

/*
Проходим рекурсивно по всем папкам, и собираем в ArrayList<File> файлы согласно условию,
затем сортируем через собственный компаратор, затем переименовываем файл и проходим по листу, записывая в него содержимое.
*/


public class Solution {
    public static void main(String[] args) throws Exception {
        File path = new File(args[0]);
        File currentFile = new File(args[1]);

        List<File> files = new ArrayList<>();

        recursiveDirectoryWalk(files, path);

        File renamedFile = new File(currentFile.getParent() + File.separator + "allFilesContent.txt");
        FileUtils.renameFile(currentFile, renamedFile);

        try (FileOutputStream out = new FileOutputStream(renamedFile)) {

            for (File f : files) {

                try (FileInputStream in = new FileInputStream(f.getAbsoluteFile())) {

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0) {
                        out.write(buffer, 0, length);
                        out.flush();
                    }
                    out.write(10);
                }
            }
        }
    }

    public static void recursiveDirectoryWalk(List<File> files, File directory) {

        if (directory.isFile() && directory.getName().contains(".txt") && directory.length() <= 50) {
            files.add(directory);
        }

        if (directory.isDirectory()) {
            for (File subDir : directory.listFiles()) {
                recursiveDirectoryWalk(files, subDir);
            }
        }
    }
}