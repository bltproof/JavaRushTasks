package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(thread.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(String threadName) {
        thread = new Thread(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}