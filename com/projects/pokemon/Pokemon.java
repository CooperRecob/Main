package com.projects.pokemon;

public class Pokemon {
    private String name;
    private int health;
    private String[] moves;
    private int[] moveDamage;

    public Pokemon(String name, int health, String[] moves, int[] moveDamage) {
        this.name = name;
        this.health = health;
        this.moves = moves;
        this.moveDamage = moveDamage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String[] getMoves() {
        return moves;
    }

    public int[] getMoveDamage() {
        return moveDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    public void setMoveDamage(int[] moveDamage) {
        this.moveDamage = moveDamage;
    }

    public void attack(Pokemon enemy, int move) {
        enemy.setHealth(enemy.getHealth() - moveDamage[move]);
    }

    public void heal(int amount) {
        health += amount;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
