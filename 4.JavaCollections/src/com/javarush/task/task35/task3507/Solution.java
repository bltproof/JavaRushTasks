package com.javarush.task.task35.task3507;

import java.io.File;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        File[] files = new File(pathToAnimals).listFiles();

        ClassLoader classLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) {
                byte[] bytes = new byte[0];
                try {
                    bytes = Files.readAllBytes(Paths.get(name));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return defineClass(name, bytes, 0, bytes.length);
            }
        };

        Class clazz = null;
        Set<Animal> resultSet = new HashSet<>();

        if (files != null) {
            for (File f : files) {
                try {
                    boolean isDefaultConstructor = false;
                    boolean isAnimalInterface = false;

                    clazz = classLoader.loadClass(f.getName());
                    Class[] interfaces = clazz.getInterfaces();

                    Constructor[] constructor = clazz.getConstructors();

                    for (Constructor c : constructor) {
                        if (!c.isVarArgs() && c.getParameterCount() == 0) {
                            isDefaultConstructor = true;
                        }
                    }
                    for (Class c : interfaces) {
                        if (c.getSimpleName().equals("Animal")) {
                            isAnimalInterface = true;
                        }
                    }

                    if (isAnimalInterface && isDefaultConstructor) {
                        resultSet.add((Animal) clazz.newInstance());
                    }

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultSet;
    }
}