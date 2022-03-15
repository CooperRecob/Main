package com.apcs.unit9.superClasses;

public class Doctor extends Employee{
    private int livesSaved;

    public Doctor(int livesSaved, String name) {
        super(name);
        this.livesSaved = livesSaved;
    }

    public void work(int hours) {
        System.out.println(super.getName() + " has saved " + livesSaved + " lives");
    }
}
