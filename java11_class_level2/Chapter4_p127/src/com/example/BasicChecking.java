/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example;

public class BasicChecking implements Accessible{
    private double balance;
    private int PIN;
    
    public BasicChecking(double balance, int PIN){
        this.balance = balance;
        this.PIN = PIN;
    }

    public boolean verifyPIN(int pin){
        return(pin == PIN);
    }
    public double getBalance(){
        return balance;
    }
    private void setBalance(double amount){
        balance += amount;
    }
    
    
    public void deposit(double amount, int pin){
        amount = verifyDeposit(amount, pin);
        setBalance(amount);
        System.out.println("Deposit of: $" +amount);
        System.out.println("Balance: $" +getBalance());
    }
    public void withdraw(double amount, int pin){
        amount = verifyWithdraw(amount, pin);
        setBalance(amount);
        System.out.println("Withdrawal of: $" +(-1*amount));
        System.out.println("Balance: $" +getBalance());
    }
}
