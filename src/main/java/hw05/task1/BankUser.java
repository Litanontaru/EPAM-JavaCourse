package hw05.task1;

import hw05.task1.bank.Bank;

public class BankUser implements Runnable {
    private Bank bank;

    public BankUser(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (bank.hasMoney()) {
            bank.getMoney(1);
        }
    }
}
