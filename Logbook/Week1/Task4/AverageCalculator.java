package Logbook.Week1.Task4;
import java.util.Scanner; // Import the Scanner class for user input

public class AverageCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble(); // Read the first number as a double

        // Prompt the user to enter the second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble(); // Read the second number as a double

        // Calculate the average of the two numbers
        double average = (num1 + num2) / 2;

        // Output the result to the user
        System.out.println("The average is: " + average);

        // Close the Scanner object to free up resources
        scanner.close();
    }
}