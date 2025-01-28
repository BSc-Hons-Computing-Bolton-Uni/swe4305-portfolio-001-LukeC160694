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
    }
}