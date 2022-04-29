package edu.apcs.unit6.arrayAlgorithmsAssignment;

public class Classroom {
    private String teacherName;
    private String subject;
    private int studentCapacity;

    public Classroom(String teacherName, String subject, int studentCapacity) {
        this.teacherName = teacherName;
        this.subject = subject;
        this.studentCapacity = studentCapacity;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }
}
