package com.example.Collections;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private EmployeeService employeeService = new EmployeeService();

    @Test
    void getAllEmployees() {
        employeeService.addEmployee("Kate Lar");
        employeeService.addEmployee("Inna Lar");
        employeeService.addEmployee("Marina Lar");

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(3, employees.size());

        boolean containsKateLar = false;
        boolean containsInnaLar = false;
        boolean containsMarinaLar = false;

        for (Employee employee : employees) {
            if (employee.getFullName().equals("Kate Lar")) {
                containsKateLar = true;
            } else if (employee.getFullName().equals("Inna Lar")) {
                containsInnaLar = true;
            } else if (employee.getFullName().equals("Marina Lar")) {
                containsMarinaLar = true;
            }
        }

        assertTrue(containsKateLar);
        assertTrue(containsInnaLar);
        assertTrue(containsMarinaLar);
    }

    @Test
    void addEmployee() {
        String newPeople = employeeService.addEmployee("Kate Lar");
        assertEquals("Сотрудник добавлен: Kate Lar", newPeople);

        String alreadyAdded = employeeService.addEmployee("Kate Lar");
        assertEquals("Ошибка: Сотрудник уже добавлен: John Doe", alreadyAdded);

        for (int i = 0; i < EmployeeService.MAX_EMPLOYEES - 1; i++) {
            employeeService.addEmployee("Employee " + i);
        }
        String almostFull = employeeService.addEmployee("Last Employee");
        assertEquals("Сотрудник добавлен: Last Employee", almostFull);

        String alreadyMax = employeeService.addEmployee();
        assertEquals("Ошибка: Максимальное количество сотрудников достигнуто", alreadyMax);
    }

    @Test
    void removeEmployee() {
        employeeService.addEmployee("Kate Lar");

        String removeExisting = employeeService.removeEmployee("Kate Lar");
        assertEquals("Сотрудник удален: John Doe", removeExisting);

        String removeNonExistent = employeeService.removeEmployee("Invalid Employee");
        assertEquals("Ошибка: Сотрудник не найден: Invalid Employee", removeNonExistent);
    }

    @Test
    void findEmployee() {
        employeeService.addEmployee("Kate Lar");
    }
}