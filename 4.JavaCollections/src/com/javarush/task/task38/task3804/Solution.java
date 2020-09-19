package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {

    }

    public static class ExceptionFactory {

        public static Throwable createException(Enum e) {
            if (e == null)
                return new IllegalArgumentException();

            String message = e.name().charAt(0) + e.name().substring(1).toLowerCase().replace("_", " ");

            if (e instanceof ApplicationExceptionMessage)
                return new Exception(message);

            if (e instanceof DatabaseExceptionMessage)
                return new RuntimeException(message);

            if (e instanceof UserExceptionMessage)
                return new Error(message);

            return new IllegalArgumentException();
        }
    }
}