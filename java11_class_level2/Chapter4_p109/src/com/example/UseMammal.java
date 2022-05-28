
package com.example;

public class UseMammal {
    public static void choir(Mammal m1, Mammal m2, Mammal m3){
        m1.makeVoice();
        m2.makeVoice();
        m3.makeVoice();
    }
    
    
    public static void main(String[] args) {
        //產生物件 
        //Mammal m1 = new Dog();
        Dog m1 = new Dog();
        Mammal m2 = new Cat();
        Mammal m3 = new Tiger();
        choir(m1,m2,m3);
    }
}