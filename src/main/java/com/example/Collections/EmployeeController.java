package com.example.Collections;


import com.example.Collections.Exceptoin.EmployeeAlreadyAddedException;
import com.example.Collections.Exceptoin.EmployeeNotFoundException;
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

    public String addEmployee(@RequestParam String fullName) {
        try {
            employeeService.addEmployee(fullName);
            return "Сотрудник добавлен: " + fullName;
        } catch (EmployeeAlreadyAddedException e) {
            return "Ошибка: " + e.getMessage();
        }
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
        return new ArrayList<>(employeeService.getAllEmployees().values());
    }
}