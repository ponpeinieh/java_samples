package com.example;

public class Invariant {

    static void checkNum(int num) {
        int x = num;
        if (x > 0) {
            System.out.println("number is positive: " + x);
        } else if (x == 0) {
            System.out.println("number is zero ");
        } else {
            assert (x > 0); //add the -ea VM option for enabling assertion
            System.out.println("number is negative: " + x);
        }
    }

    public static void main(String args[]) {
        checkNum(-4);
    }
}
