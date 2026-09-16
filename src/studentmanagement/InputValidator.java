package studentmanagement;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(Scanner scanner, String message) {

        while (true) {

            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public static double readDouble(Scanner scanner, String message) {

        while (true) {

            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static String readNonEmptyString(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    public static double readMarks(
            Scanner scanner, String message) {

        while (true) {

            double marks = readDouble(scanner, message);

            if (marks >= 0 && marks <= 100) {
                return marks;
            }

            System.out.println(
                    "Marks must be between 0 and 100."
            );
        }
    }
}