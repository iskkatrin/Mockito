package com.example.Collections;

import com.example.Collections.Exceptoin.EmployeeAlreadyAddedException;
import com.example.Collections.Exceptoin.EmployeeNotFoundException;
import com.example.Collections.Exceptoin.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee addEmployee(String fullName) {
        if (employees.contains(fullName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + fullName + " уже существует.");
        }
        Employee employee;
        if (employees.size() < MAX_EMPLOYEES) {
            employee = new Employee(fullName);
            employees.add(employee);
            System.out.println("Сотрудник добавлен: " + fullName);
        } else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
        return employee;
    }

    public Employee removeEmployee(String fullName) {
        Employee employee = new Employee(fullName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден: ");
        }
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String fullName) {
        Employee employee = new Employee(fullName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден: ");
        }
        return employee;
    }
}


