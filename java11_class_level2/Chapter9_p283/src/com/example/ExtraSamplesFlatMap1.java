package com.example;

import java.util.List;

public class ExtraSamplesFlatMap1 {

    public static void main(String[] args) {
        // Every employee has a list of skills, so supposed we want to get a distinct list of all 
        // the skills among our employees, we can use flatMap:
        List<Employee> eList = Employee.createShortList();
        //eList.stream().map(e->e.getSkills()).forEach(System.out::println);
        //eList.stream().map(e-> e.getSkills().stream()).forEach(System.out::println);
        eList.stream().flatMap(e -> e.getSkills().stream()).distinct().forEach(System.out::println);
    }

}
