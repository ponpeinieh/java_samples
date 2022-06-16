package com.example;

import java.util.List; 
import java.util.stream.Collectors;
public class ExtraSamplesImmutableStream {

    public static void main(String[] args) {
        List<Employee> data = Employee.createShortList();
        //data.stream().forEach(System.out::print);
        
        // Stream object is immutable, ie. it can not add/remove elements, or change the order of elements,
        // but elements inside stream are not immutable
        data.stream().forEach(e->e.setSurName(e.getSurName()+"___")); //will change the underlining elements
        //data.stream().peek(e->e.setSurName(e.getSurName()+"___")).collect(Collectors.toList()); //will change the underlining elements
        data.stream().forEach(System.out::print);
    }
}
