package com.example;

public class RestrictedChecking implements Accessible{
    private double balance;
    private int PIN;
    public static final double RESTRICTION = 500;
    
    public RestrictedChecking(double balance, int PIN){
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
    
    @Override
    public double verifyDeposit(double amount, int pin){
        if(!verifyPIN(pin)){
            System.out.println("Incorrect PIN");
            return 0;
        }
        else if(amount < 0){
            System.out.println("Amount cannot be negative");
            return 0;
        }
        return amount;
    }   
    @Override
    public double verifyWithdraw(double amount, int pin){
        if(!verifyPIN(pin)){
            System.out.println("Incorrect PIN");
            return 0;
        }
        else if(amount < 0){
            System.out.println("Amount cannot be negative");
            return 0;
        }
        else if(getBalance() - amount <0){
            System.out.println("Insufficient Funds");
            return 0;
        }
        else if(amount > RESTRICTION){
            System.out.println("Cannot withdraw more than " +RESTRICTION);
            return 0;
        }
        return(-1 * amount);
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
