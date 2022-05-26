package com.example;

import java.util.Objects;

public class Employee extends Object {

    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    /*
    @Override
    public String toString() {
        //return "Employee{" + "empId=" + empId + ", name=" + name + ", ssn=" + ssn + ", salary=" + salary + '}';
        return this.getClass().getName() + "{" + "empId=" + empId + ", name=" + name + ", ssn=" + ssn + ", salary=" + salary + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.empId;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.ssn);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.empId != other.empId) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.ssn, other.ssn);
    }
     */
    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public double getSalary() {
        return salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void changeName(String newName) {
        if (newName != null) {
            this.name = newName;
        }
    }

    public void raiseSalary(double increase) {
        this.salary += increase;
    }
}
