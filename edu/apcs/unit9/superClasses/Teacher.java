package edu.apcs.unit9.superClasses;

public class Teacher extends Employee {
    private String subject;

    public Teacher(String subject, String name) {
        super(name);
        this.subject = subject;
    }

    public void work(int hours) {
        System.out.println(super.getName() + " taught " + subject + " for " + hours + " hours");
    }
}
