package com.apcs.unit9.superClasses;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }  

    public String getName() {
        return name;
    }

    public void work(int hours) {
        System.out.println(name + " worked for " + hours + " hours");
    }
}
