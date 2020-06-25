package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field

        if (lock.tryLock()) {
            lock.lock();

            try {
                actionIfLockIsFree();

            } finally {
                lock.unlock();
            }
        }
        actionIfLockIsBusy();
    }

    public void actionIfLockIsFree() {
        System.out.println("Doing job...");
    }

    public void actionIfLockIsBusy() {
        System.out.println("Waiting...");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread1 = new Thread(solution::someMethod);
        thread1.start();

        Thread thread2 = new Thread(solution::someMethod);
        thread2.start();
    }
}