class Student {
    String lastName;
    String firstName;
    int course;
    String group;
    String city;

    public Student(String lastName, String firstName, int course, String group, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.group = group;
        this.city = city;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", Курс: " + course + ", Група: " + group + ", Місто: " + city;
    }
}