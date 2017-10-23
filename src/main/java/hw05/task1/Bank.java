package hw05.task1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int moneyAmount;
    private final Lock locker = new ReentrantLock(true);

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public boolean hasMoney(int amount) {
        return moneyAmount >= amount;
    }

    public void getMoney(int amount) {
        if (hasMoney(amount)){
            moneyAmount -= amount;
            System.out.printf("The remaining amount of money in the bank: %d. Thread %s", moneyAmount, Thread.currentThread().getName());
            System.out.println();
        } else {
            throw new NoEnoughMoneyException("There is not enough money in the bank!");
        }
    }

    public void lock() {
        locker.lock();
    }

    public void unlock() {
        locker.unlock();
    }
}
