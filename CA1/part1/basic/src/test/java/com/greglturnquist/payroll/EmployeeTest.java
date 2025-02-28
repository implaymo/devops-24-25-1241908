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
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // assert
        assertNotNull(employee);
        assertEquals("Antonio", employee.getFirstName());
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

    @Test
    void shouldReturnCorrectToStringRepresentation() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        employee.setId(1L);
        // act
        String expected = "Employee{id=1, firstName='Antonio', lastName='Silva', description='Student'}";
        // assert
        assertEquals(expected, employee.toString());
    }


    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingFirstNameWithWhitespace() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName("   "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingWhitespaceOnlyLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName("   "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setDescription(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setDescription(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyWithWhitespaceDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName("   "));
    }

    @Test
    void shouldReturnTrueIfEmployeesFieldsHasTheSameFields() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student");
        Employee employee2 = new Employee("Antonio", "Silva", "Student");
        employee1.setId(1L);
        employee2.setId(1L);
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnWhenComparingTheSameEmployee(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student");
        // act
        boolean result = employee1.equals(employee1);
        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentIds(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student");
        Employee employee2 = new Employee("Antonio", "Silva", "Student");
        employee1.setId(1L);
        employee2.setId(2L);
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

}