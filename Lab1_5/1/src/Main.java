public class Main {
    public static void main(String[] args) {
        StudentArray studentArray = new StudentArray();

        studentArray.addStudent(new Student("Іваненко", "Олег", 2, "КН-21", "Київ"));
        studentArray.addStudent(new Student("Петров", "Іван", 3, "КН-31", "Львів"));
        studentArray.addStudent(new Student("Сидоров", "Павло", 1, "КН-11", "Донецьк"));
        studentArray.addStudent(new Student("Мельник", "Андрій", 4, "КН-41", "Харків"));
        studentArray.addStudent(new Student("Ткаченко", "Марія", 2, "КН-22", "Одеса"));
        studentArray.addStudent(new Student("Гриценко", "Юрій", 3, "КН-32", "Львів"));
        studentArray.addStudent(new Student("Коваленко", "Оксана", 1, "КН-12", "Київ"));
        studentArray.addStudent(new Student("Федоренко", "Василь", 2, "КН-23", "Харків"));
        studentArray.addStudent(new Student("Шевченко", "Ірина", 4, "КН-42", "Одеса"));
        studentArray.addStudent(new Student("Бондар", "Микола", 3, "КН-33", "Полтава"));
        studentArray.addStudent(new Student("Дмитренко", "Артем", 1, "КН-13", "Донецьк"));
        studentArray.addStudent(new Student("Лисенко", "Катерина", 2, "КН-24", "Київ"));
        studentArray.addStudent(new Student("Захарченко", "Віктор", 3, "КН-34", "Львів"));
        studentArray.addStudent(new Student("Романенко", "Олексій", 4, "КН-43", "Харків"));
        studentArray.addStudent(new Student("Кравченко", "Наталя", 1, "КН-14", "Одеса"));
        studentArray.addStudent(new Student("Семенченко", "Дмитро", 2, "КН-25", "Полтава"));
        studentArray.addStudent(new Student("Остапенко", "Юлія", 3, "КН-35", "Київ"));
        studentArray.addStudent(new Student("Павленко", "Максим", 4, "КН-44", "Львів"));
        studentArray.addStudent(new Student("Мартиненко", "Сергій", 1, "КН-15", "Донецьк"));
        studentArray.addStudent(new Student("Корнієнко", "Владислав", 2, "КН-26", "Харків"));

        System.out.println("Список студентів:");
        studentArray.printStudents();

        System.out.println("\nВидалення студентів з Донецька...");

        studentArray.removeStudentIfFromDonetsk();


        System.out.println("\nОновлений список студентів:");
        studentArray.printStudents();
    }
}