 
package com.example;

public class Dog implements CanMakeVoice {
    @Override
    public void makeVoice(){
        System.out.println("旺旺!!!");
    }
    public void guardHome(){
        System.out.println("會看家!!!");
    }
}