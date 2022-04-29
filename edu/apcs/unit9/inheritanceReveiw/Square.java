package edu.apcs.unit9.inheritanceReveiw;

public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        return 4 * getWidth();
    }

    public String toString() {
        return "Square: side = " + getSide();
    }
}
