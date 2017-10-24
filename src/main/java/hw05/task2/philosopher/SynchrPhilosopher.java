package hw05.task2.philosopher;

import hw05.task2.Fork;

public class SynchrPhilosopher extends Philosopher implements Runnable {
    public SynchrPhilosopher(int number, Fork leftFork, Fork rightFork) {
        super(number, leftFork, rightFork);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            think();
            if (number % 2 == 0) {
                synchronized (leftFork) {
                    synchronized (rightFork) {
                        eat();
                    }
                }
            } else {
                synchronized (rightFork) {
                    synchronized (leftFork) {
                        eat();
                    }
                }
            }
        }
    }
}
