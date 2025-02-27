package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeTest {

    @Test
    void shouldCreateEmployeeWithDefaultConstructor() {
        // arrange
        // act
        Employee employee = new Employee();
        // assert
        assertNotNull(employee);
    }

    @Test
    void shouldReturnValidObjectEmployeeWithAllFields() {
        // arrange
        // act
        Employee employee = new Employee("Gonçalo", "Silva", "Student");
        // assert
        assertNotNull(employee);
        assertEquals("Gonçalo", employee.getFirstName());
        assertEquals("Silva", employee.getLastName());
        assertEquals("Student", employee.getDescription());
    }

    @Test
    void shouldReturnNullNotCreateEmployeeIfNameNull() {
        // arrange
        // act
        Employee employee = new Employee(null, "Silva", "Student");
        // assert
        assertNull(employee);
    }
}