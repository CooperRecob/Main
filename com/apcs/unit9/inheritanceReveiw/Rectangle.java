package com.apcs.unit9.inheritanceReveiw;

public class Rectangle extends Shape {
    
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        super(width * height, 2 * (width + height));
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    public String toString() {
        return "Rectangle: width = " + width + ", height = " + height;
    }
}