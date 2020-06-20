package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {

        while (getState() != State.TERMINATED) {
            switch (thread.getState()) {

                case NEW:
                    System.out.println(State.NEW);
                case RUNNABLE:
                    System.out.println(State.RUNNABLE);
                case TERMINATED:
                    System.out.println(State.TERMINATED);
            }
        }
    }
}