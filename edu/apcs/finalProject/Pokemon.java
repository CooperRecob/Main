package edu.apcs.finalProject;

import java.util.HashMap;

public class Pokemon {
    private String name;
    private String type;
    private String status;
    private int level;
    private int currentHealth;
    private int maxHealth;
    private double damageMultiplier;
    private double defenseMultiplier;
    private Attack[] attacks;
    private HashMap<String, String> weaknessesAndStrengths = new HashMap<>(){{
        put("fire", "water");
        put("water", "electric");
        put("grass", "fire");
        put("electric", "grass");
        put("psychic", "bug");
        put("bug", "fire");
        put("rock", "water");
        put("ground", "grass");
        put("flying", "grass");
        put("fighting", "bug");
        put("poison", "grass");
        put("ghost", "ghost");
        put("dark", "dark");
        put("steel", "steel");
        put("fairy", "fighting");
    }};

    public Pokemon(String name, String type, int level, int currentHealth, int maxHealth, Attack[] attacks) {
        this.name = name;
        this.type = type;
        status = "healthy";
        levelUp(level);
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        damageMultiplier = 1;
        defenseMultiplier = 1;
        this.attacks = attacks;
    }

    public Pokemon(int level, int currentHealth, Attack[] attacks) {
        name = "Pikachu";
        type = "Electric";
        status = "healthy";
        levelUp(level);
        this.currentHealth = currentHealth;
        maxHealth = 60;
        damageMultiplier = 1;
        defenseMultiplier = 1;
        this.attacks = attacks;
    }

    public void attack(Attack attackName, Pokemon opponent) {
        int damage = (int) (attackName.getDamage() * damageMultiplier);
        if(type.equals(opponent.getType())) {
            damage *= 2;
        } else if(opponent.getWeaknessesAndStrengths().containsKey(type)) {
            damage *= 0.5;
        }
        opponent.takeDamage(damage);
    }

    void takeDamage(int damage) {
        currentHealth -= damage;
    }

    public void levelUp() {
        level++;

        if (level < 60) {
            maxHealth += 10;
            damageMultiplier += 0.10;
        } else {
            maxHealth += 20;
            damageMultiplier += 0.20;
        }
    }

    public void levelUp(int numLevels) {
        for (int i = 0; i < numLevels; i++) {
            level++;

            if (level < 60) {
                maxHealth += 10;
                damageMultiplier += 0.10;
            } else {
                maxHealth += 20;
                damageMultiplier += 0.20;
            }
        }
    }

    public void heal(int amount) {
        if((currentHealth += amount) > maxHealth) {
            currentHealth = maxHealth;
        } else {
            currentHealth += amount;
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public double getDefenseMultiplier() {
        return defenseMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public void setDefenseMultiplier(double defenseMultiplier) {
        this.defenseMultiplier = defenseMultiplier;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public HashMap<String, String> getWeaknessesAndStrengths() {
        return weaknessesAndStrengths;
    }

    public void setAttack(int index, Attack attack) {
        attacks[index] = attack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return name + ": type " + type + ", level " + level + ", health " + currentHealth + "/" + maxHealth;
    }
}
