package Logbook.Week1.Task5;
import java.util.Scanner;

public class ReverseIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        System.out.println("Original order: " + num1 + ", " + num2);
        System.out.println("Reversed order: " + num2 + ", " + num1);
        scanner.close();
    }
}