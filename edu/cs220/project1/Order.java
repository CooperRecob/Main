package edu.cs220.project1;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private String customerName;
    private ArrayList<Item> items;
    private int itemCount;

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.items = new ArrayList<Item>();
        this.itemCount = 0;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void addItem(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
        itemCount += quantity;
    }
}
