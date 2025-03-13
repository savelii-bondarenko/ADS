package classes;

public class Node
{
    Node left, right;
    Student student;

    public Node(Student student)
    {
        this.student = student;
        left = right = null;
    }
}