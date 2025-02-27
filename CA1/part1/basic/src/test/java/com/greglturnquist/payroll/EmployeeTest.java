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
    void shouldReturnNullEmployeeIfNameNull() {
        // arrange
        // act
        // assert
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Silva", "Student"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNameEmpty() {
        // arrange
        // act
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("", "Silva", "Student"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNameEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee(" ", "Silva", "Student"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsNull() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", null, "Student"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsEmpty() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "", "Student"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", " ", "Student"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsNull() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsEmpty() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", ""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", " "));
    }

    @Test
    void shouldSetAndGetUpdatedFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act
        employee.setFirstName("João");
        // assert
        assertEquals("João", employee.getFirstName());
    }

    @Test
    void shouldSetAndGetUpdatedLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act
        employee.setLastName("Gouveia");
        // assert
        assertEquals("Gouveia", employee.getLastName());
    }

    @Test
    void shouldSetAndGetUpdatedDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act
        employee.setDescription("Director");
        // assert
        assertEquals("Director", employee.getDescription());
    }

    @Test
    void shouldSetAndGetUpdatedId() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act
        employee.setId(1L);
        // assert
        assertEquals(1L, employee.getId());
    }

}