package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class P294_CollectPartition {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        Map<Boolean, List<Employee>> gMap = new HashMap<>();

        // Collect CO Executives
        gMap = eList.stream()
                .collect(
                        Collectors.partitioningBy(
                                e -> e.getRole().equals(Role.EXECUTIVE)));

        gMap.forEach((k, v) -> {
            System.out.println("\nGroup: " + k);
            v.forEach(Employee::printSummary);
        });

    }

}
