package com.example.Collections;

public class Employee {
    private String fullName;

    public Employee(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }


    @Override
    public String toString() {
        final String s = "Employee " +
                "fullName= ";
        return s;
    }

    public static void getAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }
}