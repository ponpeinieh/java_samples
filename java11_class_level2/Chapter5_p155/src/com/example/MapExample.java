package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        Map<String, String> partList = new TreeMap<>();
        //Map <String, String> partList = new HashMap<>();
        partList.put("S001", "Blue Polo Shirt");
        partList.put("S002", "Black Polo Shirt");
        partList.put("H002", "Duke Hat");
        //
        partList.put("S002", "Black T-Shirt"); // Overwrite value
        //
        partList.put("T001", null);
        //partList.put(null, null); //runtime exception for TreeMap, but ok for HashMap
        Set<String> keys = partList.keySet();

        System.out.println("=== Part List ===");
        for (String key : keys) {
            System.out.println("Part#: " + key);
            System.out.println("Value: " + " " + partList.get(key));

        }

    }
}
