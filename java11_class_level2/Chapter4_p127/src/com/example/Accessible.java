/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example;

public interface Accessible {
    
    public default double verifyDeposit(double amount, int pin){
        if(!verifyTransaction(amount, pin)){
            return 0;
        }
        return amount;
    }
    
    public default double verifyWithdraw(double amount, int pin){
        if(!verifyTransaction(amount, pin)){
            return 0;
        }
        else if(getBalance() - amount <0){
            System.out.println("Insufficient Funds");
            return 0;
        }
        return(-1 * amount);
    }
    
    private boolean verifyTransaction(double amount, int pin){
        if(!verifyPIN(pin)){
            System.out.println("Incorrect PIN");
            return false;
        }
        else if(amount < 0){
            System.out.println("Amount cannot be negative");
            return false;
        }
        return true;
    }
    
    abstract boolean verifyPIN(int pin);
    abstract double getBalance();
}
