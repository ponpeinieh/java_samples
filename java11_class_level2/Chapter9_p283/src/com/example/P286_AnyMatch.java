package com.example;

import java.util.List;

/**
 *
 * @author oracle
 */
public class P286_AnyMatch {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        boolean result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .anyMatch(e->e.getSalary() * Bonus.byRole(e.getRole())>8000);

        if (result) {
            System.out.println("Some bonus amount are large than 8000.");
        } else {
            System.out.println("All bonus amount are less than 8000.");
        }

    }

}
