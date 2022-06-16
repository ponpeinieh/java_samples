package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class ExtraSamplesFlatMap2 {

    public static void main(String[] args) {
        //  Given two lists of numbers, how would you return all pairs of numbers? 
        // For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. 
        //For simplicity, you can represent a pair as an array with two elements.
        //
        List<Integer> a1 = List.of(1,2,3);
        List<Integer> a2 = List.of(3,4);
        
        List<int[]> pairs = a1.stream().flatMap(i -> a2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        pairs.stream().forEach(k-> System.out.println("("+k[0]+","+k[1]+")"));
        
    }

}
