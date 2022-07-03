package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ExampleRunnable("First", 10001));
        es.execute(new ExampleRunnable("Second",10001));
        Thread.sleep(10000);
        es.shutdown();
        //es.shutdownNow();
        //es.execute(new ExampleRunnable("Third", 1001));
        System.out.println("The main thread finished!");
    }
}
