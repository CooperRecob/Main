package com.apcs.unit9.inheritanceReveiw;

public class Shape {
    private double area;
    private double perimeter;

    public Shape(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public String toString() {
        return "Shape: area = " + area + ", perimeter = " + perimeter;
    }
}