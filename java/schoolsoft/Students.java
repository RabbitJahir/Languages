package schoolsoft;

import java.util.ArrayList;
import java.util.List;

public class Students {
    private final List<String> studentNames = new ArrayList<>();

    public void addStudent(String name) {
        studentNames.add(name);
    }

    public boolean removeStudent(String name) {
        return studentNames.remove(name);
    }

    public boolean changeStudent(String oldName, String newName) {
        int index = studentNames.indexOf(oldName);
        if (index == -1) {
            return false;
        }
        studentNames.set(index, newName);
        return true;
    }

    public void displayStudents() {
        if (studentNames.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("Students:");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println((i + 1) + ". " + studentNames.get(i));
        }
    }
}
