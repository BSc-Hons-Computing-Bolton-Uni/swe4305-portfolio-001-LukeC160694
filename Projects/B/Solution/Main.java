package Projects.B.Solution;

import java.util.*;

class Student {
    private String id;
    private String name;
    private Map<String, Integer> moduleMarks;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.moduleMarks = new HashMap<>();
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void addOrUpdateModuleMark(String module, int mark) {
        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark. Please enter a value between 0 and 100.");
            return;
        }
        moduleMarks.put(module, mark);
    }

    public void removeModule(String module) {
        moduleMarks.remove(module);
    }

    public Map<String, Integer> getModuleMarks() { return moduleMarks; }

    public String getGrade(int mark) {
        if (mark >= 70) return "A";
        if (mark >= 60) return "B";
        if (mark >= 50) return "C";
        if (mark >= 40) return "D";
        return "F";
    }

    public void displayGrades() {
        System.out.println("Student: " + name + " (" + id + ")");
        for (Map.Entry<String, Integer> entry : moduleMarks.entrySet()) {
            System.out.println("Module: " + entry.getKey() + ", Mark: " + entry.getValue() +
                    ", Grade: " + getGrade(entry.getValue()));
        }
    }
}

public class Main {
    private static final List<Student> students = new ArrayList<>();
    private static final LinkedHashMap<String, String> modules = new LinkedHashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
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

    private static String selectModuleFromList() {
        List<String> codes = new ArrayList<>(modules.keySet());
        for (int i = 0; i < codes.size(); i++) {
            System.out.printf("%d. %s (%s)%n", i + 1, modules.get(codes.get(i)), codes.get(i));
        }
        System.out.print("Select a module by number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > codes.size()) {
            System.out.println("Invalid selection.");
            return null;
        }
        return codes.get(choice - 1);
    }

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added.");
    }

    public static void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.print("Enter new name: ");
                s.setName(scanner.nextLine());
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        students.removeIf(s -> s.getId().equals(id));
        System.out.println("Student removed.");
    }

    public static void deleteModule() {
        String module = selectModuleFromList();
        if (module == null) return;
        modules.remove(module);
        for (Student s : students) {
            s.removeModule(module);
        }
        System.out.println("Module deleted.");
    }

    public static void addOrUpdateMark() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                String moduleCode = selectModuleFromList();
                if (moduleCode == null) return;
                System.out.print("Enter Mark: ");
                int mark = scanner.nextInt();
                scanner.nextLine();
                s.addOrUpdateModuleMark(moduleCode, mark);
                System.out.println("Mark updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void displayStudentGrades() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.displayGrades();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void moduleStatistics() {
        String module = selectModuleFromList();
        if (module == null) return;
        List<Integer> marks = new ArrayList<>();
        for (Student s : students) {
            Map<String, Integer> studentMarks = s.getModuleMarks();
            if (studentMarks.containsKey(module)) {
                marks.add(studentMarks.get(module));
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

    public static void gradeProfile() {
        String module = selectModuleFromList();
        if (module == null) return;
        Map<String, Integer> gradeCount = new HashMap<>();
        int total = 0;
        for (Student s : students) {
            Integer mark = s.getModuleMarks().get(module);
            if (mark != null) {
                String grade = s.getGrade(mark);
                gradeCount.put(grade, gradeCount.getOrDefault(grade, 0) + 1);
                total++;
            }
        }
        if (total == 0) {
            System.out.println("No marks recorded for this module.");
            return;
        }
        System.out.println("Grade Profile for Module: " + module + " - " + modules.get(module));
        for (String grade : List.of("A", "B", "C", "D", "F")) {
            int count = gradeCount.getOrDefault(grade, 0);
            System.out.printf("%s: %.2f%%%n", grade, (count * 100.0) / total);
        }
    }

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
            scanner.nextLine();
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

    public static void main(String[] args) {
        menu();
    }
}
