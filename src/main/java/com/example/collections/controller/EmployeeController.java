package com.example.collections.controller;


import com.example.collections.service.EmployeeService;
import com.example.collections.exceptoin.EmployeeNotFoundException;
import com.example.collections.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/employee")
@RestController

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Employee addEmployee(@RequestParam String name, @RequestParam Integer salary, @RequestParam Integer dep) {
        return employeeService.addEmployee(new Employee(name, salary, dep));
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String fullName) {
        try {
            employeeService.removeEmployee(fullName);
            return "Сотрудник удален: " + fullName;
        } catch (EmployeeNotFoundException e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam String fullName) {
        try {
            Employee employee = employeeService.findEmployee(fullName);
            return "Сотрудник найден: " + employee.getFullName();
        } catch (EmployeeNotFoundException e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeService.getAllEmployees());
    }
}