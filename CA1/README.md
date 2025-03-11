# devops-24-25-1241908

# CA1 - Version Control with Git

## Introduction
This guide provides step-by-step instructions on using Git for version control while developing a React.js and Spring Data REST application. The assignment is divided into two stages:
- **First Week**: Development without branches (all changes in `main`).
- **Second Week**: Development using branches for features and fixes.

By following these steps, you will learn how to manage a repository effectively, implement features, and handle bug fixes using Git and GitHub.

---

## Part 1: First Week (No Branches)
### Step 1: Copy the Application
To begin, copy the Tutorial React.js and Spring Data REST application basic folder into a new folder named `CA1/part1`. Use the following command:
```sh
cp -r path/to/tutorial-app CA1/part1
```

### Step 2: Initialize Git and Push the Code
Navigate to the `CA1/part1` directory, initialize Git, and push the initial version to the `main` branch:
```sh
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
1. Modify the Employee entity to include a new field, `jobYears`.
2. Ensure only integer values are accepted.
3. Implement unit tests to validate the new field.
4. Debug both the client and server parts of the application.
5. Commit the changes and tag the new version:
```sh
git add .
git commit -m "Added jobYears field with validation and tests"
git push origin main
git tag v1.2.0
git push origin v1.2.0
```

### Step 5: Finalize Part 1.1
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

