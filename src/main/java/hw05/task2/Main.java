package hw05.task2;

import hw05.task2.philosopher.LockPhilosopher;
import hw05.task2.philosopher.Philosopher;
import hw05.task2.philosopher.SynchrPhilosopher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<LockPhilosopher> lockPhilosophers = new ArrayList<>();
    private static List<SynchrPhilosopher> synchrPhilosophers = new ArrayList<>();
    private static List<Fork> forks = new ArrayList<>();
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        populateForks();
        populateLockPhilosophers();
        populateSynchrPhilosophers();

        System.out.println("LockPhilosophers:");
        Thread.sleep(2000);
        run(lockPhilosophers);
        System.out.println("\n\n");
        System.out.println("SynchrPhilosophers:");
        Thread.sleep(2000);
        run(synchrPhilosophers);
    }

    private static void populateForks() {
        for (int i = 1; i <= 5; i++) {
            forks.add(new Fork());
        }
    }

    private static void populateLockPhilosophers() {
        lockPhilosophers.add(new LockPhilosopher(1, forks.get(0), forks.get(1)));
        lockPhilosophers.add(new LockPhilosopher(2, forks.get(1), forks.get(2)));
        lockPhilosophers.add(new LockPhilosopher(3, forks.get(2), forks.get(3)));
        lockPhilosophers.add(new LockPhilosopher(4, forks.get(3), forks.get(4)));
        lockPhilosophers.add(new LockPhilosopher(5, forks.get(4), forks.get(0)));
    }

    private static void populateSynchrPhilosophers() {
        synchrPhilosophers.add(new SynchrPhilosopher(1, forks.get(0), forks.get(1)));
        synchrPhilosophers.add(new SynchrPhilosopher(2, forks.get(1), forks.get(2)));
        synchrPhilosophers.add(new SynchrPhilosopher(3, forks.get(2), forks.get(3)));
        synchrPhilosophers.add(new SynchrPhilosopher(4, forks.get(3), forks.get(4)));
        synchrPhilosophers.add(new SynchrPhilosopher(5, forks.get(4), forks.get(0)));
    }

    private static void run(List<? extends Philosopher> list) throws InterruptedException {
        threads.clear();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(list.get(i)));
        }
        threads.forEach(Thread::start);
        Thread.sleep(10000);
        threads.forEach(Thread::interrupt);
        Thread.sleep(1000);
    }
}
