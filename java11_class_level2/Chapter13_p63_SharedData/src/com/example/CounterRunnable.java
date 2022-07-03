package com.example;

public class CounterRunnable implements Runnable {

    private static Counter count = new Counter(); // static var,  so shared by all Runnable instances
    private int countSize = 0;
    private String name;

    public CounterRunnable(int countSize, String name) {
        this.countSize = countSize;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < countSize; i++) {
            count.increment();
            System.out.println(name + " count: " + count.getValue());
        }
    }
}
