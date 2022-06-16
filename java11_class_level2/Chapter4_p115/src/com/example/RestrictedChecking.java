/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example;

public class RestrictedChecking implements Accessible{
    private double balance;
    private int PIN;
    public static final double RESTRICTION = 500;
    
    public RestrictedChecking(double balance, int PIN){
        this.balance = balance;
        this.PIN = PIN;
    }

    @Override
    public boolean verifyPIN(int pin){
        return(pin == PIN);
    }
    @Override
    public double getBalance(){
        return balance;
    }
    private void setBalance(double amount){
        balance += amount;
    }
    
 
    @Override
    public double verifyWithdraw(double amount, int pin){
        double returnValue = Accessible.super.verifyWithdraw(amount, pin); 
        if(amount > RESTRICTION && returnValue != 0){
            System.out.println("Cannot withdraw more than " +RESTRICTION);
            return 0;
        }
        return returnValue; 
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
