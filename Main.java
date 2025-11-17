import java.util.ArrayList;
import java.util.Scanner;

// ===== Parent Class: Person =====
class Person {
    String name;

    Person() {}

    Person(String name) {
        this.name = name;
    }
}

// ===== Child Class: Student (inherits Person) =====
class Student extends Person {

    int rollNo;
    String course;
    double marks;
    char grade;

    // Default Constructor
    Student() {}

    // Parameterized Constructor
    Student(int rollNo, String name, String course, double marks) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    // Method to take user input
    void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        // Marks validation
        while (true) {
            System.out.print("Enter Marks (0 - 100): ");
            marks = sc.nextDouble();

            if (marks >= 0 && marks <= 100) break;
            else System.out.println("Invalid input! Marks must be between 0 and 100.");
        }

        calculateGrade();
    }

    // Grade calculation logic
    void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 75) grade = 'B';
        else if (marks >= 60) grade = 'C';
        else grade = 'D';
    }

    // Display student details
    void displayDetails() {
        System.out.println("-----------------------------");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------");
    }
}


// ===== Main Class =====
public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            // Menu
            System.out.println("\n===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Student s = new Student();
                    s.inputDetails();
                    students.add(s);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\n===== Student Records =====");
                        for (Student st : students) {
                            st.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
