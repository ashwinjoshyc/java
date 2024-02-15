import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;
    int age;
    double height;

    // Parameterized constructor with final keyword for parameter passing
    Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // Abstract method to be implemented by subclasses
    void additionalInfo() {
        // Abstract method, will be implemented by subclasses
    }

    // Method to read values from the user
    void get() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter age: ");
        this.age = scanner.nextInt();
        System.out.print("Enter height: ");
        this.height = scanner.nextDouble();
    }

    // Method to display values
    void show() {
        System.out.println("Name: " + this.name + ", Age: " + this.age + ", Height: " + this.height);
        additionalInfo(); // Call to abstract method
    }
}

class Student extends Person {
    static int studentIdCounter = 1000;

    int studentId;
    String institutionName;
    String phoneNumber;

    // Parameterized constructor with final keyword for parameter passing
    Student(String name, int age, double height, String institutionName, String phoneNumber) {
        super(name, age, height);
        this.studentId = studentIdCounter++;
        this.institutionName = institutionName;
        this.phoneNumber = phoneNumber;
    }

    // Method to read values for Student class
    void get() {
        super.get();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter institution name: ");
        this.institutionName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        this.phoneNumber = scanner.nextLine();
    }

    // Method to display values for Student class
    void show() {
        super.show();
        System.out.println("Student ID: " + this.studentId + ", Institution: " + this.institutionName +
                ", Phone: " + this.phoneNumber);
    }

    // Static method to display student IDs using static keyword
    static void displayStudentIDs(ArrayList<Student> students) {
        System.out.println("Student IDs: ");
        for (Student student : students) {
            System.out.println(student.studentId);
        }
    }

    // Additional info implementation for Student class
    void additionalInfo() {
        System.out.println("Student additional info: N/A");
    }
}

class GraduateStudent extends Student {
    String programName;
    int noOfSubjects;
    String classTeacherName;
    double marks;
    double attendance;

    // No-argument constructor
    GraduateStudent() {
        super("", 0, 0.0, "", ""); // Default values
    }

    // Parameterized constructor with final keyword for parameter passing
    GraduateStudent(String name, int age, double height, String institutionName, String phoneNumber,
                    String programName, int noOfSubjects, String classTeacherName, double marks, double attendance) {
        super(name, age, height, institutionName, phoneNumber);
        this.programName = programName;
        this.noOfSubjects = noOfSubjects;
        this.classTeacherName = classTeacherName;
        this.marks = marks;
        this.attendance = attendance;
    }

    // Method to read values for GraduateStudent class
    void get() {
        super.get();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter program name: ");
        this.programName = scanner.nextLine();
        System.out.print("Enter number of subjects: ");
        this.noOfSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter class teacher name: ");
        this.classTeacherName = scanner.nextLine();
        System.out.print("Enter marks: ");
        this.marks = scanner.nextDouble();
        System.out.print("Enter attendance: ");
        this.attendance = scanner.nextDouble();
    }

    // Method to display values for GraduateStudent class
    void show() {
        super.show();
        System.out.println("Program: " + this.programName + ", Subjects: " + this.noOfSubjects +
                ", Class Teacher: " + this.classTeacherName + ", Marks: " + this.marks + ", Attendance: " + this.attendance);
    }

    // Additional info implementation for GraduateStudent class
    void additionalInfo() {
        System.out.println("Program: " + this.programName + ", Subjects: " + this.noOfSubjects +
                ", Class Teacher: " + this.classTeacherName);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an array list of objects
        ArrayList<Student> students = new ArrayList<>();

        // Input data for students
        for (int i = 0; i < 5; i++) {
            GraduateStudent student = new GraduateStudent();
            student.get();
            students.add(student);
        }

        // Displaying the list of students
        for (Student student : students) {
            student.show();
        }

        // Displaying student IDs using static keyword
        Student.displayStudentIDs(students);

        // Displaying male students with above 60% marks in MCA
        System.out.println("Male students with above 60% marks in MCA:");
        for (Student student : students) {
            if (student instanceof GraduateStudent) {
                GraduateStudent gradStudent = (GraduateStudent) student;
                if (gradStudent.programName.equalsIgnoreCase("MCA") && gradStudent.marks > 60) {
                    gradStudent.show();
                }
            }
        }

        // Displaying female students with above 75% attendance in MCA
        System.out.println("Female students with above 75% attendance in MCA:");
        for (Student student : students) {
            if (student instanceof GraduateStudent) {
                GraduateStudent gradStudent = (GraduateStudent) student;
                if (gradStudent.programName.equalsIgnoreCase("MCA") && gradStudent.attendance > 75) {
                    gradStudent.show();
                }
            }
        }
    }
}
