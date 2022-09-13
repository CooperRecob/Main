package edu.cs220.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean ordering = true;
        ArrayList<Order> orders = new ArrayList<Order>();
        

        // Loop so that the user can order multiple times
        while (ordering) {
            // Get the customer name
            System.out.println("Enter customer name: ");
            String customerName = input.nextLine();

            // Create a new order
            Order order = new Order(orders.size() + 1, customerName);
            
            // Loop so that the user can add multiple items from a list to the order
            boolean addingItems = true;
            HashMap<Integer, Item> items = new HashMap<Integer, Item>();
            items.put(1, new Item("Apple", 0.99));
            items.put(2, new Item("Banana", 0.59));
            items.put(3, new Item("Orange", 0.79));

            while (addingItems) {
                System.out.println("What would you like to add to your order?");
                for (int i = 1; i <= items.size(); i++) {
                    System.out.println(i + ". " + items.get(i).getName());
                }

                int itemNumber = input.nextInt();
                System.out.println("How many would you like to add?");
                int quantity = input.nextInt();
                
                order.addItem(items.get(itemNumber), quantity);

                System.out.println("Would you like to add another item? (y/n)");
                String response = input.next();
                if (response.equals("n")) {
                    addingItems = false;
                }
            }

            // Print the order
            System.out.println("Order #" + order.getOrderNumber());
            System.out.println("Customer: " + order.getCustomerName());
            System.out.println("Items:");
            for (Item item : order.getItems()) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
            System.out.println("Total: $" + order.getTotalPrice());

            // Ask the user if there are more orders
            System.out.println("Would you like to order anymore? (y/n)");
            String response = input.next();
            if (response.equals("n")) {
                ordering = false;
            }
        }
        
        // Print all orders
        System.out.println("Total Orders: " + orders.size());

        System.out.println("Total Sales");

        int apples = 0;
        int bananas = 0;
        int oranges = 0;

        for (Order order : orders) {
            for (Item item : order.getItems()) {
                if (item.getName().equals("Apple")) {
                    apples++;
                } else if (item.getName().equals("Banana")) {
                    bananas++;
                } else if (item.getName().equals("Orange")) {
                    oranges++;
                }
            }
        }
        System.out.println("Apples: " + apples);
        System.out.println("Bananas: " + bananas);
        System.out.println("Oranges: " + oranges);

        System.out.println("Total Sales: $" + (apples * 0.99 + bananas * 0.59 + oranges * 0.79));
        input.close();
    }
}
