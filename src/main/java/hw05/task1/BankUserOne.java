package hw05.task1;

public class BankUserOne implements Runnable {
    private final Bank bank;

    public BankUserOne(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bank) {
                if (bank.hasMoney(10)) {
                    bank.getMoney(10);
                } else {
                    break;
                }
            }
        }
    }
}
