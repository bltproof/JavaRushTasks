package com.javarush.task.task38.task3810;

public @interface Revision {
    //напиши свой код
    int revision();
    String comment() default "";
    Date date();
    Author[] authors() default {};
}