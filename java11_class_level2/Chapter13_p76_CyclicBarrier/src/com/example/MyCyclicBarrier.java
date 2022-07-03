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

public class MyCyclicBarrier implements Runnable {

    public static List<Integer> globalList = Collections.synchronizedList(new ArrayList<>());
    public static Random r = new Random();
    private CyclicBarrier barrier;

    public MyCyclicBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        CyclicBarrier barrier = new CyclicBarrier(2); //2 parties to trip the barrier
        MyCyclicBarrier r1 = new MyCyclicBarrier(barrier);
        MyCyclicBarrier r2 = new MyCyclicBarrier(barrier);
        MyCyclicBarrier r3 = new MyCyclicBarrier(barrier);
        MyCyclicBarrier r4 = new MyCyclicBarrier(barrier);
        es.execute(r1);
        es.execute(r2);
        es.execute(r3);
        es.execute(r4);
        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES); //wait 1 minute to continue
        System.out.println("Thread " + Thread.currentThread().getName() +" printing final dataList:" + globalList);
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
            System.out.println("Thread " + Thread.currentThread().getName() + " finished!");
        } catch (BrokenBarrierException | InterruptedException ex) {

        }
    }

}
