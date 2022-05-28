/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

/**
 *
 * @author javat
 */
public class D implements B,C {
    
    @Override
    public void m(){
        //provide its own implementation, eg. call B.super.m()
        B.super.m();
    }
    public static void main(String[] args) {
        D d = new D();
        d.m();
    }
}
