package com.example.Collections;

import java.util.Objects;

public class Employee {
    private String fullName;

    public Employee(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
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

