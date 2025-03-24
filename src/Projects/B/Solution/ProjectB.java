package Projects.B.Solution;

import java.util.*;

class Student {
    private String id;  // Student ID
    private String name;  // Student Name
    private Map<String, Integer> moduleMarks;  // A map to store marks for each module

    // Constructor to initialise a student with an ID and name
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.moduleMarks = new HashMap<>();
    }

    // Getter method for student ID
    public String getId() { return id; }

    // Getter method for student name
    public String getName() { return name; }

    // Setter method to change the student name
    public void setName(String name) { this.name = name; }

    // Method to add or update a student's mark for a given module
    public void addOrUpdateModuleMark(String module, int mark) {
        // Check if the mark is within a valid range
        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark. Please enter a value between 0 and 100.");
            return;
        }
        moduleMarks.put(module, mark);  // Update the module marks map
    }

    // Method to remove a module from the student's record
    public void removeModule(String module) {
        moduleMarks.remove(module);  // Remove the module from the map
    }

    // Getter method for all the module marks
    public Map<String, Integer> getModuleMarks() { return moduleMarks; }

    // Method to determine the grade based on the mark
    public String getGrade(int mark) {
        if (mark >= 70) return "A";  // First Class
        if (mark >= 60) return "B";  // Upper Second Class
        if (mark >= 50) return "C";  // Lower Second Class
        if (mark >= 40) return "D";  // Third Class
        return "F";  // Fail
    }

    // Method to display all the grades for a student
    public void displayGrades() {
        System.out.println("Student: " + name + " (" + id + ")");
        // Iterate over the module marks and print each one
        for (Map.Entry<String, Integer> entry : moduleMarks.entrySet()) {
            System.out.println("Module: " + entry.getKey() + ", Mark: " + entry.getValue() +
                    ", Grade: " + getGrade(entry.getValue()));
        }
    }
}

public class ProjectB {
    private static final List<Student> students = new ArrayList<>();  // List to store students
    private static final LinkedHashMap<String, String> modules = new LinkedHashMap<>();  // Map to store module codes and names
    private static final Scanner scanner = new Scanner(System.in);  // Scanner for user input

    static {
        // Initialising modules with their codes and names
        modules.put("COM4301", "Maths for Computing");
        modules.put("COM4302", "Computer Science Fundamentals");
        modules.put("SWE4303", "Computing Infrastructure");
        modules.put("SWE4304", "Databases");
        modules.put("SWE4305", "Object Oriented Programming");
        modules.put("SWE5306", "Systems Analysis and Design");
        modules.put("SWE5307", "Web Design and Programming");
        modules.put("SWE5308", "Cloud Technologies");
        modules.put("SWE5304", "Advanced Databases and Big Data");
        modules.put("SEC5304", "Advanced Operating Systems");
        modules.put("AIN5301", "Introduction to AI");
        modules.put("COM6300", "Research and Professional Issues");
        modules.put("COM6301", "Undergraduate Project");
        modules.put("AIN6301", "Natural Language Processing");
        modules.put("SEC6302", "Information Security Management");
        modules.put("SEC6305", "Operations Management");
        modules.put("SWE6302", "Applied Machine Learning");
        modules.put("SWE6303", "Software Quality Management");
        modules.put("SWE6304", "Emerging Technologies");
    }

    // Method to select a module from the list of modules
    private static String selectModuleFromList() {
        List<String> codes = new ArrayList<>(modules.keySet());
        // Display all the available modules
        for (int i = 0; i < codes.size(); i++) {
            System.out.printf("%d. %s (%s)%n", i + 1, modules.get(codes.get(i)), codes.get(i));
        }
        // Get the user's module selection
        System.out.print("Select a module by number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        if (choice < 1 || choice > codes.size()) {
            System.out.println("Invalid selection.");
            return null;
        }
        return codes.get(choice - 1);  // Return the selected module code
    }

    // Method to add a student to the list
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));  // Add the new student to the list
        System.out.println("Student added.");
    }

    // Method to edit a student's name based on their ID
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

    // Method to delete a student based on their ID
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        students.removeIf(s -> s.getId().equals(id));  // Remove the student from the list
        System.out.println("Student removed.");
    }

    // Method to delete a module from the system
    public static void deleteModule() {
        String module = selectModuleFromList();
        if (module == null) return;
        modules.remove(module);  // Remove the module from the list
        for (Student s : students) {
            s.removeModule(module);  // Remove the module from all students' records
        }
        System.out.println("Module deleted.");
    }

    // Method to add or update a student's mark for a specific module
    public static void addOrUpdateMark() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                String moduleCode = selectModuleFromList();
                if (moduleCode == null) return;
                System.out.print("Enter Mark: ");
                int mark = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                s.addOrUpdateModuleMark(moduleCode, mark);  // Update the student's mark for the module
                System.out.println("Mark updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to display the grades for a specific student
    public static void displayStudentGrades() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.displayGrades();  // Display the grades for the student
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to calculate and display statistics for a module
    public static void moduleStatistics() {
        String module = selectModuleFromList();
        if (module == null) return;
        List<Integer> marks = new ArrayList<>();
        for (Student s : students) {
            Map<String, Integer> studentMarks = s.getModuleMarks();
            if (studentMarks.containsKey(module)) {
                marks.add(studentMarks.get(module));  // Add the module mark to the list
            }
        }
        if (marks.isEmpty()) {
            System.out.println("No marks available for this module.");
            return;
        }
        double mean = marks.stream().mapToInt(Integer::intValue).average().orElse(0);
        int min = Collections.min(marks);
        int max = Collections.max(marks);
        System.out.println("Stats for Module: " + module + " - " + modules.get(module));
        System.out.printf("Mean: %.2f, Min: %d, Max: %d%n", mean, min, max);
    }

    // Method to display the grade profile for a module
    public static void gradeProfile() {
        String module = selectModuleFromList();
        if (module == null) return;
        Map<String, Integer> gradeCount = new HashMap<>();
        int total = 0;
        for (Student s : students) {
            Integer mark = s.getModuleMarks().get(module);
            if (mark != null) {
                String grade = s.getGrade(mark);  // Determine the grade based on the mark
                gradeCount.put(grade, gradeCount.getOrDefault(grade, 0) + 1);  // Count the grades
                total++;
            }
        }
        if (total == 0) {
            System.out.println("No marks recorded for this module.");
            return;
        }
        System.out.println("Grade Profile for Module: " + module + " - " + modules.get(module));
        for (String grade : List.of("A", "B", "C", "D", "F")) {
            int count = gradeCount.getOrDefault(grade, 0);  // Get the count for each grade
            System.out.printf("%s: %.2f%%%n", grade, (count * 100.0) / total);  // Display percentage for each grade
        }
    }

    // Main method that presents the menu to the user and processes the user's choice
    public static void menu() {
        while (true) {
            System.out.println("\nStudent Marks Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Delete Module");
            System.out.println("5. Input/Update Mark");
            System.out.println("6. Display Student Grades");
            System.out.println("7. Module Statistics");
            System.out.println("8. Grade Profile");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            switch (option) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> deleteStudent();
                case 4 -> deleteModule();
                case 5 -> addOrUpdateMark();
                case 6 -> displayStudentGrades();
                case 7 -> moduleStatistics();
                case 8 -> gradeProfile();
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // Main entry point for the application
    public static void main(String[] args) {
        menu();
    }
}