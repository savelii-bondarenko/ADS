import java.util.*;
/*
//
public class StudentSorting
{
    public static void countingSort(Student[] students) {
        int maxLabs = Arrays.stream(students).mapToInt(s -> s.completedLabs).max().orElse(0);

        List<Student>[] count = new ArrayList[maxLabs + 1];
        for (int i = 0; i <= maxLabs; i++) {
            count[i] = new ArrayList<>();
        }

        for (Student student : students) {
            count[student.completedLabs].add(student);
        }

        int index = 0;
        for (int i = maxLabs; i >= 0; i--) {
            for (Student student : count[i]) {
                students[index++] = student;
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Іванов", "Олексій", "Математика", 5),
                new Student("Петров", "Андрій", "Фізика", 3),
                new Student("Сидоров", "Максим", "Інформатика", 7),
                new Student("Коваленко", "Ірина", "Математика", 5),
                new Student("Мельник", "Ольга", "Фізика", 4)
        };

        System.out.println("Перед сортуванням:");
        for (Student s : students) {
            System.out.println(s);
        }

        countingSort(students);

        System.out.println("\nПісля сортування:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
*/
/*
public class StudentSorting {
    public static void radixSort(Student[] students) {
        int maxLabs = Arrays.stream(students).mapToInt(s -> s.completedLabs).max().orElse(0);

        for (int exp = 1; maxLabs / exp > 0; exp *= 10) {
            countingSortByDigit(students, exp);
        }
    }

    private static void countingSortByDigit(Student[] students, int exp) {
        int n = students.length;
        Student[] output = new Student[n];
        int[] count = new int[10];

        for (Student student : students) {
            int digit = (student.completedLabs / exp) % 10;
            count[digit]++;
        }

        for (int i = 8; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (students[i].completedLabs / exp) % 10;
            output[--count[digit]] = students[i];
        }

        System.arraycopy(output, 0, students, 0, n);
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Іванов", "Олексій", "Математика", 5),
                new Student("Петров", "Андрій", "Фізика", 3),
                new Student("Сидоров", "Максим", "Інформатика", 7),
                new Student("Коваленко", "Ірина", "Математика", 5),
                new Student("Мельник", "Ольга", "Фізика", 4)
        };

        System.out.println("Перед сортуванням:");
        for (Student s : students) {
            System.out.println(s);
        }

        radixSort(students);

        System.out.println("\nПісля сортування:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

*/
/*
public class StudentSorting {

    public static void mergeSortIterative(Student[] students) {
        int n = students.length;
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(students, left, mid, right);
            }
        }
    }
    private static void merge(Student[] students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        System.arraycopy(students, left, leftArray, 0, n1);
        System.arraycopy(students, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].completedLabs >= rightArray[j].completedLabs) {
                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Іванов", "Олексій", "Математика", 5),
                new Student("Петров", "Андрій", "Фізика", 3),
                new Student("Сидоров", "Максим", "Інформатика", 7),
                new Student("Коваленко", "Ірина", "Математика", 5),
                new Student("Мельник", "Ольга", "Фізика", 4)
        };

        System.out.println("Перед сортуванням:");
        for (Student s : students) {
            System.out.println(s);
        }

        mergeSortIterative(students);

        System.out.println("\nПісля сортування:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
*/