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
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // assert
        assertNotNull(employee);
        assertEquals("Antonio", employee.getFirstName());
        assertEquals("Silva", employee.getLastName());
        assertEquals("Student", employee.getDescription());
        assertEquals(1, employee.getJobYears());
    }

    @Test
    void shouldReturnNullEmployeeIfNameNull() {
        // arrange
        // act
        // assert
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Silva", "Student", 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNameEmpty() {
        // arrange
        // act
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("", "Silva", "Student", 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfNameEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee(" ", "Silva", "Student", 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsNull() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", null, "Student", 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsEmpty() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "", "Student", 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLastNameIsEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", " ", "Student", 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsNull() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", null, 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsEmpty() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", "", 1, "example@gmail.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfDescriptionIsEmptyWithWhitespace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", " ", 1, "example@gmail.com"));
    }

    @Test
    void shouldSetAndGetUpdatedFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        employee.setFirstName("João");
        // assert
        assertEquals("João", employee.getFirstName());
    }

    @Test
    void shouldSetAndGetUpdatedLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        employee.setLastName("Gouveia");
        // assert
        assertEquals("Gouveia", employee.getLastName());
    }

    @Test
    void shouldSetAndGetUpdatedDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        employee.setDescription("Director");
        // assert
        assertEquals("Director", employee.getDescription());
    }

    @Test
    void shouldSetAndGetUpdatedId() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        employee.setId(1L);
        // assert
        assertEquals(1L, employee.getId());
    }

    @Test
    void shouldReturnCorrectToStringRepresentation() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        employee.setId(1L);
        // act
        String expected = "Employee{id=1, firstName='Antonio', lastName='Silva', description='Student', jobYears=1, email='example@gmail.com'}";
        // assert
        assertEquals(expected, employee.toString());
    }


    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyFirstName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingFirstNameWithWhitespace() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setFirstName("   "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingWhitespaceOnlyLastName() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setLastName("   "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingNullDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setDescription(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setDescription(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmptyWithWhitespaceDescription() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setDescription("   "));
    }

    @Test
    void shouldReturnTrueIfEmployeesFieldsHasTheSameFields() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
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
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        boolean result = employee1.equals(employee1);
        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentIds(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
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
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("John", "Silva", "Student", 1, "example@gmail.com");
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentLastName(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Gouveia", "Student", 1, "example@gmail.com");
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentDescription(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Director", 1, "example@gmail.com");
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentJobYears(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "first.last@domain.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 2, "first.last@domain.com");
        // act & assert
        assertFalse(employee1.equals(employee2));
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeesWithDifferentEmail(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Director", 2, "test@gmail.com");
        // act
        boolean result = employee1.equals(employee2);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeeWithNullValue(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        boolean result = employee1.equals(null);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenComparingEmployeeWithDifferentClass() {
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        String notAnEmployee = "This is a string, not an Employee";
        // act
        boolean result = employee.equals(notAnEmployee);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldGenerateSameHashCodeWhenEmployeeIsTheSame(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodeWhenFirstNameDiffer(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("John", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodesWhenIDsDiffer() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        employee1.setId(1L);
        employee2.setId(2L);
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodesWhenLastNameDiffer() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Gouveia", "Student", 1, "example@gmail.com");
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldGenerateDifferentHashCodesWhenDescriptionDiffer() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Director", 1, "example@gmail.com");
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldCreateEmployeeWithZeroJobYears(){
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 0, "example@gmail.com");
        // act & assert
        assertNotNull(employee);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenJobYearsNegative() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Antonio", "Silva", "Student", -1, "example@gmail.com"));
    }

    @Test
    void shouldSetAndGetUpdatedJobYears(){
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        employee.setJobYears(2);
        // assert
        assertEquals(2, employee.getJobYears());
    }

    @Test
    void shouldGenerateDifferentHashCodesWhenJobYearsDiffer() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        Employee employee2 = new Employee("Antonio", "Silva", "Student", 2, "example@gmail.com");
        // act & assert
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingJobYearsLesserThanZero() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> employee1.setJobYears(-1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfEmailNull() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Antonio", "Silva", "Student", 1, null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfEmailEmpty() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Antonio", "Silva", "Student", 1, ""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfEmailEmptyWithWhiteSpace() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Antonio", "Silva", "Student", 1, " "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfEmail(){
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Antonio", "Silva", "Student", 1, " "));
    }

    @Test
    void shouldReturnEmailFromEmployee() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        String email = employee1.getEmail();
        // assert
        assertEquals("example@gmail.com", email);
    }

    @Test
    void shouldSetAndGetUpdatedEmail(){
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act
        employee1.setEmail("test@gmail.com");
        // assert
        assertEquals("test@gmail.com", employee1.getEmail());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmailNull() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> employee1.setEmail(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmailEmpty() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> employee1.setEmail(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmailEmptyWithWhiteSpace() {
        // arrange
        Employee employee1 = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> employee1.setEmail(" "));
    }

    @Test
    void shouldThrowIllegalArgumentWhenEmailWithoutAtSign() {
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", "Student", 1, "example.com"));
    }

    @Test
    void shouldThrowIllegalArgumentWhenEmailWithAtSignInBeginning() {
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", "Student", 1, "@example.com"));
    }

    @Test
    void shouldThrowIllegalArgumentWhenEmailWithAtSignAtEnd() {
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", "Student", 1, "example.com@"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmailWithoutAtSign(){
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setEmail("example.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmailWithAtSignInBeginning(){
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setEmail("@example.com"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSettingEmailWithAtSignAtEnd(){
        // arrange
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "example@gmail.com");
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> employee.setEmail("example.com@"));
    }

    @Test
    void shouldThrowIllegalArgumentWhenEmailHasNoTLD() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", "Student", 1, "example@domain"));
    }

    @Test
    void shouldThrowIllegalArgumentWhenEmailHasInvalidCharacters() {
        // arrange
        // act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Antonio", "Silva", "Student", 1, "example#@domain.com"));
    }

    @Test
    void shouldAcceptValidEmailWithSubdomain() {
        // arrange
        // act
        Employee employee = new Employee("Antonio", "Silva", "artilheiro", 1, "example@sub.domain.com");
        // assert
        assertEquals("example@sub.domain.com", employee.getEmail());
    }

    @Test
    void shouldAcceptValidEmailWithDotInLocalPart() {
        Employee employee = new Employee("Antonio", "Silva", "Student", 1, "first.last@domain.com");
        assertEquals("first.last@domain.com", employee.getEmail());
    }
}