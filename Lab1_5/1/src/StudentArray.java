import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentArray {
    private List<Student> _students;

    public StudentArray() {
        _students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : _students) {
            if (s.lastName.equals(student.lastName)) {
                System.out.println("Студент з таким прізвищем вже існує: " + student.lastName);
                return;
            }
        }
        _students.add(student);
    }

    public void printStudents() {
        for (Student student : _students) {
            System.out.println(student);
        }
    }

    public void sortStudents() {
        Collections.sort(_students);
    }

    public int binarySearch(String lastName) {
        int left = 0, right = _students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = _students.get(mid).lastName.compareTo(lastName);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public void removeStudentIfFromDonetsk() {
        sortStudents();

        List<Student> toRemove = new ArrayList<>();

        for (Student student : _students) {
            if (student.city.equalsIgnoreCase("Донецьк")) {
                toRemove.add(student);
            }
        }

        for (Student student : toRemove) {
            System.out.println("Видалено студента: " + student);
            _students.remove(student);
        }
    }

}