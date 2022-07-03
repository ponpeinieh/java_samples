package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyCyclicBarrier2 implements Runnable {

    public static List<Integer> globalList = Collections.synchronizedList(new ArrayList<>());
    public static int sum;
    public static Random r = new Random();
    private CyclicBarrier barrier;

    public MyCyclicBarrier2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        // A CyclicBarrier supports an optional Runnable command that is run once per barrier point, 
        // after the last thread in the party arrives, but before any threads are released. 
        // This barrier action is useful for updating shared-state before any of the parties continue.
        CyclicBarrier barrier = new CyclicBarrier(4, new AggregateRunnable()); //4 parties to trip the barrier
        MyCyclicBarrier2 r1 = new MyCyclicBarrier2(barrier);
        MyCyclicBarrier2 r2 = new MyCyclicBarrier2(barrier);
        MyCyclicBarrier2 r3 = new MyCyclicBarrier2(barrier);
        MyCyclicBarrier2 r4 = new MyCyclicBarrier2(barrier);
        es.execute(r1);
        es.execute(r2);
        es.execute(r3);
        es.execute(r4);
        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES); //wait 1 minute to continue
        System.out.println("Thread " + Thread.currentThread().getName() + " printing final dataList:" + globalList);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(r.nextInt(10) * 1000); //random sleep time to simulate the computation time required
            // create 3 random numbers and add to local list
            List<Integer> localList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                localList.add(r.nextInt(100));
            }
            //add to global list
            globalList.addAll(localList);
            System.out.println("Thread " + Thread.currentThread().getName() + " before await, add three numbers: " + localList);
            barrier.await();
            System.out.println("Thread " + Thread.currentThread().getName() + " reading the sum:" + sum);
            System.out.println("Thread " + Thread.currentThread().getName() + " finished!");
        } catch (BrokenBarrierException | InterruptedException ex) {

        }
    }

    static class AggregateRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            sum = globalList.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Thread " + Thread.currentThread().getName() + " calculate the sum of numbers in globalList:" + sum);
        }

    }
}
