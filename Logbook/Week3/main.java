package Logbook.Week3;
// Declare Student class with attributes ID & Name, and a Constructor
class Student {
    private int id;        // Student ID
    private String name;   // Student Name
    private Course course; // Add Course attribute to Student class

    // Constructor to assign ID and Name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.course = null; // Initially, no course assigned
    }

    // 'Enrol' method to assign a Course to Student
    public void enrol(Course course) {
        this.course = course;
    }

    // Print method to display student details and enrolled course
    public void print() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);

        // Print course details if student is enrolled
        if (course != null) {
            System.out.println("Enrolled Course:");
            course.print(); // Calling the print method of Course class
        } else {
            System.out.println("Not enrolled in any course.");
        }
    }
}

// Declare Course class with attributes Course Code & Name
class Course {
    private String courseCode;  // Course Code
    private String courseName;  // Course Name

    // Constructor to assign Course Code & Name
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    // Print method to display course details
    public void print() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
    }
}

// Main Class to Instantiate Student and Course
public class main {
    public static void main(String[] args) {

        // Instantiate Student object
        Student student1 = new Student(12345678, "Luke"); // Example student with ID and Name

        // Instantiate Course object
        Course course1 = new Course("SWE4305", "Introduction to Java"); // Example course with Code and Name

        // Enrol student into the course
        student1.enrol(course1);

        // Print student details including enrolled course
        student1.print();
    }
}