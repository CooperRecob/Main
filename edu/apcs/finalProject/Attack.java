package edu.apcs.finalProject;

public class Attack {
    private String name;
    private String type;
    private int damage;

    public Attack(String name, String type, int damage) {
        this.name = name;
        this.type = type;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }
}
