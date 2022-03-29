package com.apcs.unit9.overwritingMethods;

public class BoringEmployee extends Person {
    int ID;
    double wage;
    String jobTitle;

    public BoringEmployee(int ID, double wage, String jobTitle) {
        super();
        this.ID = ID;
        this.wage = wage;
        this.jobTitle = jobTitle;
    }

    public void work(int hours) {
        System.out.println(getName() + " am working in a boring cubicle for " + hours + " hours");
    }

    public void beBored(int hours) {
        System.out.println("I am bored in my cubicle for " + hours + " hours");
    }

    public void getPaid() {
        System.out.println("I am getting paid $" + wage +  " per hour");
    }

    public String toString() {
        return getName() + "is a boring employee";
    }
}
