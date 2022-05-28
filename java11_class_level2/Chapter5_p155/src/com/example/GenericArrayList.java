package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericArrayList {

    public static void main(String args[]) {

        List<Integer> partList = new ArrayList<>(3);

        partList.add(new Integer(1111));
        partList.add(new Integer(2222));
        partList.add(new Integer(3333));
        partList.add(new Integer(4444)); // Arraylist auto grows
        // partList.add("Bad Data");  // compile error now
        
        System.out.println("First Part: " + partList.get(0)); // First item
        partList.add(0, new Integer(5555)); // Insert an item by index
        partList.set(1, new Integer(6666));

        // Print List
        //use 迭代器（iterator） object
        Iterator<Integer> i = partList.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        //or use for in loop
        for (Integer partNumberObj : partList) {
            int partNumber = partNumberObj; // Demonstrates autoboxing.
            System.out.println("Part number: " + partNumber);
        }

    }
}
