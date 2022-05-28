package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestQueue {

    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");

        int size = queue.size() - 1;
        while (size >= 0) {
            System.out.println(queue.remove());
            size--;
        }
    }
}
