package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtraSamplesDropWhile {

    public static void main(String[] args) {
        Stream<Integer> stream
                = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10); //assume numbers are ordered
                //= Stream.of(1, 4, 4, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list
                = stream.dropWhile(number -> (number / 4 == 1)).collect(Collectors.toList()); //stop when the predicate is false
                //=stream.takeWhile(number -> (number / 4 == 1)).collect(Collectors.toList());
        // print list
        System.out.println(list);
    }
}
