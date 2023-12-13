package com.example.collections.service;

import com.example.collections.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.example.collections.service.TestUtils.getEmployee;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final static List<Employee> EMPLOYEES = Arrays.asList(
            getEmployee("TEST1", 10, 1),
            getEmployee("TEST2", 20, 2),
            getEmployee("TEST3", 30, 3)

    );

    @Test
    void getEmployeesByDepartmentIdTest(){
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);

        assertEquals(1, departmentService.getEmployeesByDepartmentId(1).size());
    }

    @Test
    void getSalarySumByDepartmentIdTest(){
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);

        assertEquals(20, departmentService.getSalarySumByDepartmentId(2));
    }

    @Test
    void getMaxSalaryByDepartmentId() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);

        assertEquals(30, departmentService.getMaxSalaryByDepartmentId(3));
    }

    @Test
    void getMinSalaryByDepartmentId() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);

        assertEquals(30, departmentService.getMinSalaryByDepartmentId(3));
    }

    @Test
    void getAllEmployeesByDepartment() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES);

        assertEquals(3, departmentService.getAllEmployeesByDepartment().size());
    }
}