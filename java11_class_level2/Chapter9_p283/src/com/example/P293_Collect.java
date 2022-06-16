package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class P293_Collect {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        List<Employee> nList = new ArrayList<>();

        // Collect CO Executives
        nList = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .sorted(Comparator.comparing(Employee::getSurName))
                .collect(Collectors.toList());

        System.out.println("\n== CO Bonus Details ==");

        nList.stream()
                .forEach(Employee::printSummary);

        //
        Map<String, String> gMap = new HashMap<>();

        // Collect eMails and depts to a map
        gMap = eList.stream()
                .collect(Collectors.toMap(Employee::getEmail,
                        e -> e.getDept()));

        System.out.println("\n== Emails and depts ==");
        gMap.forEach((k, v) -> {
            System.out.println("Email: " + k + " DeptName: " + v);
        });
    }

}
