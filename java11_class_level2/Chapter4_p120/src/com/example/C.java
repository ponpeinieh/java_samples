
package com.example;

public interface C extends B{
    @Override
    default void m(){
        System.out.println("in C.m()");
    }
}
