package com.example.collections.service;

import com.example.collections.exceptoin.EmployeeAlreadyAddedException;
import com.example.collections.exceptoin.EmployeeNotFoundException;
import com.example.collections.exceptoin.EmployeeStorageIsFullException;
import com.example.collections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    public static int MAX_EMPLOYEES = 10;
    private Map<String, Employee> employees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Employee addEmployee(Employee employee) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Максимальное количество сотрудников достигнуто");
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен: " + employee.getFullName());
        }

        employees.put(employee.getFullName(), employee);

        return employee;
    }


    public String removeEmployee(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Сотрудник не найден: " + fullName);
        }

        employees.remove(fullName);

        return "Сотрудник удален: " + fullName;
    }

    public Employee findEmployee(String fullName) {
        for (Employee employee : employees.values()) {
            if (employee.getFullName().equals(fullName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}