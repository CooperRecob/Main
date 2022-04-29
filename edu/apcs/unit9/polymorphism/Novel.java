package edu.apcs.unit9.polymorphism;

public class Novel extends Book {
    private int chapters;

    public Novel(String title, String author, int pages, int chapters) {
        super(title, author, pages);
        this.chapters = chapters;
    }

    public void Open() {
        System.out.println("Fwoop");
    }

    public String toString() {
        return "Novel: " + super.toString() + " (" + chapters + " chapters)";
    }
}
