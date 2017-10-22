package hw05.task1.bank;

public abstract class Bank {
    protected int moneyAmount;

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public abstract void getMoney(int amount);

    public boolean hasMoney() {
        return moneyAmount > 0;
    }
}
