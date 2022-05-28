 
package com.example;

public class Dog extends Mammal {
    @Override
    public void makeVoice(){
        System.out.println("旺旺!!!");
    }
    public void guardHome(){
        System.out.println("會看家!!!");
    }
}