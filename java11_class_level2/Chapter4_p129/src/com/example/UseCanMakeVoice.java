package com.example;

public class UseCanMakeVoice {

    public static void choir(CanMakeVoice m1, CanMakeVoice m2, CanMakeVoice m3) {
        m1.makeVoice();
        m2.makeVoice();
        m3.makeVoice();
    }

    public static void main(String[] args) {
        //產生物件  
        Dog c1 = new Dog();
        CanMakeVoice c2 = new Cat();
        CanMakeVoice c3 = new CanMakeVoice() {
            @Override
            public void makeVoice() {
                System.out.println("嗯嗯嗯!!!");
            }
        }; //note the semicolon
        choir(c1,c2,c3);
        //CanMakeVoice c4 = () -> System.out.println("嘿嘿嘿!!!");
        CanMakeVoice c4 = () -> {System.out.println("嘿嘿嘿!!!");};
        choir(c1,c2,c4);
    }
}
