
package com.example;

public class UseCanMakeVoice {
    public static void choir(CanMakeVoice m1, CanMakeVoice m2, CanMakeVoice m3){
        m1.makeVoice();
        m2.makeVoice();
        m3.makeVoice();
    }
    
    
    public static void main(String[] args) {
        //產生物件  
        Dog c1 = new Dog();
        CanMakeVoice c2 = new Cat();
        CanMakeVoice c3 = new Tiger();
        choir(c1,c2,c3);
        Piano p1 = new Piano();
        choir(c1,c2,p1);
    }
}