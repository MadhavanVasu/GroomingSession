package com.mv.week3;

class RacingConditionExample {
    private int count = 0;

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }


}

public class RacingConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        final RacingConditionExample rc = new RacingConditionExample();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                rc.incrementCount();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                rc.incrementCount();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + rc.getCount());
    }

}

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        // simulate processing time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance -= amount;
    }

    public void deposit(int amount) {
        // simulate processing time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}

class BankAccountTest {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                account.withdraw(100);
                System.out.println("Withdrawn 100 from account. Current balance: " + account.getBalance());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                account.deposit(100);
                System.out.println("Deposited 100 to account. Current balance: " + account.getBalance());
            }
        });

        t1.start();
        t1.join();
        t2.start();

//        t1.join();
        t2.join();

        System.out.println(account.getBalance());
    }
}


