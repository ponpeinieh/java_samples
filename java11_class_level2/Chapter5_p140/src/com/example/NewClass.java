package com.example;

import java.util.ArrayList;
import java.util.List;

public class NewClass {

    public static void main(String[] args) {
        // create an array of Integer
        Integer[] integerArray = new Integer[5]; 
        integerArray[0] = 10; // Autoboxing , assign primitive 10 to Integer array
        int value = integerArray[0]; // Auto-unboxing , get int value of Integer
        //
        List<Integer> data = new ArrayList<Integer>();
        data.add(100);
        //data.add(new Integer(200));
        int e = data.get(0);
        //int e2 = data.get(0).intValue();
        
    }
}
