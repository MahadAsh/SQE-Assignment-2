package com.example.app;

public class AccountService {
    public static class Account {
        private String id;
        private double balance;
        public Account(String id, double start){ this.id=id; this.balance=start; }
        public double getBalance(){ return balance; }
        public String getId(){ return id; }
    }

    public void deposit(Account acc, double amount){
        if(amount <= 0) throw new IllegalArgumentException("amount must be positive");
        acc.balance += amount;
    }

    public void withdraw(Account acc, double amount){
        if(amount <= 0) throw new IllegalArgumentException("amount must be positive");
        if(amount > acc.balance) throw new IllegalStateException("insufficient funds");
        acc.balance -= amount;
    }
}
