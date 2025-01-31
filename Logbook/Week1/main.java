package Logbook.Week1;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Program 1: Hello World
        System.out.println("Program 1: Hello World");
        System.out.println("Hello World!");

        System.out.println("\n-------------------------");

        // Program 2: Personalised Greeting
        System.out.println("Program 2: Personalised Greeting");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");

        System.out.println("\n-------------------------");

        // Program 3: Rectangle Perimeter and Area
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

        // Program 4: Average of Two Numbers
        System.out.println("Program 4: Average of Two Numbers");
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double average = (num1 + num2) / 2;
        System.out.println("The average is: " + average);

        System.out.println("\n-------------------------");

        // Program 5: Reverse Two Integers
        System.out.println("Program 5: Reverse Two Integers");
        System.out.print("Enter the first integer: ");
        int int1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int int2 = scanner.nextInt();
        System.out.println("Original order: " + int1 + ", " + int2);
        System.out.println("Reversed order: " + int2 + ", " + int1);
    }
}