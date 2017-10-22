package hw05.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final Lock lock = new ReentrantLock();

    public synchronized void lock() {
        lock.lock();
    }

    public synchronized void unlock() {
        lock.unlock();
    }
}