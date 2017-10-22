package hw05.task1;

import hw05.task1.bank.BankOne;
import hw05.task1.bank.BankTwo;

public class Main {
    public static void main(String[] args) {
        BankOne bank1 = new BankOne(13447);
        BankTwo bank2 = new BankTwo(13447);

        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(new BankUser(bank1));
            t.start();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(new BankUser(bank2));
            t.start();
        }
    }
}
