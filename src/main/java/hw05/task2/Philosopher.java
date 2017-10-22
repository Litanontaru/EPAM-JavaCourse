package hw05.task2;

public class Philosopher implements Runnable {
    private int number;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(int number, Fork leftFork, Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while(true) {
            think();
            takeLeftFork();
            takeRightFork();
            eat();
            putRightFork();
            putLeftFork();
        }
    }

    private void takeLeftFork() {
        leftFork.lock();
        System.out.printf("Philosopher %d is picking up the left fork.\n", number);
    }

    private void takeRightFork() {
        rightFork.lock();
        System.out.printf("Philosopher %d is picking up the right fork.\n", number);
    }

    private void putLeftFork() {
        leftFork.unlock();
        System.out.printf("Philosopher %d is putting down the left fork.\n", number);
    }

    private void putRightFork() {
        rightFork.unlock();
        System.out.printf("Philosopher %d is putting down the right fork.\n", number);
    }

    private void think() {
        System.out.printf("Philosopher %d is thinking.\n", number);
    }

    private void eat() {
        System.out.printf("Philosopher %d is eating.\n", number);
    }
}