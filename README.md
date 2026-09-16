# Student Management System

## Project Overview

The Student Management System is a Java-based command-line application developed to manage student records in a simple and organized way.

The system allows users to add, view, search, update, delete, and sort student records. It also provides grade calculation, input validation, and file-based data storage so that student information can be preserved between program executions.

The project demonstrates important concepts of Programming in Java, including:

- Object-Oriented Programming
- Classes and Objects
- Inheritance
- Encapsulation
- ArrayList
- Exception Handling
- File Handling
- Searching and Sorting
- Input Validation
- Modular Programming

The application runs completely through the command line and does not require a graphical user interface or external database.

---

## Features

### 1. Add Student

Allows the user to add a new student by entering:

- Student ID
- Student Name
- Age
- Course
- Email
- Marks

The system checks whether the Student ID already exists before adding the record.

### 2. View All Students

Displays all student records currently stored in the system.

The displayed information includes:

- Student ID
- Name
- Age
- Course
- Email
- Marks
- Grade

### 3. Search Student

Students can be searched using:

- Student ID
- Student Name

The system displays the matching student records.

### 4. Update Student

Allows the user to modify the information of an existing student.

The system first searches for the Student ID and then updates the required information.

### 5. Delete Student

Allows the user to remove an existing student record using the Student ID.

### 6. Grade Calculation

The system calculates a student's grade based on their marks.

| Marks | Grade |
|-------|-------|
| 90 - 100 | A+ |
| 80 - 89 | A |
| 70 - 79 | B |
| 60 - 69 | C |
| 50 - 59 | D |
| Below 50 | F |

### 7. Sort Students

The system provides sorting options for student records.

Students can be sorted based on:

- Name
- Marks

### 8. Input Validation

The application validates user input to prevent invalid data.

Examples include:

- Invalid integer input
- Invalid marks
- Empty input
- Invalid numeric values

### 9. File-Based Data Storage

Student records are stored in a text file so that the information can be loaded again when the application is started.

The project uses:

```text
data/students.txt
```

# Steps to Install and Run the Project

## 1. Prerequisites

Make sure the following are installed on your system:

- Java JDK 8 or above
- Git
- Command Prompt / PowerShell / Terminal

Check Java installation:

```bash
java -version
