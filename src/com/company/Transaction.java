package com.company;

public class Transaction {
    private int id;
    private int targetId;
    private int balance;
    private int value;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

//    public int getTargetId() {
//        return targetId;
//    }

    void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

//    public int getValue() {
//        return value;
//    }

    void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", targetId=" + targetId +
                ", balance=" + balance +
                ", value=" + value +
                '}';
    }
}
