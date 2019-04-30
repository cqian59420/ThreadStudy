package chen.lotus.thread;

public class Bank {

    private String name;

    private int money;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public synchronized void deposit(int addMoney) {
        money += addMoney;
    }

    public synchronized boolean withdraw(int getMoney) {
        if (money > getMoney) {
            money -= getMoney;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
