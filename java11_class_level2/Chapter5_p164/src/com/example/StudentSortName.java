package com.example;

import java.util.Comparator;
//按照name由小到大排序
public class StudentSortName implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        int result = s1.getName().compareTo(s2.getName());
        if (result != 0) { return result; }
        else { 
            return 0;  // Or do more comparing
        } 
    }
}
