package edu.apcs.unit8.arrayAlgorithms;

public class House {
    private double cost;
    private int residents;
    private int rooms;

    public House(double cost, int residents, int rooms) {
        this.cost = cost;
        this.residents = residents;
        this.rooms = rooms;
    }

    public int getResidents() {
        return residents;
    }

    public double getCost() {
        return cost;
    }

    public int getRooms() {
        return rooms;
    }

    public void addRoom() {
        rooms++;
        cost += 5000;
    }

    public String toString() {
        return "cost: " + cost + " residents: " + residents + " rooms: " + rooms;
    }
}
