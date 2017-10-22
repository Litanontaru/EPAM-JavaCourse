package hw05.task1.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTwo extends Bank {
    public BankTwo(int moneyAmount) {
        super(moneyAmount);
    }

    private Lock lock = new ReentrantLock();

    @Override
    public void getMoney(int amount) {
        lock.lock();
        try {
            if (amount <= moneyAmount) {
                moneyAmount -= amount;
                System.out.printf("The remaining amount of money in the task1: %d. Thread %s", moneyAmount, Thread.currentThread().getName());
                System.out.println();
            }
        } finally {
            lock.unlock();
        }
    }
}
