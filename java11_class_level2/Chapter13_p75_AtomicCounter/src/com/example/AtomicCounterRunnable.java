package com.example;

public class AtomicCounterRunnable implements Runnable {

    private static AtomicCounter count = new AtomicCounter();
    private int countSize = 0;
    private String name;

    public AtomicCounterRunnable(int countSize, String name) {
        this.countSize = countSize;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < countSize; i++) {
            count.increment();
            System.out.println(name
                    + " Count: " + count.getValue());
        }
    }

}
