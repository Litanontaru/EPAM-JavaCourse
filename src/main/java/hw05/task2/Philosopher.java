package hw05.task2;

public class Philosopher implements Runnable {
    private final int number;
    private final Fork leftFork;
    private final Fork rightFork;
    public int eaten;


    public Philosopher(int number, Fork leftFork, Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
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

    private void eat() {
        System.out.printf("Philosopher %d is eating\n", number);
        eaten++;

    }

    private void think() {
        System.out.printf("Philosopher %d is thinking\n", number);
    }
}
