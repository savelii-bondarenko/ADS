public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        // Додавання студентів
        tree.insert(new Student("Мельник", "Андрій", 4, "КН-41", "Харків"));
        tree.insert(new Student("Ткаченко", "Марія", 2, "КН-22", "Одеса"));
        tree.insert(new Student("Петров", "Іван", 3, "КН-31", "Львів"));
        tree.insert(new Student("Іваненко", "Олег", 2, "КН-21", "Київ"));
        tree.insert(new Student("Сидоров", "Павло", 1, "КН-11", "Донецьк"));
        tree.insert(new Student("Бойко", "Анна", 1, "КН-13", "Дніпро"));
        tree.insert(new Student("Гуменюк", "Олександр", 2, "КН-23", "Івано-Франківськ"));

        System.out.println("Список студентів у порядку зростання міста:");
        tree.printInOrder();

        String searchCity = "Харків";
        Student foundStudent = tree.search(searchCity);
        if (foundStudent != null) {
            System.out.println("\nЗнайдений студент з міста " + searchCity + ":");
            System.out.println(foundStudent);
        } else {
            System.out.println("\nСтудента з міста " + searchCity + " не знайдено.");
        }

        System.out.println("\nПеред ротаціями:");
        tree.printInOrder();

        System.out.println("\nРотація вліво:");
        if (tree.getRoot().right != null) {
            tree.getRoot().right = tree.rotateLeft(tree.getRoot().right);
        }
        tree.printInOrder();

        System.out.println("\nРотація вправо:");
        if (tree.getRoot().left != null) {
            tree.getRoot().left = tree.rotateRight(tree.getRoot().left);
        }
        tree.printInOrder();
    }
}



