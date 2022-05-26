/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.Employee.Department;


public class EnumTest {
    
   
  public static void main(String args[]) {
 
    for(Department dept:Department.values()){
      System.out.println(dept+" Department Code: "+dept.getDeptCode());
      System.out.println(dept+" with ordinal value-> "+dept.ordinal());
    }
  }
}

    

