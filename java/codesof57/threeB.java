interface Learner {
    void attendCourse(String courseName);
}

interface Instructor {
    void teachCourse(String courseName);
}

interface Admin {
    default void accessDashboard() {
        System.out.println("admin dashboard");
    }
}

class PlatformUser implements Learner, Instructor, Admin {
    
    @Override
    public void attendCourse(String courseName) {
        System.out.println("Attending course: " + courseName);
    }

    @Override
    public void teachCourse(String courseName) {
        System.out.println("Teaching course: " + courseName);
    }

    @Override
    public void accessDashboard() {
        System.out.println("Admin dashboard access granted");
    }
}

public class threeB {
    public static void main(String[] args) {
        PlatformUser user = new PlatformUser();

        user.attendCourse("Java Basics");
        user.teachCourse("Advanced Java");
        user.accessDashboard();
    }
}