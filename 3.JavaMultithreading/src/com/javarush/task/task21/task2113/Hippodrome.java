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

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
//            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse h : getHorses()) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : getHorses()) {
            h.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        List<Horse> list = getHorses();
        Horse horse = null;
        double max;

        for (Horse h : list) {
            max = h.getDistance();
            horse = h;

            for (Horse h2 : getHorses()) {
                if (h2.getDistance() > max) {
                    max = h2.getDistance();
                    horse = h2;
                }
            }
            break;
        }
        return horse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {

        Horse horse1 = new Horse("Slevin", 3, 0);
        Horse horse2 = new Horse("Lucky", 3, 0);
        Horse horse3 = new Horse("Homer", 3, 0);

        game = new Hippodrome(Arrays.asList(horse1, horse2, horse3));
        game.run();
        game.printWinner();
    }
}