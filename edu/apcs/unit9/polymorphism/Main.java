package edu.apcs.unit9.polymorphism;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ShippingItem> items = new ArrayList<>();
        double cost = 0;
        items.add(new ShippingItem(10));
        items.add(new InsuredShippingItem(10, 20));

        for (ShippingItem item : items) {
            cost += item.getCost();
        }

        System.out.println(cost);

        Book[][] books = new Book[2][2];
        books[0][0] = new Book("The Hobbit", "J.R.R. Tolkien", 295);
        books[0][1] = new Novel("The Hobbit", "J.R.R. Tolkien", 295, 12);
        books[1][0] = new Book("The Lord of the Rings", "J.R.R. Tolkien", 495);
        books[1][1] = new Novel("The Lord of the Rings", "J.R.R. Tolkien", 495, 12);

        // Book book2 = new PictureBook("The Very Hungry Caterpiler", "Eric Carl", 15,
        // 3);
    }

    public static void printBookshelf(Book[][] books) {
        for (Book[] row : books) {
            for (Book book : row) {
                System.out.println(book);
            }
        }
    }

    public static void getPages(Book[][] books) {
        int totalPages = 0;
        for (Book[] row : books) {
            for (Book book : row) {
                totalPages += book.getPages();
            }
        }
        System.out.println(totalPages);
    }
}
