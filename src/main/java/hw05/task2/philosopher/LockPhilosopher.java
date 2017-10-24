package hw05.task2.philosopher;

import hw05.task2.Fork;

public class LockPhilosopher extends Philosopher implements Runnable {
    public LockPhilosopher(int number, Fork leftFork, Fork rightFork) {
        super(number, leftFork, rightFork);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            think();
            if (leftFork.pickUp()) {
                if (rightFork.pickUp()) {
                    eat();
                    leftFork.putDown();
                    rightFork.putDown();
                } else {
                    leftFork.putDown();
                }
            }
        }
    }
}
