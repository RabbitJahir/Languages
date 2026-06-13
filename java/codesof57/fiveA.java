class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showPersonInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age); 
        this.subject = subject;
    }

    public void showTeacherInfo() {
        showPersonInfo();
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void showStudentInfo() {
        showPersonInfo();
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void showStaffInfo() {
        showPersonInfo();
        System.out.println("Department: " + department);
    }
}

public class fiveA {
    public static void main(String[] args) {
        
        Teacher teacher = new Teacher("Mr. Smith", 42, "Mathematics");
        Student student = new Student("Emily", 19, "A+");
        Staff staff = new Staff("Sarah", 35, "Human Resources");

        teacher.showTeacherInfo();

        student.showStudentInfo();

        staff.showStaffInfo();
    }
}