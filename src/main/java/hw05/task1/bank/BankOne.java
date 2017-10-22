package hw05.task1.bank;

public class BankOne extends Bank {
    public BankOne(int moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public synchronized void getMoney(int amount) {
        if (amount <= moneyAmount){
            moneyAmount -= amount;
            System.out.printf("The remaining amount of money in the task1: %d. Thread %s", moneyAmount, Thread.currentThread().getName());
            System.out.println();
        }
    }
}
