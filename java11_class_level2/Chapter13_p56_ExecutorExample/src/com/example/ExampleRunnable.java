package com.example;

public class ExampleRunnable implements Runnable {

    private final String name;
    private final int len;

    public ExampleRunnable(String name, int len) {
        this.name = name;
        this.len = len;
    }

    @Override
    public void run() {
        for (int i = 0; i < len; i++) {
            System.out.println(name + ":" + i);
            /*
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println(name + " was interrupted!");
                return;
            }
             */
        }
        System.out.println(name + " thread finished!");
    }
}
