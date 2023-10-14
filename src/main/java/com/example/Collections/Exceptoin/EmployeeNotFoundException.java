package com.example.Collections.Exceptoin;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super("Сотрудник не найден ");
    }
}