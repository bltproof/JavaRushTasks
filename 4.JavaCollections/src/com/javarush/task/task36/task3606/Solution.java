package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() {
        File[] listOfFiles = new File(packageName).listFiles();

        class MyClassLoader extends ClassLoader {
            private String pathtobin;

            public MyClassLoader(String pathtobin) {
                super();
                this.pathtobin = pathtobin;
            }

            private Class load(Path path) throws IOException {
                byte[] bytes = Files.readAllBytes(path);
                return defineClass(null, bytes, 0, bytes.length);
            }
        }
        for (File f : Objects.requireNonNull(listOfFiles)) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                MyClassLoader loader = new MyClassLoader(f.getClass().toString());

                try {
                    Class clazz = loader.load(f.toPath());
                    hiddenClasses.add(clazz);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {
            for (Class clazz : hiddenClasses) {
                Constructor constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);

                HiddenClass hiddenClass = (HiddenClass) constructor.newInstance();

                if (hiddenClass.getClass().getSimpleName().toLowerCase().contains(key.toLowerCase())) {
                    return hiddenClass;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}