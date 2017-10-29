package hw05.task1;

public class BankUserTwo implements Runnable {
    private final Bank bank;

    public BankUserTwo(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            bank.lock();
            if (bank.hasMoney(10)) {
                bank.getMoney(10);
            } else {
                bank.unlock();
                break;
            }
            //обычно такие операции, как release делают в секции finally, чтобы гарантированно отпускать
            bank.unlock();
        }
    }
}
