
package com.example;

public interface C {
    default void m(){
        System.out.println("in C.m()");
    }
}
