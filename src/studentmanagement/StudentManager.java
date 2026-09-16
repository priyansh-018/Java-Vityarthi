package studentmanagement;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {

        if (findStudentById(student.getStudentId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student findStudentById(int id) {

        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }

        return null;
    }

    public ArrayList<Student> searchByName(String name) {

        ArrayList<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().toLowerCase()
                    .contains(name.toLowerCase())) {

                result.add(student);
            }
        }

        return result;
    }

    public boolean deleteStudent(int id) {

        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    public boolean updateStudent(int id, String course,
                                 String email, double marks) {

        Student student = findStudentById(id);

        if (student != null) {
            student.setCourse(course);
            student.setEmail(email);
            student.setMarks(marks);
            return true;
        }

        return false;
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public void sortByMarksDescending() {
        students.sort(
                Comparator.comparingDouble(Student::getMarks).reversed()
        );
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayPersonDetails();
        }
    }
}