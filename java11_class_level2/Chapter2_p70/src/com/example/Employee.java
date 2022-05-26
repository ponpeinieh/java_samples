/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

public class Employee {

    public enum Department {
        //HR, OPERATIONS, LEGAL, MARKETING
        HR("DEPT-01"), OPERATIONS("DEPT-02"), LEGAL("DEPT-03"), MARKETING("DEPT-04"); //semicolon is required here

        Department(String deptCode) {
            this.deptCode = deptCode;
        }

        private String deptCode;

        public String getDeptCode() {
            return deptCode;
        }
    }

    public static void main(String args[]) {
        Department dept1 = Department.HR;
        //Department dept2 = Department.IT; compiler error
    }

}
