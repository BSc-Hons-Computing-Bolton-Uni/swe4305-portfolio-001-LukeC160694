package Logbook.Week2;
import java.util.Scanner;
import java.time.LocalDate;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * Program 1: Age check
         * gets the user to input their age and outputs their birth year
         * as well if they are an adult or under 18.
          */
        System.out.println("Program 1: Age Check");
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        int currentYear = LocalDate.now().getYear();
        int birthYear = currentYear - age;
        System.out.println("You were born in: " + birthYear);
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are under 18.");
        }

        System.out.println("\n-------------------------");

        /**
         * Program 2: Grade classification
         * Asks the user for their letter grade
         * And outputs the result as a university classification.
         */
        scanner.nextLine();
        System.out.println("Program 2: Grade Classification");
        System.out.print("Enter your letter grade (A, B, C, D, E, F): ");
        char grade = scanner.next().toUpperCase().charAt(0);
        switch (grade) {
            case 'A':
                System.out.println("Classification: 1st");
                break;
            case 'B':
                System.out.println("Classification: 2:1");
                break;
            case 'C':
                System.out.println("Classification: 2:2");
                break;
            case 'D':
                System.out.println("Classification: 3rd");
                break;
            case 'E':
                System.out.println("Classification: Ordinary");
                break;
            case 'F':
                System.out.println("Classification: Fail");
                break;
            default:
                System.out.println("Invalid grade entered.");
        }

        System.out.println("\n-------------------------");

        /**
         * Program 3: Print digits 0-9
         * prints out the digit from numbers 0 to 9 for the user.
         */
        System.out.println("Program 3: Digits from 0 to 9");
        for (int i = 0; i <= 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n-------------------------");

        /**
         * Program 4: 7-times table
         * Outputs the 7 times table to the user.
         */
        System.out.println("Program 4: 7-Times Table");
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " x 7 = " + (i * 7));
        }

        System.out.println("\n-------------------------");

        /**
         * Program 5: Custom multiplication table
         * Asks the user to input a number from 1 to 12
         * and outputs that numbers times table.
         */
        System.out.println("Program 5: Custom Multiplication Table");
        System.out.print("Enter a number to see its multiplication table: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " x " + number + " = " + (i * number));
        }

        System.out.println("\n-------------------------");

        /**
         * Program 6: Multiplication table with restart
         * The same as the previous program except with an option after each times table set
         * to restart and begin again with a new number or end the program.
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
         * Program 7: Exam mark to grade
         * Asks the user to enter their grade value from 0 to 100
         * and proceeds to return the university grade that is
         * associated with that number given.
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
         * Program 8: Print even numbers
         * A program that will print out the even numbers to
         * the user between the numbers 0 and 10.
         */
        //  Program 8: Print Even Numbers
        System.out.println("Program 8: Print Even Numbers");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n-------------------------");

    }
}
