package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        FileManager.loadStudents(manager);

        System.out.println("========================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("========================================");

        boolean running = true;

        while (running) {

            displayMenu();

            int choice =
                    InputValidator.readInt(
                            scanner,
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    calculateGrade();
                    break;

                case 7:
                    sortStudents();
                    break;

                case 8:
                    FileManager.saveStudents(
                            manager.getStudents()
                    );
                    break;

                case 9:
                    FileManager.saveStudents(
                            manager.getStudents()
                    );

                    System.out.println(
                            "Thank you for using Student Management System."
                    );

                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Calculate Student Grade");
        System.out.println("7. Sort Students");
        System.out.println("8. Save Data");
        System.out.println("9. Exit");
        System.out.println("========================================");
    }

    private static void addStudent() {

        System.out.println("\n--- Add Student ---");

        int id = InputValidator.readInt(
                scanner,
                "Enter Student ID: "
        );

        if (manager.findStudentById(id) != null) {
            System.out.println(
                    "A student with this ID already exists."
            );
            return;
        }

        String name = InputValidator.readNonEmptyString(
                scanner,
                "Enter Name: "
        );

        int age = InputValidator.readInt(
                scanner,
                "Enter Age: "
        );

        if (age <= 0) {
            System.out.println("Age must be greater than zero.");
            return;
        }

        String course = InputValidator.readNonEmptyString(
                scanner,
                "Enter Course: "
        );

        String email = InputValidator.readNonEmptyString(
                scanner,
                "Enter Email: "
        );

        double marks = InputValidator.readMarks(
                scanner,
                "Enter Marks (0-100): "
        );

        Student student = new Student(
                id,
                name,
                age,
                course,
                email,
                marks
        );

        manager.addStudent(student);

        System.out.println(
                "Student added successfully."
        );
    }

    private static void searchStudent() {

        System.out.println("\n--- Search Student ---");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");

        int choice = InputValidator.readInt(
                scanner,
                "Enter choice: "
        );

        if (choice == 1) {

            int id = InputValidator.readInt(
                    scanner,
                    "Enter Student ID: "
            );

            Student student = manager.findStudentById(id);

            if (student != null) {
                student.displayPersonDetails();
            } else {
                System.out.println("Student not found.");
            }

        } else if (choice == 2) {

            String name = InputValidator.readNonEmptyString(
                    scanner,
                    "Enter student name: "
            );

            ArrayList<Student> results =
                    manager.searchByName(name);

            if (results.isEmpty()) {
                System.out.println("Student not found.");
            } else {

                for (Student student : results) {
                    student.displayPersonDetails();
                }
            }

        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void updateStudent() {

        System.out.println("\n--- Update Student ---");

        int id = InputValidator.readInt(
                scanner,
                "Enter Student ID: "
        );

        Student student = manager.findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println(
                "Current course: " + student.getCourse()
        );

        String course = InputValidator.readNonEmptyString(
                scanner,
                "Enter new Course: "
        );

        String email = InputValidator.readNonEmptyString(
                scanner,
                "Enter new Email: "
        );

        double marks = InputValidator.readMarks(
                scanner,
                "Enter new Marks (0-100): "
        );

        manager.updateStudent(
                id,
                course,
                email,
                marks
        );

        System.out.println(
                "Student updated successfully."
        );
    }

    private static void deleteStudent() {

        System.out.println("\n--- Delete Student ---");

        int id = InputValidator.readInt(
                scanner,
                "Enter Student ID: "
        );

        boolean deleted =
                manager.deleteStudent(id);

        if (deleted) {
            System.out.println(
                    "Student deleted successfully."
            );
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void calculateGrade() {

        System.out.println("\n--- Student Grade ---");

        int id = InputValidator.readInt(
                scanner,
                "Enter Student ID: "
        );

        Student student = manager.findStudentById(id);

        if (student != null) {

            System.out.println(
                    "Student Name : " + student.getName()
            );

            System.out.println(
                    "Marks        : " + student.getMarks()
            );

            System.out.println(
                    "Grade        : " + student.calculateGrade()
            );

        } else {
            System.out.println("Student not found.");
        }
    }

    private static void sortStudents() {

        System.out.println("\n--- Sort Students ---");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Marks (Highest First)");

        int choice = InputValidator.readInt(
                scanner,
                "Enter choice: "
        );

        if (choice == 1) {

            manager.sortByName();
            System.out.println(
                    "Students sorted by name."
            );
            manager.displayAllStudents();

        } else if (choice == 2) {

            manager.sortByMarksDescending();
            System.out.println(
                    "Students sorted by marks."
            );
            manager.displayAllStudents();

        } else {

            System.out.println("Invalid choice.");
        }
    }
}