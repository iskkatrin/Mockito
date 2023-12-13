package com.example.collections;

import com.example.collections.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class CollectionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionsApplication.class, args);
    }

    public static interface DepartmentService {
        List<Employee> getEmployeesByDepartmentId(int departmentId);

        int getSalarySumByDepartmentId(int departmentId);

        int getMaxSalaryByDepartmentId(int departmentId);

        int getMinSalaryByDepartmentId(int departmentId);

        Map<Integer, List<Employee>> getAllEmployeesByDepartment();
    }
}
