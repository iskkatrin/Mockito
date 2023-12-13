package com.example.Collections;

import com.example.Collections.Exceptoin.EmployeeAlreadyAddedException;
import com.example.Collections.Exceptoin.EmployeeNotFoundException;
import com.example.Collections.Exceptoin.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeService {
    private static int MAX_EMPLOYEES = 10;
    private Map<String, Employee> employees;

    public EmployeeService() {
        employees = new HashMap<>();
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
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


    public String removeEmployee(String fullName) {
        try {
            if (!employees.containsKey(fullName)) {
                throw new EmployeeNotFoundException("Сотрудник не найден: " + fullName);
            }

            employees.remove(fullName);

            return "Сотрудник удален: " + fullName;
        } catch (EmployeeNotFoundException e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    public void findEmployee(String fullName) {
        for (Employee employee : employees.values())
            if (employee.getFullName().equals(fullName)) {
                throw new EmployeeNotFoundException("Сотрудник не найден: ");
            }
        System.out.println("Сотрудник не найден: " + fullName);
    }
}