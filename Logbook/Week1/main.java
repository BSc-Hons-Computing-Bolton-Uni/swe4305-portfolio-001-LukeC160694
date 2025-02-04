package Logbook.Week1;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * This program contains the work for week 1.
 * I have put them together to be able to run sequentially.
 * This enables it all to be in one place and be easily read and understood.
 * It demonstrates basic java functionalities i have learnt such as,
 * User input, arithmetic operations, and string manipulation.
 */

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * Program 1: Hello world
         * Prints "Hello World!" to the console.
         */
        System.out.println("Program 1: Hello World");
        System.out.println("Hello World!");
        System.out.println("\n-------------------------");

        /**
         * Program 2: Personalised greeting
         * Asks for the users name and greets them.
         */
        System.out.println("Program 2: Personalised Greeting");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        System.out.println("\n-------------------------");

        /**
         * Program 3: Rectangle perimeter and area
         * Calculates and displays the perimeter and area of a rectangle.
         */
        System.out.println("Program 3: Rectangle Perimeter and Area");
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter the height of the rectangle: ");
        double height = scanner.nextDouble();
        double perimeter = 2 * (length + height);
        double area = length * height;
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
        System.out.println("\n-------------------------");

        /**
         * Program 4: Average of two numbers
         * Computes and displays the average of two numbers.
         */
        System.out.println("Program 4: Average of Two Numbers");
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double average = (num1 + num2) / 2;
        System.out.println("The average is: " + average);
        System.out.println("\n-------------------------");

        /**
         * Program 5: Reverse two integers
         * Reads two integers and displays them in reverse order.
         */
        System.out.println("Program 5: Reverse Two Integers");
        System.out.print("Enter the first integer: ");
        int int1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int int2 = scanner.nextInt();
        System.out.println("Original order: " + int1 + ", " + int2);
        System.out.println("Reversed order: " + int2 + ", " + int1);
        System.out.println("\n-------------------------");
        System.out.println("\n-------------------------");

        /**
         * Program 6: Calculate birth year from age
         * Computes the birth year based on the user-provided age.
         */
        System.out.println("Program 6: Calculate Birth Year from Age");
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        int currentYear = LocalDate.now().getYear();
        int birthYear = currentYear - age;
        System.out.println("You were born in: " + birthYear);
        System.out.println("\n-------------------------");

        /**
         * program 7: Calculate days old from DOB
         * Computes the number of days since the users birth date.
         */
        scanner.nextLine();
        System.out.println("Program 7: Calculate Days Old from DOB");
        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dobInput = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobInput);
        LocalDate today = LocalDate.now();
        long daysOld = java.time.temporal.ChronoUnit.DAYS.between(dob, today);
        System.out.println("You are " + daysOld + " days old.");
        System.out.println("\n-------------------------");
        System.out.println("\n-------------------------");

        /**
         * Program 8: Convert feet to miles
         * Converts a given number of feet into miles.
         */
        System.out.println("Program 8: Convert Feet to Miles");
        System.out.print("Enter the number of feet: ");
        double feet = scanner.nextDouble();
        double miles = feet / 5280;
        System.out.println(feet + " feet is " + miles + " miles.");
        System.out.println("\n-------------------------");

        /**
         * Program 9: Savings account interest calculation
         * Computes 1% interest on a deposit and displays the total amount.
         */
        System.out.println("Program 9: Savings Account Interest Calculation");
        System.out.print("Enter the deposit amount: ");
        double deposit = scanner.nextDouble();
        double interestRate = 0.01; // 1% interest
        double interest = deposit * interestRate;
        double total = deposit + interest;
        System.out.println("Interest earned: " + interest);
        System.out.println("Total amount after a year: " + total);
        System.out.println("\nAll programs executed successfully!");
        scanner.close();
    }
}