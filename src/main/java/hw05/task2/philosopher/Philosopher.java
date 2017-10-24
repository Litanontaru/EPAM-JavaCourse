package hw05.task2.philosopher;

import hw05.task2.Fork;

public abstract class Philosopher implements Runnable {
    protected final int number;
    protected final Fork leftFork;
    protected final Fork rightFork;

    public Philosopher(int number, Fork leftFork, Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    protected  void eat() {
        System.out.printf("Philosopher %d is eating\n", number);
    }

    protected void think() {
        System.out.printf("Philosopher %d is thinking\n", number);
    }
}
