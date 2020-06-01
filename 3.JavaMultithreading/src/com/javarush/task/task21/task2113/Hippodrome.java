package com.javarush.task.task21.task2113;

import java.util.Arrays;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome() {
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {

        Horse horse1 = new Horse("Horse_1", 3, 0);
        Horse horse2 = new Horse("Horse_2", 3, 0);
        Horse horse3 = new Horse("Horse_3", 3, 0);

        game = new Hippodrome(Arrays.asList(horse1, horse2, horse3));
    }
}