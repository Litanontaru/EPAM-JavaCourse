package hw05.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>>System synchronization:<<<");
        Thread.sleep(1000);
        Bank bank = new Bank(13447);

        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(new BankUserOne(bank));
            t.start();
        }

        System.out.println("\n\n\n>>>Program synchronization:<<<");
        Thread.sleep(1000);
        bank = new Bank(13447);

        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(new BankUserTwo(bank));
            t.start();
        }
    }
}
