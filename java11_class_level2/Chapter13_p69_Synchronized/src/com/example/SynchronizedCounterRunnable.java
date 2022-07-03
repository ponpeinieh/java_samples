package com.example;

public class SynchronizedCounterRunnable implements Runnable {

    private static final SynchronizedCounter count = new SynchronizedCounter(); //static var shared by all Runnable instances
    private int countSize = 0;
    private String name;

    public SynchronizedCounterRunnable(int countSize, String name) {
        this.countSize = countSize;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < countSize; i++) {
            count.increment();
            System.out.println(name
                    + " Count: " + count.getValue());
            // Note that declaring both increment() and getValue() synchronzied only ensures that 
            // the count got incremented 'countSize'  times exactly, ie. for three Runnable instances 
            // running and countSize=10, the final count value will be 30. 
            // But the printing of the count value may see same values or out-of-order values.
        }
    }
    /* 
    public void run() {
        for (int i = 0; i < countSize; i++) {
            //using synchronized block will ensure the getValue() runs immediately after the increment() without thread interleaving
            //so the printing of the count value will see no same values or out-of-order values.
            synchronized (count) { 
                count.increment();
                System.out.println(name
                        + " Current Count: " + count.getValue());
            }
        }
    }*/

}
