package com.example.Collections;

import com.example.Collections.Exceptoin.EmployeeAlreadyAddedException;
import com.example.Collections.Exceptoin.EmployeeNotFoundException;
import com.example.Collections.Exceptoin.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/employee/add")
    public void addEmployee(String fullName) {
        if (employees.contains(fullName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + fullName + " уже существует.");
        }
        if (employees.size() < MAX_EMPLOYEES) {
            Employee employee = new Employee(fullName);
            employees.add(employee);
            System.out.println("Сотрудник добавлен: " + fullName);
        } else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
    }

    @GetMapping("/employee/remove")
    public void removeEmployee(String fullName) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employees.remove(employee);
                System.out.println("Сотрудник удален: " + fullName);
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден: ");
    }

    @GetMapping("/employee/find")
    public void findEmployee(String fullName) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                throw new EmployeeNotFoundException("Сотрудник не найден: ");
            }
        }
        System.out.println("Сотрудник не найден: " + fullName);
    }
}
