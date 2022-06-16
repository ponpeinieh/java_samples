package com.example;

import java.util.List;

/**
 *
 * @author oracle
 */
public class P285_AllMatch {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        boolean result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .allMatch(e->e.getSalary() * Bonus.byRole(e.getRole())>7000);

        if (result) {
            System.out.println("All bonus amount are greater than 7000.");
        } else {
            System.out.println("Some bonus amount are less than 7000.");
        }

    }

}
