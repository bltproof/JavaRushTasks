package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }
    public static class CountUpRunnable implements Runnable {
        //Add your code here - добавь код тут
        private int countIndexUp = Solution.number - 4;

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUp += 1;
                    if (countIndexUp > Solution.number) return;
                    Thread.sleep(500);
                    Thread.sleep(125);
                }
            } catch (InterruptedException e) {
            }
        }
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }
    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
