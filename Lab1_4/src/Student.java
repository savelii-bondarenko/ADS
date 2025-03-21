class Student {
    String lastName;
    String firstName;
    String subject;
    int completedLabs;

    public Student(String lastName, String firstName, String subject, int completedLabs) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.subject = subject;
        this.completedLabs = completedLabs;
    }

    @Override
    public String toString() {
        return completedLabs + ": " + lastName + " " + firstName + " - "
                + subject + " Лаби " + completedLabs;
    }
}