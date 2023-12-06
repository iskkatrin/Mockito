package com.example.Collections;

import java.util.Objects;

public class Employee {
    private String fullName;
    private int departmentId;
    private int salary;

    public Employee(String fullName) {
        this.fullName = fullName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(fullName, employee.fullName);
        }

        @Override
        public int hashCode () {
            return Objects.hash(fullName);
        }

}

