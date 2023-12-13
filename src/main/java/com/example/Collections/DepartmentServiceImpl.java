package com.example.Collections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

@Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeService.getAllEmployees()) {
            if (employee.getDepartmentId() == departmentId) {
                employees.add(employee);
            }
        }
        return employees;
    }
    @Override
    public int getSalarySumByDepartmentId(int departmentId) {
        int sum = 0;
        for (Employee employee : employeeService.getAllEmployees()) {
            if (employee.getDepartmentId() == departmentId) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    @Override
    public int getMaxSalaryByDepartmentId(int departmentId) {
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : employeeService.getAllEmployees()) {
            if (employee.getDepartmentId() == departmentId && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }
    @Override
    public int getMinSalaryByDepartmentId(int departmentId) {
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employeeService.getAllEmployees()) {
            if (employee.getDepartmentId() == departmentId && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }
    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        Map<Integer, List<Employee>> employeesByDepartment = new HashMap<>();
        for (Employee employee : employeeService.getAllEmployees()) {
            int departmentId = employee.getDepartmentId();
            if (!employeesByDepartment.containsKey(departmentId)) {
                employeesByDepartment.put(departmentId, new ArrayList<>());
            }
            employeesByDepartment.get(departmentId).add(employee);
        }
        return employeesByDepartment;
    }
}