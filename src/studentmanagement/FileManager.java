package studentmanagement;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_PATH = "data/students.txt";

    public static void saveStudents(ArrayList<Student> students) {

        File file = new File("data");

        if (!file.exists()) {
            file.mkdir();
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Student student : students) {
                writer.write(student.toFileString());
                writer.newLine();
            }

            System.out.println("Student data saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error while saving data: " + e.getMessage()
            );
        }
    }

    public static void loadStudents(StudentManager manager) {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 6) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];
                    String email = data[4];
                    double marks = Double.parseDouble(data[5]);

                    Student student = new Student(
                            id,
                            name,
                            age,
                            course,
                            email,
                            marks
                    );

                    manager.addStudent(student);
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error while loading data: " + e.getMessage()
            );
        }
    }
}