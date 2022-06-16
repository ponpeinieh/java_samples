package com.example;

import java.util.stream.Stream;

/**
 *
 * @author oracle
 */
public class P295_CreateStream {

    public static void main(String[] args) {

        Stream.of("Monday", "Tuesday", "Wednesday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));
    }
}
