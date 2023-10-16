package com.example.Collections;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/employee")
@RestController

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String fullName) {
        return employeeService.addEmployee(fullName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String fullName) {
        return employeeService.removeEmployee(fullName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String fullName) {
        return employeeService.findEmployee(fullName);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
