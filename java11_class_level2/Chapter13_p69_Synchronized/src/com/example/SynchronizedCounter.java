package com.example;

public class SynchronizedCounter {

    private int i = 0;

    //synchronzied method
    public synchronized void increment() {
        i++;
    }

    //synchronzied method
    public synchronized int getValue() {
        return i;
    }
}
