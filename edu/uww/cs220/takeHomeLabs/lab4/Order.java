package edu.uww.cs220.takeHomeLabs.lab4;

import java.util.HashMap;

public class Order {
    private int orderNumber;
    private String customerName;
    private HashMap<String, Integer> itemsOrdered;
    private HashMap<String, Double> menu;

    /*  Public methods: (1) at least one constructor, (2) get/set methods that provide public interfaces for instance variables, (3) calculate and return total amount, (4) calculate and return tax amount, and (5) calculate and return final bill amount. (6) a print method that print out all order related information as an invoice/receipt and display it in console. */

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.itemsOrdered = new HashMap<>();
        this.menu = new HashMap<>();

        // Add some items to menu
        this.menu.put("Apple", 0.99);
        this.menu.put("Orange", 0.89);
        this.menu.put("Banana", 0.79);
        this.menu.put("Grapes", 1.99);
        this.menu.put("Peach", 1.49);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, Integer> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(HashMap<String, Integer> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }   

    public HashMap<String, Double> getMenu() {
        return menu;
    }

    public void setMenu(HashMap<String, Double> menu) {
        this.menu = menu;
    }

    public double calculateTotalAmount() {
        double total = 0.0;
        for (String item : this.itemsOrdered.keySet()) {
            total += this.itemsOrdered.get(item) * this.menu.get(item);
        }
        return total;
    }

    public double calculateTaxAmount() {
        return this.calculateTotalAmount() * 0.05;
    }

    public double calculateFinalBillAmount() {
        return this.calculateTotalAmount() + this.calculateTaxAmount();
    }

    public void print() {
        System.out.println("Order Number: " + this.orderNumber);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Items Ordered:");
        for (String item : this.itemsOrdered.keySet()) {
            System.out.println("\t" + item + ": " + this.itemsOrdered.get(item));
        }
        System.out.printf("Total Amount: %.2f %n", this.calculateTotalAmount());
        System.out.printf("Tax Amount: %.2f %n", this.calculateTaxAmount());
        System.out.printf("Final Bill Amount: %.2f %n", this.calculateFinalBillAmount());
    }

    public void addItem(String item, int quantity) {
        if (this.itemsOrdered.containsKey(item)) {
            this.itemsOrdered.put(item, this.itemsOrdered.get(item) + quantity);
        } else {
            this.itemsOrdered.put(item, quantity);
        }
    }

    public void removeItem(String item, int quantity) {
        if (this.itemsOrdered.containsKey(item)) {
            if (this.itemsOrdered.get(item) - quantity <= 0) {
                this.itemsOrdered.remove(item);
            } else {
                this.itemsOrdered.put(item, this.itemsOrdered.get(item) - quantity);
            }
        }
    }

    public void clearItems() {
        this.itemsOrdered.clear();
    }
}
