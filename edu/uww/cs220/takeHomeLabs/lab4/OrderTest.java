package edu.uww.cs220.takeHomeLabs.lab4;

import java.util.Scanner;

public class OrderTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter order number: ");
        int orderNumber = input.nextInt();
        input.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = input.nextLine();

        Order order = new Order(orderNumber, customerName);

        boolean ordering = true;

        while (ordering) {
            System.out.println("What would you like to order?");
            String[] items = order.getMenu().keySet().toArray(new String[0]);
            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %s%n", i + 1, items[i]);
            }

            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();
            input.nextLine();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
            input.nextLine();

            order.addItem(items[itemNumber - 1], quantity);

            System.out.print("Would you like to order anything else? (y/n): ");
            String response = input.nextLine();
            if (response.equals("n")) {
                ordering = false;
            }
        }

        order.print();

        input.close();
    }
}
