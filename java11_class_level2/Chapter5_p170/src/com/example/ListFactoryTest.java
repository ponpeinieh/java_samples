/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */
package com.example;

import java.util.List;

public class ListFactoryTest {

    public static void main(String[] args) {

        List<Integer> testList = List.of(1, 2, 4, 8, 16, 32); //return an immutable list
        //testList.add(64);
        //testList.set(2, 0);

        //testList = List.of(0);
        testList.forEach(x -> System.out.print(x + ", "));
        System.out.println("");

    }
}
