package classes;

public class Student
{
    String surname;
    String name;
    int course;
    long studentID;
    String sex;
    String location;

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
