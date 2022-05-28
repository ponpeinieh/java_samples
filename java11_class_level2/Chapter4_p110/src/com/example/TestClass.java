package com.example;

/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */



public class TestClass {
    public static void main(String[] args) {
        RestrictedChecking acct1 = new RestrictedChecking(1000, 1111);
        
        acct1.deposit(1000, 2222);
        acct1.deposit(1000, 1111);
        acct1.withdraw(-1500, 1111);
        acct1.withdraw(2000, 1111);
        acct1.withdraw(2000, 2222);
        acct1.withdraw(2000, 1111);
        acct1.withdraw(500, 1111);
        acct1.withdraw(1500, 1111);
        
        
    }
}
