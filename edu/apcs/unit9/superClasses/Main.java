package edu.apcs.unit9.superClasses;

public class Main {
    public static void main(String[] args) {
        Employee josh = new Employee("Joshua");
        josh.work(9);

        Teacher sarb = new Teacher("Comp Sci", "Mr. Sarbacker");
        sarb.work(10);

        ComputerProgrammer matt = new ComputerProgrammer("Python", "Matt");
        matt.work(12);

        Doctor phil = new Doctor(0, "Dr. Phil");
        phil.work(3);
    }
}
