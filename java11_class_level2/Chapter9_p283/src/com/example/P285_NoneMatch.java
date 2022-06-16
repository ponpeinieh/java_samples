package com.example;

import java.util.List;

/**
 *
 * @author oracle
 */
public class P285_NoneMatch {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        boolean result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .noneMatch(e->e.getSalary() * Bonus.byRole(e.getRole())>10000);

        if (result) {
            System.out.println("All bonus amount are less than 10000.");
        } else {
            System.out.println("Some bonus amount are greater than 10000.");
        }

    }

}
