package com.example;
 
import java.util.function.Supplier;
import java.util.stream.Stream;

public class A04Supplier2 {

    public static void main(String[] args) {
        Supplier<Integer> getRandomInt = () -> (int) (Math.random()*10) +1;
        Stream.generate(getRandomInt).limit(6).forEach(r->System.out.println(r));
    }
}
