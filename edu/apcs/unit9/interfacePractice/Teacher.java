package edu.apcs.unit9.interfacePractice;

public class Teacher extends Employee implements IEmployee {
    private String name;
    private int students;
    private String subject;
    private double wallet;

    public Teacher(String name, int students, String subject, String position) {
        super(position);
        setWage(15.75);
        this.name = name;
        this.students = students;
        this.subject = subject;
        wallet = 100.0;
    }

    public void pay(double p) {
        wallet += p;
    }

    public void work(int hours) {
        wallet += getWage() * hours;
        System.out.println(name + " taught their " + students + " " + subject + " students for " + hours
                + " hours and made $" + getWage() * hours + " their wallet balance is now $" + wallet);
    }
}
