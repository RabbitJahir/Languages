// The Student class provided in the problem
class Student {
    static int studentCount = 0;
    String name;

    Student(String name) {
        this.name = name;
        studentCount++; // Increments the shared class counter
    }

    static void showCount() {
        System.out.println("Total students: " + studentCount);
    }
}

// Main class to run the program
public class threeA {
    public static void main(String[] args) {
        System.out.println("--- Initial State ---");
        // 1. Call the static showCount() method using the class name
        Student.showCount(); 

        // 2. Access the static studentCount variable directly using the class name
        System.out.println("Direct variable access: " + Student.studentCount);

        System.out.println("\n--- Creating Student Objects ---");
        // Creating instances of Student to show how the static counter works
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        System.out.println("\n--- Updated State ---");
        // Calling the method and accessing the variable again after object creation
        Student.showCount();
        System.out.println("Direct variable access: " + Student.studentCount);
    }
}