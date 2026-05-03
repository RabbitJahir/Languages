package inheritance;

class Person{
    String name;
    int id;
    Person(String name, int id){
        this.name = name;
        this.id = id;
    }
    public void displayInfo(){
        System.out.println(name +": "+ id);
    }
}

class Student extends Person{
    String course;
    float cgpa;
    Student(String name, int id, String course, float cgpa){
        super(name, id);
        this.course = course;
        this.cgpa = cgpa;
    }
    @Override
    public void displayInfo(){
        System.out.println("Student details: ");
        super.displayInfo();
        System.out.println(course + cgpa);
    }
}

class Teacher extends Person{
    String course;
    double salary;
    Teacher(String name, int id, String course, double salary){
        super(name, id);
        this.course = course;
        this.salary = salary;
    }
    @Override
    public void displayInfo(){
        System.out.println("Teacher details: ");
        super.displayInfo();
        System.out.println(course + salary);
    }
}


public class start3{
    public static void main(String[] args){
        Teacher teacher = new Teacher("Name", 1234, "CSe", 1235);

        teacher.displayInfo();
    }
}