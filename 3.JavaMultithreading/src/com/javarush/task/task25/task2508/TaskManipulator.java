package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(thread.getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
            thread.interrupt();
    }
}