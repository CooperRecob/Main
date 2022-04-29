package edu.apcs.unit9.polymorphism;

public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String toString() {
        return "Book: " + title + " by " + author + " (" + pages + " pages)";
    }

    public int getPages() {
        return pages;
    }
}
