// Файл: Main.java

import classes.BinaryTree;
import classes.Student;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Для консистентності, використовується "Жінка" замість "Дівчина"
        tree.insert(new Student("Півень", "Максим", 123456, 2, "Чоловік", "Київ"));
        tree.insert(new Student("Слабка", "Анна", 234567, 1, "Жінка", "Гуртожиток"));
        tree.insert(new Student("Небінарний", "Володимир", 345678, 3, "Невизначений", "Івано-Франківськ"));
        tree.insert(new Student("Іванова", "Марія", 456789, 1, "Жінка", "Гуртожиток"));
        tree.insert(new Student("Тимошенко", "Юлія", 567890, 1, "Жінка", "Гуртожиток"));

        tree.printPostorder();

        tree.findStudentsByCriterion();

        tree.removeStudentsByCriterion();
        System.out.println("\nДерево після видалення студенток 1-го курсу, що проживають у гуртожитку:");
        tree.printPostorder();
    }
}