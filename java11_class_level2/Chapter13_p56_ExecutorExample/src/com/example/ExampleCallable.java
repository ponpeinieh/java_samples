package com.example;

import java.util.concurrent.Callable;

public class ExampleCallable implements Callable<Integer> {

    private final String name;
    private final int len;
    private int sum = 0;

    public ExampleCallable(String name, int len) {
        this.name = name;
        this.len = len;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < len; i++) {
            System.out.println(name + ":" + i);
            sum += i;
            /*
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println(name + " was interrupted!");
                throw ex;
            }
             */
        }
        return sum;
    }

}
