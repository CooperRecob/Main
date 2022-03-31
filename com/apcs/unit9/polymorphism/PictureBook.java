package com.apcs.unit9.polymorphism;

public class PictureBook extends Book{
    private int ageOfReader;

    public PictureBook(String title, String author, int pages, int ageOfReader) {
        super(title, author, pages);
        this.ageOfReader = ageOfReader;
    }

    public boolean isOldEnough(int age) {
        if (age >= ageOfReader) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "PictureBook: " + super.toString() + " (" + ageOfReader + " years old)";
    }
}
