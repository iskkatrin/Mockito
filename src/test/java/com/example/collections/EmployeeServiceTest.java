package com.example.collections;

import com.example.collections.exceptoin.EmployeeAlreadyAddedException;
import com.example.collections.model.Employee;
import com.example.collections.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.collections.service.TestUtils.getEmployee;
import static org.junit.jupiter.api.Assertions.*;
class EmployeeServiceTest {

    private EmployeeService employeeService = new EmployeeService();

    private final static List<Employee> EMPLOYEES = Arrays.asList(
            getEmployee("TEST1", 10, 1),
            getEmployee("TEST2", 20, 2),
            getEmployee("TEST3", 30, 3)
    );

    @BeforeEach
    void setup() {
        employeeService.getEmployees().clear();
    }

    @Test
    void getAllEmployees() {
        EMPLOYEES.forEach(employee -> employeeService.addEmployee(employee));

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(3, employees.size());
        EMPLOYEES.forEach(employee -> assertTrue(employees.contains(employee)));
    }

    @Test
    void addEmployee() {
        assertEquals(0, employeeService.getAllEmployees().size());
        employeeService.addEmployee(EMPLOYEES.get(0));
        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    void addEmployeeAlreadyExists(){
        assertEquals(0, employeeService.getAllEmployees().size());
        employeeService.addEmployee(EMPLOYEES.get(0));
        assertEquals(1, employeeService.getAllEmployees().size());
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee(EMPLOYEES.get(0)));
    }

    @Test
    void removeEmployee() {
        employeeService.addEmployee(EMPLOYEES.get(0));

        String removeExisting = employeeService.removeEmployee(EMPLOYEES.get(0).getFullName());
        assertEquals("Сотрудник удален: TEST1", removeExisting);
    }

    @Test
    void findEmployee() {
        employeeService.addEmployee(EMPLOYEES.get(0));
        Employee employee = employeeService.findEmployee(EMPLOYEES.get(0).getFullName());
        assertEquals(EMPLOYEES.get(0), employee);
    }

}