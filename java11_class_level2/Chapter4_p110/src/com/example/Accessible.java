package com.example;

public interface Accessible {
    public static final double OVERDRAFT_FEE = 25;
    abstract double verifyDeposit(double amount, int pin);
    abstract double verifyWithdraw(double amount, int pin);
    
}
