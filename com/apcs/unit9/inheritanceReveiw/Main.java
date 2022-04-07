package com.apcs.unit9.inheritanceReveiw;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Square(5), new Rectangle(5, 10), new Circle(5) };

        ArrayList<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(new Square(5));
        shapeList.add(new Rectangle(5, 10));
        shapeList.add(new Circle(5));
        shapeList.add(new Square(-10));

        removeNegativeArea(shapeList);

        System.out.println(shapes);
        System.out.println(shapeList);

        System.out.println(totalArea(shapes));
        System.out.println(averageArea(shapeList));
        System.out.println(countEvenAreas(shapeList));
        System.out.println(largestShape(shapes));
        System.out.println(smallestShape(shapeList));

    }

    public static double totalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public static double averageArea(ArrayList<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea / shapes.size();
    }

    public static int countEvenAreas(ArrayList<Shape> shapes) {
        int count = 0;
        for (Shape shape : shapes) {
            if (shape.getArea() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static Shape largestShape(Shape[] shapes) {
        Shape largestShape = shapes[0];
        for (Shape shape : shapes) {
            if (shape.getArea() > largestShape.getArea()) {
                largestShape = shape;
            }
        }
        return largestShape;
    }

    public static Shape smallestShape(ArrayList<Shape> shapes) {
        Shape smallestShape = shapes.get(0);
        for (Shape shape : shapes) {
            if (shape.getArea() < smallestShape.getArea()) {
                smallestShape = shape;
            }
        }
        return smallestShape;
    }

    public static void removeNegativeArea(ArrayList<Shape> shapes) {
        for (int i = shapes.size(); i > 0; i--) {
            if (shapes.get(i).getArea() < 0) {
                shapes.remove(i);
            }
        }
    }

}
