/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

public class Controlflow {

    enum Suit {
        SPADES, DIAMONDS, CLUBS, HEARTS
    }

    public static void main(String args[]) {
        Suit suit = Suit.SPADES;
        switch (suit) {
            case CLUBS:
                System.out.println("club");
                break;
            case DIAMONDS:
                System.out.println("diamond");
                break;
            case HEARTS:
                System.out.println("heart");
                break;
            case SPADES:
                System.out.println("spades");
                //break;
            default:
                assert false : suit;  
                System.out.println("In default case!");
        }
    }
}
