package javalab;

import java.util.*;
class BankAccount {
    int balance = 0;
    void deposit(int amount) {
        balance += amount;
    }
    void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
    int getBalance() {
        return balance;
    }
}
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BankAccount account = new BankAccount();
        for (int i = 0; i < n; i++) {
            String operation = sc.next();
            int amount = sc.nextInt();
            if (operation.equalsIgnoreCase("Deposit")) {
                account.deposit(amount);
            } else if (operation.equalsIgnoreCase("Withdraw")) {
                account.withdraw(amount);
            }
        }
        System.out.println(account.getBalance());
        sc.close();
    }
}