
package com.example;

public class Cat extends Mammal {
    @Override
    public void makeVoice(){
        System.out.println("喵喵!!!");
    }
    public void catchMouse(){
        System.out.println("會抓老鼠!!!");
    }
}