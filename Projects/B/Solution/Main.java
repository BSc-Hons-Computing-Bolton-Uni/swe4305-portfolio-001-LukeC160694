package Projects.B.Solution;

import java.util.*;

class Student {
    private String id;  // Student ID
    private String name;  // Student Name
    private Map<String, Integer> moduleMarks;  // Map to store marks for each module

    // Constructor to initialise a student with ID and name
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.moduleMarks = new HashMap<>();
    }

    public String getId() { return id; }  // Returns the student's ID

    public String getName() { return name; }  // Returns the student's name

    public void setName(String name) {
        this.name = name;  // Sets a new name for the student
    }

    // Adds or updates the mark for a specific module
    public void addOrUpdateModuleMark(String module, int mark) {
        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark. Please enter a value between 0 and 100.");
            return;  // Exit the method if the mark is not within the valid range
        }
        moduleMarks.put(module, mark);  // Update the mark for the specified module
    }

    // Removes a module from the student's record
    public void removeModule(String module) {
        moduleMarks.remove(module);  // Removes the specified module
    }

    // Returns the map of module marks
    public Map<String, Integer> getModuleMarks() {
        return moduleMarks;
    }

    // Returns the grade based on the given mark
    public String getGrade(int mark) {
        if (mark >= 70) return "A";  // First Class
        if (mark >= 60) return "B";  // Upper Second Class
        if (mark >= 50) return "C";  // Lower Second Class
        if (mark >= 40) return "D";  // Third Class
        return "F";  // Fail
    }

    // Displays the grades for all modules
    public void displayGrades() {
        System.out.println("Student: " + name + " (" + id + ")");
        for (Map.Entry<String, Integer> entry : moduleMarks.entrySet()) {
            System.out.println("Module: " + entry.getKey() + ", Mark: " + entry.getValue() +
                    ", Grade: " + getGrade(entry.getValue()));  // Print module, mark, and grade
        }
    }
}

public class Main {
    private static final List<Student> students = new ArrayList<>();  // List to store all students
    private static final Set<String> modules = new HashSet<>();  // Set to store all unique modules
    private static final Scanner scanner = new Scanner(System.in);  // Scanner for user input

    // Adds a new student to the system
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));  // Add the new student to the list
        System.out.println("Student added.");
    }

    // Edits the name of an existing student
    public static void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.print("Enter new name: ");
                s.setName(scanner.nextLine());  // Update the student's name
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Deletes a student from the system
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        students.removeIf(s -> s.getId().equals(id));  // Remove the student if ID matches
        System.out.println("Student removed.");
    }

    // Adds a new module to the system
    public static void addModule() {
        System.out.print("Enter Module Name: ");
        String module = scanner.nextLine();
        modules.add(module);  // Add the module to the set
        System.out.println("Module added.");
    }

    // Deletes a module from the system
    public static void deleteModule() {
        System.out.print("Enter Module Name to delete: ");
        String module = scanner.nextLine();
        modules.remove(module);  // Remove the module from the set
        for (Student s : students) {
            s.removeModule(module);  // Remove the module from all students' records
        }
        System.out.println("Module deleted.");
    }

    // Adds or updates the mark for a specific student and module
    public static void addOrUpdateMark() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.print("Enter Module Name: ");
                String module = scanner.nextLine();
                if (!modules.contains(module)) {
                    System.out.println("Module not found.");  // Check if the module exists
                    return;
                }
                System.out.print("Enter Mark: ");
                int mark = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer
                s.addOrUpdateModuleMark(module, mark);  // Update the mark for the specified module
                System.out.println("Mark updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Displays the grades for a specific student
    public static void displayStudentGrades() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.displayGrades();  // Display all grades for the student
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Displays statistics (mean, min, max) for a specific module
    public static void moduleStatistics() {
        System.out.print("Enter Module Name: ");
        String module = scanner.nextLine();
        List<Integer> marks = new ArrayList<>();
        for (Student s : students) {
            Map<String, Integer> studentMarks = s.getModuleMarks();
            if (studentMarks.containsKey(module)) {
                marks.add(studentMarks.get(module));  // Add the mark for the specified module
            }
        }
        if (marks.isEmpty()) {
            System.out.println("No marks available for this module.");
            return;
        }

        double mean = marks.stream().mapToInt(Integer::intValue).average().orElse(0);  // Calculate the mean
        int min = Collections.min(marks);  // Find the minimum mark
        int max = Collections.max(marks);  // Find the maximum mark

        System.out.println("Stats for Module: " + module);
        System.out.printf("Mean: %.2f, Min: %d, Max: %d%n", mean, min, max);  // Display the stats
    }

    // Displays the grade distribution for a specific module
    public static void gradeProfile() {
        System.out.print("Enter Module Name: ");
        String module = scanner.nextLine();
        Map<String, Integer> gradeCount = new HashMap<>();
        int total = 0;

        for (Student s : students) {
            Integer mark = s.getModuleMarks().get(module);
            if (mark != null) {
                String grade = s.getGrade(mark);  // Get the grade for the module
                gradeCount.put(grade, gradeCount.getOrDefault(grade, 0) + 1);  // Count the grades
                total++;
            }
        }

        if (total == 0) {
            System.out.println("No marks recorded for this module.");
            return;
        }

        System.out.println("Grade Profile for Module: " + module);
        for (String grade : List.of("A", "B", "C", "D", "F")) {
            int count = gradeCount.getOrDefault(grade, 0);  // Get the count for each grade
            System.out.printf("%s: %.2f%%%n", grade, (count * 100.0) / total);  // Display the percentage of each grade
        }
    }

    // Main menu for the application
    public static void menu() {
        while (true) {
            System.out.println("\nStudent Marks Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Add Module");
            System.out.println("5. Delete Module");
            System.out.println("6. Input/Update Mark");
            System.out.println("7. Display Student Grades");
            System.out.println("8. Module Statistics");
            System.out.println("9. Grade Profile");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (option) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> deleteStudent();
                case 4 -> addModule();
                case 5 -> deleteModule();
                case 6 -> addOrUpdateMark();
                case 7 -> displayStudentGrades();
                case 8 -> moduleStatistics();
                case 9 -> gradeProfile();
                case 10 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // Main method to run the menu
    public static void main(String[] args) {
        menu();
    }
}