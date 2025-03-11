
# Version Control with Git

## Introduction
This guide provides step-by-step instructions on using Git for version control while developing a React.js and Spring Data REST application. The assignment is divided into two stages:
- **First Week**: Development without branches (all changes in `main`).
- **Second Week**: Development using branches for features and fixes.

By following these steps, you will learn how to manage a repository effectively, implement features, and handle bug fixes using Git and GitHub.

---

## Part 1: First Week (No Branches)
### Step 1: Copy the Application
To begin, copy the [Tutorial React.js and Spring Data REST application](https://github.com/spring-attic/tut-react-and-spring-data-rest/tree/master/basic) pom.xml file and basic folder into a new folder named CA1/part1. Use the following command:
```sh
cp -r path/to/tutorial-app CA1/part1
```

### Step 2: Initialize Git and Push the Code
Navigate to your project directory, initialize Git, and push the initial version to the `main` branch:
```sh
git init
git add .
git commit -m "Initial commit of tutorial application"
git push origin main
```

### Step 3: Tag the Initial Version
To mark the initial version of your application, create and push a Git tag:
```sh
git tag v1.1.0
git push origin v1.1.0
```

### Step 4: Add a New Feature (jobYears Field)

#### 1: Modify the Employee Entity to Include a New Field, `jobYears`
1. Open the `Employee.java` file located in `CA1/part1/basic/src/main/java/com/greglturnquist/payroll/`.
2. Add a new field `jobYears` of type `int` to the `Employee` class.
3. Update the constructor to include the new field.
4. Add getter and setter methods for the `jobYears` field.
5. Add validation to ensure only integer values are accepted.

```java
// Add the new field
private int jobYears;

// Update the constructor
public Employee(String firstName, String lastName, String description, int jobYears, String email) {
    if(!isFirstNameValid(firstName)) {
        throw new IllegalArgumentException("First name can't be null or empty.");
    }
    if(!isLastNameValid(lastName)) {
        throw new IllegalArgumentException("Last name can't be null or empty.");
    }
    if(!isDescriptionValid(description)) {
        throw new IllegalArgumentException("Description can't be null or empty.");
    }
    if(!isJobYearsValid(jobYears)) {
        throw new IllegalArgumentException("Job years can't be negative.");
    }
    if(!isEmailValid(email)) {
        throw new IllegalArgumentException("Email can't be null or empty.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
    this.jobYears = jobYears;
    this.email = email;
}

// Add getter and setter methods
public int getJobYears() {
    return jobYears;
}

public void setJobYears(int jobYears) {
    if(!isJobYearsValid(jobYears)) {
        throw new IllegalArgumentException("Job years can't be negative.");
    }
    this.jobYears = jobYears;
}

// Add validation method
private boolean isJobYearsValid(int jobYears) {
    return jobYears >= 0;
}
```

#### Step 2: Implement Unit Tests to Validate the New Field
1. Open or create the test file for the Employee class, typically located in src/test/java/com/greglturnquist/payroll/.
2. Write unit tests to validate the jobYears field.
- #### Example of the tests implemented:
```sh
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
}
```
#### Step 3: Update the DatabaseLoader
1. Open the DatabaseLoader.java file located in CA1/part1/basic/src/main/java/com/greglturnquist/payroll/.
2. Update the run method to include the jobYears field when creating a new Employee.
```sh
@Override
public void run(String... strings) throws Exception {
    this.repository.save(new Employee("Frodo", "Baggins", "ring bearer", 1));
}
```
#### Step 4: Update React Components
##### Update the EmployeeList and Employee Components in app.js
1. Open the app.js file located in CA1/part1/basic/src/main/js/.
2. Update the EmployeeList component to include the jobYears field in the table header and rows.
```sh
class EmployeeList extends React.Component {
    render() {
        const employees = this.props.employees.map(employee =>
            <Employee key={employee._links.self.href} employee={employee}/>
        );
        return (
            <table>
                <tbody>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Description</th>
                        <th>Job Years</th>
                    </tr>
                    {employees}
                </tbody>
            </table>
        )
    }
}
```
3. Update the Employee component to display the jobYears field.
```sh
class Employee extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.employee.firstName}</td>
                <td>{this.props.employee.lastName}</td>
                <td>{this.props.employee.description}</td>
                <td>{this.props.employee.jobYears}</td>
            </tr>
        )
    }
}
```

#### Step 5: Commit the Changes and Tag the New Version:
```sh
git add .
git commit -m "Added jobYears field with validation and tests"
git push origin main
git tag v1.2.0
git push origin v1.2.0
```

### Step 6: Finalize Part 1.1
To mark the completion of Part 1.1, create a final tag:
```sh
git tag ca1-part1.1
git push origin ca1-part1.1
```

---

## Part 1: Second Week (Using Branches)
### Step 1: Maintain the Main Branch for Stable Versions
Ensure that the `main` branch is used only for stable versions.

### Step 2: Create a Feature Branch for Adding an Email Field
1. **Create a new branch** on GitHub named `email-field`.
2. **Make changes** to add an `email` field to the Employee entity and implement validation.
3. **Push changes** to the branch:
```sh
git add .
git commit -m "Added email field with validation and tests"
git push origin email-field
```
4. **Open a Pull Request** on GitHub and merge the branch into `main`.
5. **Tag the new version** after merging:
```sh
git tag v1.3.0
git push origin v1.3.0
```

### Step 3: Create a Bug Fix Branch for Email Validation
1. **Create a new branch** on GitHub named `fix-invalid-email`.
2. **Implement validation** to ensure that employee emails contain the `@` sign.
3. **Push changes** to the branch:
```sh
git add .
git commit -m "Added validation for email format"
git push origin fix-invalid-email
```
4. **Open a Pull Request** on GitHub and merge the branch into `main`.
5. **Tag the updated version**:
```sh
git tag v1.3.1
git push origin v1.3.1
```

### Step 4: Finalize Part 1.2
To mark the completion of Part 1.2, create a final tag:
```sh
git tag ca1-part1.2
git push origin ca1-part1.2
```

---

## Analysis of Alternatives
Different Git workflows were considered:
- **Centralized Workflow (Used in Week 1)**: Simple but lacks structured collaboration.
- **Feature Branch Workflow (Used in Week 2)**: Allows isolated feature development and easier debugging.
- **Gitflow Workflow**: More complex but better suited for large projects with long-term maintenance needs.

The **Feature Branch Workflow** was chosen as it balances simplicity and collaboration.

---

## Conclusion
By following this tutorial, you will learn best practices for version control, including:
- Initializing repositories and committing changes.
- Using tags for version management.
- Creating and merging branches for features and fixes via GitHub pull requests.
- Implementing structured workflows for collaborative development.

This structured approach ensures efficient version control in a professional software development environment.

