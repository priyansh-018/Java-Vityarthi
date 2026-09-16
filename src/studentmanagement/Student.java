package studentmanagement;

public class Student extends Person {

    private int studentId;
    private String course;
    private String email;
    private double marks;

    public Student(int studentId, String name, int age,
                   String course, String email, double marks) {

        super(name, age);
        this.studentId = studentId;
        this.course = course;
        this.email = email;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }

    public double getMarks() {
        return marks;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public void displayPersonDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + getName());
        System.out.println("Age        : " + getAge());
        System.out.println("Course     : " + course);
        System.out.println("Email      : " + email);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("----------------------------------------");
    }

    public String toFileString() {
        return studentId + "|" +
                getName() + "|" +
                getAge() + "|" +
                course + "|" +
                email + "|" +
                marks;
    }
}