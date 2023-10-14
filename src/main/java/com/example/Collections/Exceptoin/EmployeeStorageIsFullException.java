package com.example.Collections.Exceptoin;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {
        super("Превышен лимит количества сотрудников в фирме");
    }
}
