package schoolsoft;

import java.util.ArrayList;
import java.util.List;

public class Teachers {
    private final List<String> teacherNames = new ArrayList<>();

    public void addTeacher(String name) {
        teacherNames.add(name);
    }

    public boolean removeTeacher(String name) {
        return teacherNames.remove(name);
    }

    public boolean changeTeacher(String oldName, String newName) {
        int index = teacherNames.indexOf(oldName);
        if (index == -1) {
            return false;
        }
        teacherNames.set(index, newName);
        return true;
    }

    public void displayTeachers() {
        if (teacherNames.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        System.out.println("Teachers:");
        for (int i = 0; i < teacherNames.size(); i++) {
            System.out.println((i + 1) + ". " + teacherNames.get(i));
        }
    }
}
