/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 *
 */
public class PersonClassInvariant {

    String name;
    String ssn;
    int age;

    private void checkAge() {
        assert age >= 18 && age < 150;
    }

    public void changeName(String fname) {
        checkAge();
        name = fname;
    }

    private void printName() {
        System.out.println("name:" + name);
    }

    public static void main(String args[]) {

        PersonClassInvariant person1 = new PersonClassInvariant();
        person1.age = 15;
        person1.name = "dave";
        person1.changeName("David");
        person1.printName();
    }
}
