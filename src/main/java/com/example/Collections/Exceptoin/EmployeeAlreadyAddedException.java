package com.example.Collections.Exceptoin;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super("Уже есть такой сотрудник ");
    }
}