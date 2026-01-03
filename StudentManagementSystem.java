import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Student class
    static class Student {
        private String name;
        private int rollNumber;
        private String grade;

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
        }

        public int getRollNumber() {
            return rollNumber;
        }
    }

    private ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Remove student by roll number
    public void removeStudent(int rollNumber) {
        Student s = searchStudent(rollNumber);
        if (s != null) {
            students.remove(s);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Search student
    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) return s;
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- List of Students ---");
            for (Student s : students) System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter 1-5: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Enter numeric Roll Number: ");
                        sc.next();
                    }
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    sms.addStudent(new Student(name, roll, grade));
                    break;
                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Enter numeric Roll Number: ");
                        sc.next();
                    }
                    sms.removeStudent(sc.nextInt());
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Enter numeric Roll Number: ");
                        sc.next();
                    }
                    Student s = sms.searchStudent(sc.nextInt());
                    sc.nextLine();
                    if (s != null) System.out.println("Student Found: " + s);
                    else System.out.println("Student not found!");
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice! Enter 1-5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
