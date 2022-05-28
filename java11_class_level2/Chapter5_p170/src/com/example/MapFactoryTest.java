package com.example;

import java.util.Map;
import static java.util.Map.entry;

public class MapFactoryTest {

    public static void main(String[] args) {
        Map<String, String> testMap = Map.of(null, "An object that maps keys to values",
                "List", "An ordered collection",
                "Set", "A collection that contains no duplicate elements",
                "Deque", "A linear collection that supports element insertion and removal at both ends"
        );
//        Map<String, String> testMap = Map.ofEntries(
//                entry("Map", "An object that maps keys to values"),
//                entry("List", "An ordered collection"),
//                entry("Set", "A collection that contains no duplicate elements"),
//                entry("Deque", "A linear collection that supports element insertion and removal at both ends")
//        );

        testMap.forEach((key, value) -> System.out.println(key + ": " + value + ", "));
    }
}
