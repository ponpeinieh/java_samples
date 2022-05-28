
package com.example;

public interface B {
    default void m(){
        System.out.println("in B.m()");
    }
}
