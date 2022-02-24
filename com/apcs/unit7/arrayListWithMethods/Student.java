package com.apcs.unit7.arrayListWithMethods;

public class Student {
    private String name;
    private int missingAssingments;
    private double gradePercentage;

    public Student(String name, int missingAssignments, double gradePercentage) {
        this.name = name;
        this.missingAssingments = missingAssignments;
        this.gradePercentage = gradePercentage;
    }

    public double getGradePercentage() {
        return gradePercentage;
    }

    public int getMissingAssingments() {
        return missingAssingments;
    }
    
    public String getName() {
        return name;
    }
}
