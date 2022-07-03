package com.example;

public class ThreadTest {

    public static void main(String[] args) {
        ExampleThread thread1 = new ExampleThread("First", 1001);
        Thread thread2 = new Thread(new ExampleRunnable("Second", 1001));
        //or use lambda for Runnable interface
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1001; i++) {
                System.out.println("Third " + ":" + i);
            }
            System.out.println("Third" + " thread finished!");
        });
        // Start Threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
