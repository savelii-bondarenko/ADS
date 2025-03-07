// Файл: classes/Student.java
package classes;

public class Student
{
    public String surname;
    public String name;
    public int course;
    public long studentID;
    public String sex;
    public String location;

    public Student(String surname, String name, long studentID, int course, String sex, String location)
    {
        this.surname = surname;
        this.name = name;
        this.studentID = studentID;
        this.course = course;
        this.location = location;
        this.sex = sex;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + " | Surname: " + surname +
                " | Course: " + course + " | StudentID: " + studentID +
                " | Sex: " + sex + " | Location: " + location;
    }
}