package edu.cs220.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);
        Scanner intinput = new Scanner(System.in);
        boolean ordering = true;
        ArrayList<Order> orders = new ArrayList<Order>();
        

        // Loop so that the user can order multiple times
        while (ordering) {
            // Get the customer name
            System.out.println("Enter customer name: ");
            String customerName = textInput.nextLine();

            // Create a new order
            Order order = new Order(orders.size() + 1, customerName);
            
            // Loop so that the user can add multiple items from a list to the order
            boolean addingItems = true;
            HashMap<Integer, Item> items = new HashMap<Integer, Item>();
            items.put(1, new Item("Apple", 0.99));
            items.put(2, new Item("Banana", 0.59));
            items.put(3, new Item("Orange", 0.79));

            int index = 0;

            while (addingItems) {
                System.out.println("What would you like to add to your order?");
                for (int i = 1; i <= items.size(); i++) {
                    System.out.println(i + ". " + items.get(i).getName());
                }

                int itemNumber = intinput.nextInt();
                System.out.println("How many would you like to add?");
                int quantity = intinput.nextInt();
                
                order.addItem(items.get(itemNumber), quantity);
                order.getItems().get(index).setQuantity(quantity);

                System.out.println("Would you like to add another item? (y/n)");
                String response = textInput.nextLine();
                if (response.equals("n")) {
                    addingItems = false;
                }
                index++;
            }

            // Print the order
            System.out.println("Order #" + order.getOrderNumber());
            System.out.println("Customer: " + order.getCustomerName());
            System.out.println("Items:");

            for (int i = 0; i < order.getItems().size(); i++) {
                System.out.println(order.getItems().get(i).getName() + " x" + order.getItems().get(i).getQuantity() + " $" + (order.getItems().get(i).getPrice() * order.getItems().get(i).getQuantity()));
            }

            System.out.println("Your Total is $" + order.getTotalPrice());

            // Add the order to the list of orders
            orders.add(order);

            // Ask the user if they would like to order again
            System.out.println("\nWould you like to order again? (y/n)");
            String response = textInput.nextLine();
            if (response.equals("n")) {
                ordering = false;
            }
        }
        
        // Print all orders
        System.out.println("Total Orders: " + orders.size());

        System.out.print("Total Sales: ");

        double totalSales = 0.0;
        for (Order order : orders) {
            totalSales += order.getTotalPrice();
        }
        System.out.println("$" + totalSales);

        textInput.close();
        intinput.close();
    }
}