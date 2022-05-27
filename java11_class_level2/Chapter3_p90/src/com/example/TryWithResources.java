package com.example;

public class TryWithResources {

    public static void main(String[] args) {
        final Resource1 r1 = new Resource1();
        final Resource2 r2 = new Resource2();
        try (r1; r2) {
            System.out.println("In TryWithResources try block");
        } catch (Exception e) {
            System.out.println("In TryWithResources catch block");
            System.out.println("The progress percentage is " + Math.floor(r2.getPercentage()));
        }
    }
}

class Resource1 implements AutoCloseable {

    public Resource1() {
        System.out.println("Resource1 is created!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource1 is closed!");
    }
}

class Resource2 implements AutoCloseable {

    private double percentage;

    public Resource2() {
        System.out.println("Resource2 is created!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource2 is closing but fails!");
        throw new Exception("Failed to close the Resource2 !");
    }

    public double getPercentage() {
        percentage = Math.random() * 100;
        return percentage;
    }
}
