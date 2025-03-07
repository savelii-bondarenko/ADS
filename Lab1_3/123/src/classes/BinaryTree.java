// Файл: classes/BinaryTree.java
package classes;

import java.util.ArrayList;

public class BinaryTree
{
    private Node _root;

    public void insert(Student student)
    {
        _root = insertRec(_root, student);
    }

    private Node insertRec(Node root, Student student)
    {
        if (root == null)
        {
            return new Node(student);
        }
        if (student.studentID < root.student.studentID)
        {
            root.left = insertRec(root.left, student);
        } else if (student.studentID > root.student.studentID)
        {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public void printPostorder()
    {
        System.out.println("Postorder traversal:");
        printPostorderRec(_root);
    }

    private void printPostorderRec(Node root)
    {
        if (root != null)
        {
            printPostorderRec(root.left);
            printPostorderRec(root.right);
            System.out.println(root.student);
        }
    }

    public void findStudentsByCriterion()
    {
        ArrayList<Student> students = new ArrayList<>();
        findRec(_root, students);

        System.out.println("\nСтудентки 1 курсу що проживають у гуртожитку:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void findRec(Node root, ArrayList<Student> students)
    {
        if (root != null)
        {
            findRec(root.left, students);

            // Змінено "Жінка" на перевірку обох варіантів: "Жінка" або "Дівчина"
            if (root.student.course == 1 &&
                    root.student.location.equals("Гуртожиток") &&
                    (root.student.sex.equals("Жінка") || root.student.sex.equals("Дівчина")))
            {
                students.add(root.student);
            }

            findRec(root.right, students);
        }
    }

    public void removeStudentsByCriterion()
    {
        _root = removeRec(_root);
    }

    private Node removeRec(Node root)
    {
        if (root == null) {
            return null;
        }

        // Рекурсивно обрабатываем левое и правое поддерево
        root.left = removeRec(root.left);
        root.right = removeRec(root.right);

        // Змінено "Жінка" на перевірку обох варіантів: "Жінка" або "Дівчина"
        if (root.student.course == 1 &&
                root.student.location.equals("Гуртожиток") &&
                (root.student.sex.equals("Жінка") || root.student.sex.equals("Дівчина")))
        {
            // Удаляем узел — обрабатываем три случая:

            // 1. Узел не имеет детей (листья)
            if (root.left == null && root.right == null) {
                return null;
            }

            // 2. Узел имеет только одного потомка
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // 3. Узел имеет двух потомков
            // Находим минимальный элемент в правом поддереве
            Node minNode = findMin(root.right);
            root.student = minNode.student;
            root.right = removeRec(root.right);
        }

        return root;
    }

    private Node findMin(Node root)
    {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}