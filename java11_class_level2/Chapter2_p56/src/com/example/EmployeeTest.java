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
public class EmployeeTest {

    public static void main(String args[]) {

        Employee emp1 = new Employee(121, "Ron", "ab123", 5000);
        Employee emp2 = new Employee(122, "ken", "def123", 6000);
        System.out.println(emp1);
        System.out.println(emp2);
        Employee emp3 = emp1;
        Employee emp4 = new Employee(121, "Ron", "ab123", 5000);
        System.out.println("emp1.equals(emp3)="+emp1.equals(emp3));
        System.out.println("emp1.equals(emp4)="+emp1.equals(emp4));
    }
}
