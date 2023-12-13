package com.example.collections.controller;

import com.example.collections.model.Employee;
import com.example.collections.service.DepartmentService;
import com.example.collections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private EmployeeService employeeService;

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private boolean departmentExists(int departmentId) {
        return true; //
    }

    @GetMapping("/departments/max-salary")
    public Integer getMaxSalaryByDepartmentId(@RequestParam("departmentId") int departmentId) {
        if (departmentExists(departmentId)) {
            return departmentService.getMaxSalaryByDepartmentId(departmentId);
        }
        return null;
    }

    @GetMapping("/departments/min-salary")
    public Integer getEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") int departmentId) {
        if (departmentExists(departmentId)) {
            return departmentService.getMinSalaryByDepartmentId(departmentId);
        }
        return null;
    }

    @GetMapping("/departments")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployeesByDepartment();
    }

    @GetMapping("/department/{id}/employees")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable int id) {
        List<Employee> employees = departmentService.getEmployeesByDepartmentId(id);
        return employees;
    }
}

