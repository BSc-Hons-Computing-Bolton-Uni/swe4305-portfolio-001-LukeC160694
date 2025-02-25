package Logbook.Week4;
import java.util.ArrayList;
import java.util.Random;

/**
 * Creating the module class with attributes for both the module name and module code.
 */
class Module {
    private String moduleName;
    private String moduleCode;

    // Constructor
    public Module(String moduleName, String moduleCode) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }

    // Public getter for module name
    public String getModuleName() {
        return moduleName;
    }

    // Public getter for module code
    public String getModuleCode() {
        return moduleCode;
    }

    // Convert mark to letter grade
    public String getGrade(int mark) {
        if (mark >= 70) return "A";
        else if (mark >= 60) return "B";
        else if (mark >= 50) return "C";
        else if (mark >= 40) return "D";
        else return "F";
    }

    // Print module details
    public void print() {
        System.out.println("Module: " + moduleName + " (" + moduleCode + ")");
    }
}

/**
 * Sorting the course code to include an arrayList of four modules.
 */
class Course {
    private String courseCode;
    private String courseName;
    private ArrayList<Module> modules;

    // Constructor
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.modules = new ArrayList<>();

        // Adding four modules
        modules.add(new Module("Mathematics", "MATH101"));
        modules.add(new Module("Programming", "COMP102"));
        modules.add(new Module("Physics", "PHYS103"));
        modules.add(new Module("Databases", "COMP104"));
    }

    // Getter for modules
    public ArrayList<Module> getModules() {
        return modules;
    }

    // Print course details and modules
    public void print() {
        System.out.println("Course: " + courseName + " (" + courseCode + ")");
        System.out.println("Modules:");
        for (Module module : modules) {
            module.print();
        }
    }
}

/**
 * Add marks array to the Student class and assign random marks.
 */
class Student {
    private int studentID;
    private String studentName;
    private Course course;
    private int[] marks = new int[4];  // Stores four marks (0-100)

    // Constructor
    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    // Enrol the student in a course
    public void enrol(Course course) {
        this.course = course;

        // Assign random marks for each module
        Random random = new Random();
        for (int i = 0; i < marks.length; i++) {
            marks[i] = random.nextInt(101); // Random number between 0-100
        }
    }

    // Print student details, course details, and marks
    public void print() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        if (course != null) {
            course.print();
            System.out.println("Marks:");
            ArrayList<Module> modules = course.getModules();
            for (int i = 0; i < marks.length; i++) {
                System.out.println(modules.get(i).getModuleName() + " - " + marks[i] + " (" + modules.get(i).getGrade(marks[i]) + ")");
            }
        } else {
            System.out.println("Not enrolled in any course.");
        }
    }
}

/**
 * Test the program in the main method.
 */
public class main {
    public static void main(String[] args) {
        // Create a course
        Course course = new Course("CS101", "Computer Science");

        // Create a student
        Student student = new Student(12345678, "Luke Catterall");

        // Enrol the student in the course
        student.enrol(course);

        // Print student and course details
        student.print();
    }
}