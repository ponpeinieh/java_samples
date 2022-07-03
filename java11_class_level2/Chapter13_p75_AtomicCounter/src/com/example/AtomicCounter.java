package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger i = new AtomicInteger();

    public void increment() {
        i.incrementAndGet();
    }

    public int getValue() {
        return i.get();
    }
}
