package edu.apcs.unit9.superClasses;

public class ComputerProgrammer extends Employee {
    private String language;

    public ComputerProgrammer(String language, String name) {
        super(name);
        this.language = language;
    }

    public void work(int hours) {
        System.out.println(super.getName() + " coded " + language + " for " + hours + " hours");
    }
}
