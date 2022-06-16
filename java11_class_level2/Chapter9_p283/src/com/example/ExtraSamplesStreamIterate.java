package com.example;

import java.util.stream.Stream;

public class ExtraSamplesStreamIterate {

    public static void main(String[] args) {

        Stream<String> stream = Stream.iterate("", s -> s + "s")
                .takeWhile(s -> s.length() < 10);
        //Stream<String> stream = Stream.iterate("", s -> s.length() < 10, s -> s + "s");
           
        stream.forEach(System.out::println);
    }
}
