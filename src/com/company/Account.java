package com.company;

public class Account {
    private int balance;
    private int id;

    //public Account () {}

    Account(int balance, int id) {
        this.balance = balance;
        this.id = id;
    }

//    public int getBalance() {
//        return balance;
//    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", id=" + id +
                '}';
    }
}
