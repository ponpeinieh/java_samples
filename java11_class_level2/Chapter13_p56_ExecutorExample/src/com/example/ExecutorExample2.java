package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorExample2 {

    public static void main(String[] args) {
        int cpuCount = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(cpuCount);
        Future<Integer> f1 = es.submit(new ExampleCallable("First", 1001));
        Future<Integer> f2 = es.submit(new ExampleCallable("Second", 1001));
        try {
            es.shutdown();
            boolean terminated = es.awaitTermination(10, TimeUnit.SECONDS); //return true if this executor terminated and false if the timeout elapsed before termination
            System.out.println(terminated ? "This executor terminated" : "The timeout elapsed before termination");
            if (terminated) {
                Integer result1 = f1.get();
                System.out.println("Result of one: " + result1);
                Integer result2 = f2.get();
                System.out.println("Result of two: " + result2);
            } else{
                es.shutdownNow();
            }
        } catch (ExecutionException | InterruptedException ex) {
            System.out.println("Exception: " + ex);
        }

    }
}
