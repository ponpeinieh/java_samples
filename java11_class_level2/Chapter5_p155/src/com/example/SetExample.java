package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        //Set<String> set = new HashSet<>();

        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("three"); // not added, only uniques

        for (String item : set) {
            System.out.println("Item: " + item);
        }

    }
}
