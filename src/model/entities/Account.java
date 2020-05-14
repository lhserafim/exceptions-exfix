package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account() {
    }

    public Account(int number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws DomainExceptions {
        //se não houver saldo na conta
        //Not enough balance
        if (amount > balance) {
            throw new DomainExceptions("Not enough balance");
        }
        //se o valor do saque for superior ao limite
        //The amount exceeds withdraw limit
        if (amount > withdrawLimit) {
            throw new DomainExceptions("The amount exceeds withdraw limit");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "New balance: " + String.format("%.2f",getBalance());
    }
}
