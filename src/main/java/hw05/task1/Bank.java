package hw05.task1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    //В будущем стоит изучить необходимость использования volatile для подобных переменных
    //В реальном продакшене без volatile это не будет работать
    private int moneyAmount;

    //Рекомендуется все final поля (aka. конфигурацию-сервисы) объявлять выше не final,
    //отделяя таким образом поля состояния от полей от конфигурации
    private final Lock locker = new ReentrantLock(true);

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public boolean hasMoney(int amount) {
        return moneyAmount >= amount;
    }

    public void getMoney(int amount) {
        if (hasMoney(amount)){
            moneyAmount -= amount;
            //Нарушиение JCC - длина строки превышает 120
            System.out.printf("The remaining amount of money in the bank: %d. Thread %s", moneyAmount, Thread.currentThread().getName());
            System.out.println();
        } else {
            throw new NoEnoughMoneyException("There is not enough money in the bank!");
        }
    }

    public void lock() {
        locker.lock();
    }

    public void unlock() {
        locker.unlock();
    }
}
