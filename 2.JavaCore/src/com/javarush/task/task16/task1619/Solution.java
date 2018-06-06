package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

/*public class Solution {
    public static volatile boolean isStopped = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);

        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        isStopped = true;
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (!isStopped) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}*/

// Пример из книги Thinking in Java

public class Solution {

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        Thread t = new Thread(liftOff);
        t.start();
        System.out.println("Waiting for LiftOff");
    }
    //: concurrency/LiftOff.java
    // Реализация интерфейса Runnable.

    public static class LiftOff implements Runnable {
        protected int countDown = 10; // Значение по умолчанию
        private static int taskCount = 0;
        private final int id = taskCount++;

        public LiftOff() {

        }
        public LiftOff(int countDown) {
            this.countDown = countDown;
        }
        public String status() {
            return "#" + id + "(" +
                    (countDown > 0 ? countDown : "Liftoff!") + ") ";
        }
        public void run() {
            while(countDown-- > 0) {
                System.out.print(status());
                Thread.yield();
            }
        }
    }
}
