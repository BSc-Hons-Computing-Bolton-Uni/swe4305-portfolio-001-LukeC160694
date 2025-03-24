package Logbook.Week2;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * This program contains the Work for the tasks associated with Week 2 of the logbook.
 */
public class Week2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = LocalDate.now().getYear();

        /** Write a continued program from week 1
         * to check the age of the user and return a message saying
         * if they are 18 or over.
         */
        System.out.println("Program 1: Age Check");
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        int birthYear = currentYear - age;
        System.out.println("You were born in: " + birthYear);
        System.out.println(age >= 18 ? "You are an adult." : "You are under 18.");
        System.out.println("\n-------------------------");

        /**
         * Write a program for the user to enter their grade and
         * have the program output the University classification
         * for the grade entered.
         */
        scanner.nextLine(); // Consume newline
        System.out.println("Program 2: Grade Classification");
        System.out.print("Enter your letter grade (A, B, C, D, E, F): ");
        char grade = scanner.next().toUpperCase().charAt(0);
        switch (grade) {
            case 'A' -> System.out.println("Classification: 1st");
            case 'B' -> System.out.println("Classification: 2:1");
            case 'C' -> System.out.println("Classification: 2:2");
            case 'D' -> System.out.println("Classification: 3rd");
            case 'E' -> System.out.println("Classification: Ordinary");
            case 'F' -> System.out.println("Classification: Fail");
            default -> System.out.println("Invalid grade entered.");
        }
        System.out.println("\n-------------------------");

        /**
         * Write a program that outputs the digits from 0-9 using a loop
         */
        System.out.println("Program 3: Digits from 0 to 9");
        for (int i = 0; i <= 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n-------------------------");

        /**
         * A program that outputs the 7-times tables to the user.
         */
        System.out.println("Program 4: 7-Times Table");
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " x 7 = " + (i * 7));
        }
        System.out.println("\n-------------------------");

        /**
         * Write a program that asks the user for a number between
         * 1-12 and outputs that numbers multiplication table.
         */
        System.out.println("Program 5: Custom Multiplication Table");
        System.out.print("Enter a number to see its multiplication table: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " x " + number + " = " + (i * number));
        }
        System.out.println("\n-------------------------");

        /**
         * Same as the previous task with the added function of
         * a restart at the end of the program.
         */
        char choice;
        do {
            System.out.println("Program 6: Multiplication Table with Restart");
            System.out.print("Enter a number to see its multiplication table: ");
            number = scanner.nextInt();
            for (int i = 1; i <= 12; i++) {
                System.out.println(i + " x " + number + " = " + (i * number));
            }
            System.out.print("Do you want to see another table? (y/n): ");
            choice = scanner.next().toLowerCase().charAt(0);
        } while (choice == 'y');
        System.out.println("Goodbye!");
        System.out.println("\n-------------------------");

        /**
         * A program that takes an exam score from the user and outputs
         * a grade in return based ojn the exam score.
         */
        System.out.println("Program 7: Exam Mark to Grade");
        System.out.print("Enter your exam mark (0-100): ");
        int mark = scanner.nextInt();
        if (mark >= 70) {
            System.out.println("Grade: First-Class");
        } else if (mark >= 60) {
            System.out.println("Grade: Upper Second-Class (2:1)");
        } else if (mark >= 50) {
            System.out.println("Grade: Lower Second-Class (2:2)");
        } else if (mark >= 40) {
            System.out.println("Grade: Third-Class");
        } else {
            System.out.println("Grade: Fail");
        }
        System.out.println("\n-------------------------");

        /**
         * Program that prints only even numbers between
         * the numbers 0 and q0 and outputs to user.
         */
        System.out.println("Program 8: Print Even Numbers");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n-------------------------");

        scanner.close(); // Close scanner to prevent resource leak
    }
}