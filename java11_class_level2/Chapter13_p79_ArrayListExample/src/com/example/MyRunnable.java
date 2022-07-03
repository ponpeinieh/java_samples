package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyRunnable implements Runnable {

    public static List<String> wordList = new ArrayList<>();
    //public static List<String> wordList = Collections.synchronizedList(new ArrayList<>());
    //public static List<String> wordList = new CopyOnWriteArrayList<>();
    private final String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        MyRunnable r1 = new MyRunnable("First");
        MyRunnable r2 = new MyRunnable("Second");

        es.submit(r1);
        es.submit(r2);
        es.shutdown();
        try {
            es.awaitTermination(1000, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("==ItemList==");
        wordList.stream().forEach(
                s -> System.out.println("Item: " + s));
    }

    public void run() {
        wordList.add("A");
        System.out.println("Thread " + name + " adds A!");
        wordList.add("B");
        System.out.println("Thread " + name + " adds B!");
        wordList.add("C");
        System.out.println("Thread " + name + " adds C!");
    }
    /*
    public void run() {
        synchronized (wordList) {
            wordList.add("A");
            System.out.println("Thread " + name + " adds A!");
            wordList.add("B");
            System.out.println("Thread " + name + " adds B!");
            wordList.add("C");
            System.out.println("Thread " + name + " adds C!");
        }
    }
     */
}
