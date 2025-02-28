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
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // assert
        assertNotNull(employee);
        assertEquals("Antonio", employee.getFirstName());
        assertEquals("Silva", employee.getLastName());
        assertEquals("Student", employee.getDescription());
        assertEquals("1", employee.getJobYears());
    }

    @Test
    void shouldReturnNullEmployeeIfNameNull() {
        // arrange
        // act
        // assert
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Silva", "Student", 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNameEmpty() {
        // arrange
        // act
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("", "Silva", "Student", 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNameEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee(" ", "Silva", "Student", 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsNull() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", null, "Student", 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsEmpty() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "", "Student", 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", " ", "Student", 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsNull() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", null, 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsEmpty() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", "", 1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", " ", 1));
    }

    @Test
    void shouldSetAndGetUpdatedFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act
        employee.setFirstName("João");
        // assert
        assertEquals("João", employee.getFirstName());
    }

    @Test
    void shouldSetAndGetUpdatedLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act
        employee.setLastName("Gouveia");
        // assert
        assertEquals("Gouveia", employee.getLastName());
    }

    @Test
    void shouldSetAndGetUpdatedDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act
        employee.setDescription("Director");
        // assert
        assertEquals("Director", employee.getDescription());
    }

    @Test
    void shouldSetAndGetUpdatedId() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act
        employee.setId(1L);
        // assert
        assertEquals(1L, employee.getId());
    }

    @Test
    void shouldReturnCorrectToStringRepresentation() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        employee.setId(1L);
        // act
        String expected = "Employee{id=1, firstName='Antonio', lastName='Silva', description='Student', jobYears=1}";
        // assert
        assertEquals(expected, employee.toString());
    }


    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingFirstNameWithWhitespace() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName("   "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingWhitespaceOnlyLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName("   "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setDescription(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setDescription(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyWithWhitespaceDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName("   "));
    }

    @Test
    void shouldReturnTrueIfEmployeesFieldsHasTheSameFields() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1);
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
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        // act
        boolean result = employee1.equals(employee1);
        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentIds(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1);
        employee1.setId(1L);
        employee2.setId(2L);
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentFirstName(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("John", "Silva", "Student", 1);
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentLastName(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Gouveia", "Student", 1);
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentDescription(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Silva", "Director", 1);
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeeWithNullValue(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        // act
        boolean result = employee1.equals(null);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeeWithDifferentClass() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1);
        String notAnEmployee = "This is a string, not an Employee";
        // act
        boolean result = employee.equals(notAnEmployee);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldGenerateSameHashCodeWhenEmployeeIsTheSame(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1);
        // act & assert
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodeWhenFirstNameDiffer(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("John", "Silva", "Student", 1);
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodesWhenIDsDiffer() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1);
        employee1.setId(1L);
        employee2.setId(2L);
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodesWhenLastNameDiffer() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Gouveia", "Student", 1);
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodesWhenDescriptionDiffer() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1);
        Employee employee2 = new Employee("Antonio", "Silva", "Director", 1);
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

}