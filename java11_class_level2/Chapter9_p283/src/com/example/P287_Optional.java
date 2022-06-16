package com.example;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author oracle
 */
public class P287_Optional {
    
    public static void main(String[] args) {
        
        List<Employee> eList = Employee.createShortList();
        
        System.out.println("\n== First CO Bonus ==");
        
        System.out.println(
          eList.stream()
              .filter(e -> e.getRole().equals(Role.EXECUTIVE))
              .filter(e -> e.getState().equals("CO"))
              .findFirst()
              .map(e ->e.getSummary())
              .orElse("No match found!")
        );                                    
    }
}
