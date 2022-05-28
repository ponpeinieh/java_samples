
package com.example;

public class Piano implements CanMakeVoice {
    @Override
    public void makeVoice(){
        System.out.println("do - re - mi");
    }
}