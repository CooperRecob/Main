package edu.uww.cs220.project1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);
        Scanner intinput = new Scanner(System.in);
        boolean ordering = true;
        int totalOrders = 0;
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

            while (addingItems) {
                System.out.println("What would you like to add to your order?");
                System.out.println("1. Burger");
                System.out.println("2. Fries");
                System.out.println("3. Drink");

                int choice = intinput.nextInt();

                if (choice == 1) {
                    System.out.println("What kind of burger would you like?");
                    System.out.println("1. Cheeseburger");
                    System.out.println("2. Bacon Cheeseburger");
                    System.out.println("3. Double Cheeseburger");

                    int burgerChoice = intinput.nextInt();

                    if (burgerChoice == 1) {
                        System.out.println("How many cheeseburgers would you like?");
                        int burgerAmount = intinput.nextInt();

                        order.addItem(new Item("Cheeseburger", 3.99), burgerAmount);
                    } else if (burgerChoice == 2) {
                        System.out.println("How many bacon cheeseburgers would you like?");
                        int burgerAmount = intinput.nextInt();

                        order.addItem(new Item("Bacon Cheeseburger", 4.99), burgerAmount);
                    } else if (burgerChoice == 3) {
                        System.out.println("How many double cheeseburgers would you like?");
                        int burgerAmount = intinput.nextInt();

                        order.addItem(new Item("Double Cheeseburger", 5.99), burgerAmount);
                    }
                } else if (choice == 2) {
                    System.out.println("What kind of fries would you like?");
                    System.out.println("1. Small Fries");
                    System.out.println("2. Medium Fries");
                    System.out.println("3. Large Fries");

                    int friesChoice = intinput.nextInt();

                    if (friesChoice == 1) {
                        System.out.println("How many small fries would you like?");
                        int friesAmount = intinput.nextInt();

                        order.addItem(new Item("Small Fries", 1.99), friesAmount);
                    } else if (friesChoice == 2) {
                        System.out.println("How many medium fries would you like?");
                        int friesAmount = intinput.nextInt();

                        order.addItem(new Item("Medium Fries", 2.99), friesAmount);
                    } else if (friesChoice == 3) {
                        System.out.println("How many large fries would you like?");
                        int friesAmount = intinput.nextInt();

                        order.addItem(new Item("Large Fries", 3.99), friesAmount);
                    }
                } else if (choice == 3) {
                    System.out.println("What kind of drink would you like?");
                    System.out.println("1. Small Drink");
                    System.out.println("2. Medium Drink");
                    System.out.println("3. Large Drink");

                    int drinkChoice = intinput.nextInt();

                    if (drinkChoice == 1) {
                        System.out.println("How many small drinks would you like?");
                        int drinkAmount = intinput.nextInt();

                        order.addItem(new Item("Small Drink", 1.99), drinkAmount);
                    } else if (drinkChoice == 2) {
                        System.out.println("How many medium drinks would you like?");
                        int drinkAmount = intinput.nextInt();

                        order.addItem(new Item("Medium Drink", 2.49), drinkAmount);
                    } else if (drinkChoice == 3) {
                        System.out.println("How many large drinks would you like?");
                        int drinkAmount = intinput.nextInt();

                        order.addItem(new Item("Large Drink", 2.99), drinkAmount);
                    }
                } else {
                    System.out.println("Invalid choice");
                }

                System.out.println("Would you like to add an item to your order? (y/n)");
                String addAnother = textInput.nextLine();

                if (addAnother.equals("n")) {
                    addingItems = false;
                }
            }

            // Print the order
            System.out.println("------------\nOrder #" + order.getOrderNumber());
            System.out.println("Customer: " + order.getCustomerName());
            System.out.println("Items:");

            for (int i = 0; i < order.getItems().size(); i++) {
                System.out.println(order.getItems().get(i).getName() + " x" + order.getItems().get(i).getQuantity()
                        + " $" + order.getItems().get(i).getPrice());
            }

            double orderTotal = Math.round(order.getTotalPrice() * 100.0) / 100.0;

            System.out.println("Your Total is $" + orderTotal);
            System.out.println("------------");

            // Ask user if this order is correct
            System.out.println("Is this order correct? (y/n)");
            String correct = textInput.nextLine();

            if (correct.equals("y")) {

                // Ask the user how they would like to pay
                System.out.println("How would you like to pay?");
                System.out.println("1. Cash");
                System.out.println("2. Card");

                int paymentChoice = intinput.nextInt();

                if (paymentChoice == 1) {
                    System.out.println("How much cash are you paying with?");
                    double cash = intinput.nextDouble();

                    if (cash < orderTotal) {
                        System.out.println("You do not have enough money to pay for this order.");
                        totalOrders++;
                    } else {
                        System.out.println("Your change is $" + Math.round((cash - orderTotal) * 100.0) / 100.0);
                        orders.add(order);
                        totalOrders++;
                    }
                    ;
                } else if (paymentChoice == 2) {
                    System.out.println("You have been charged $" + orderTotal);
                    orders.add(order);
                    totalOrders++;
                } else {
                    System.out.println("Invalid choice");
                }

                // Ask the user if they would like to order again
                System.out.println("\nWould you like to order again? (y/n)");
                String response = textInput.nextLine();
                if (response.equals("n")) {
                    ordering = false;
                }
            }
        }

        // Print all orders
        System.out.println("------------");
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Proccessed Orders:" + orders.size());
        System.out.println("Cancelled Orders: " + (totalOrders - orders.size()));

        // Combines all orders into one list of items so that all like items are grouped
        ArrayList<Item> totalItemsPurchaced = new ArrayList<Item>();

        for (int i = 0; i < orders.size(); i++) {
            for (int j = 0; j < orders.get(i).getItems().size(); j++) {
                boolean found = false;
                for (int k = 0; k < totalItemsPurchaced.size(); k++) {
                    if (orders.get(i).getItems().get(j).getName().equals(totalItemsPurchaced.get(k).getName())) {
                        totalItemsPurchaced.get(k).setQuantity(totalItemsPurchaced.get(k).getQuantity()
                                + orders.get(i).getItems().get(j).getQuantity());
                        found = true;
                    }
                }
                if (!found) {
                    totalItemsPurchaced.add(orders.get(i).getItems().get(j));
                }
            }
        }

        // Print out all the items purchased with their quantity and total price

        System.out.println("Total Items Purchased:");

        for (int i = 0; i < totalItemsPurchaced.size(); i++) {
            System.out.println(totalItemsPurchaced.get(i).getName() + " x" + totalItemsPurchaced.get(i).getQuantity()
                    + " - $" + Math.round(totalItemsPurchaced.get(i).getPrice() * 100.0) / 100.0);
        }

        System.out.print("Total Sales: ");

        double totalSales = 0;
        for (int i = 0; i < orders.size(); i++) {
            totalSales += orders.get(i).getTotalPrice();
        }

        System.out.println("$" + Math.round(totalSales * 100.0) / 100.0);
        System.out.println("------------");

        // Print this to a text file
        try {
            PrintWriter writer = new PrintWriter("orders.txt", "UTF-8");

            writer.println("Total Orders: " + totalOrders);
            writer.println("Proccessed Orders:" + orders.size());
            writer.println("Cancelled Orders: " + (totalOrders - orders.size()));

            writer.println("Total Items Purchased:");

            for (int i = 0; i < totalItemsPurchaced.size(); i++) {
                writer.println(totalItemsPurchaced.get(i).getName() + " x" + totalItemsPurchaced.get(i).getQuantity()
                        + " - $" + Math.round(totalItemsPurchaced.get(i).getPrice() * 100.0) / 100.0);
            }

            writer.print("Total Sales: ");

            writer.println("$" + Math.round(totalSales * 100.0) / 100.0);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }

        textInput.close();
        intinput.close();
    }
}