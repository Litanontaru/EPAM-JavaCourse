package hw05.task2.philosopher;

import hw05.task2.Fork;

public class LockPhilosopher extends Philosopher implements Runnable {
    public LockPhilosopher(int number, Fork leftFork, Fork rightFork) {
        super(number, leftFork, rightFork);
    }

    @Override
    public void run() {
        //лучше просто поставить true в условии и ловить InterruptedException
        while (!Thread.currentThread().isInterrupted()) {
            think();
            if (leftFork.pickUp()) {
                if (rightFork.pickUp()) {
                    eat();
                    //обычно такие операции, как release делают в секции finally, чтобы гарантированно отпускать
                    leftFork.putDown();
                    rightFork.putDown();
                } else {
                    leftFork.putDown();
                }
            }
        }
    }
}
