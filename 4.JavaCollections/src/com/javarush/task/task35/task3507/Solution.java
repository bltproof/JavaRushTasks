package com.javarush.task.task35.task3507;

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
        String[] classes = Paths.get(pathToAnimals.substring(1)).toFile().list();

        ClassLoader classLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) {
                String newName = "";
                byte[] bytes = new byte[0];
                try {
                    String path = pathToAnimals.substring(1) + "/" + name;
                    bytes = Files.readAllBytes(Paths.get(path));
                    newName = path.substring(path.indexOf("com"), path.indexOf(".class")).replace('/', '.');
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return defineClass(newName, bytes, 0, bytes.length);
            }
        };

        Class clazz = null;
        Set<Animal> resultSet = new HashSet<>();

        if (classes != null) {
            for (String s : classes) {
                try {
                    boolean isDefaultConstructor = false;
                    boolean isAnimalInterface = false;

                    clazz = classLoader.loadClass(s);
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