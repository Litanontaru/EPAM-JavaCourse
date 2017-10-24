package hw05.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Philosopher> philosophers = new ArrayList<>();
    private static List<Fork> forks = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        populateForks();
        populatePhilosophers();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(philosophers.get(i)));
        }
        threads.forEach(Thread::start);
        Thread.sleep(10000);
        threads.forEach(Thread::interrupt);

        philosophers.forEach(p -> System.out.println(p.eaten));
    }

    private static void populateForks() {
        for (int i = 1; i <= 5; i++) {
            forks.add(new Fork());
        }
    }

    private static void populatePhilosophers() {
        philosophers.add(new Philosopher(1, forks.get(0), forks.get(1)));
        philosophers.add(new Philosopher(2, forks.get(1), forks.get(2)));
        philosophers.add(new Philosopher(3, forks.get(2), forks.get(3)));
        philosophers.add(new Philosopher(4, forks.get(3), forks.get(4)));
        philosophers.add(new Philosopher(5, forks.get(4), forks.get(0)));
    }
}
