package com.example.Collections;

import com.example.Collections.Exceptoin.EmployeeAlreadyAddedException;
import com.example.Collections.Exceptoin.EmployeeNotFoundException;
import com.example.Collections.Exceptoin.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private Map<String, Employee> employees;

    public EmployeeService() {
        employees = new HashMap<>();
    }

    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

    public String addEmployee(String fullName) {
        try {
            if (employees.size() >= MAX_EMPLOYEES) {
                throw new EmployeeStorageIsFullException("Максимальное количество сотрудников достигнуто");
            }

            Employee employee = new Employee(fullName);

            if (employees.containsKey(employee.getFullName())) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен: " + fullName);
            }

            employees.put(employee.getFullName(), employee);

            return "Сотрудник добавлен: " + fullName;
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            return "Ошибка: " + e.getMessage();
        }
    }


    public Employee removeEmployee(String fullName) {
        Employee employee = new Employee(fullName);
        if (!employees.containsKey(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден: " + fullName);
        }
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String fullName) {
        Employee employee = new Employee(fullName);
        if (!employees.containsKey(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден: " + fullName);
        }
        return employee;
    }
}


