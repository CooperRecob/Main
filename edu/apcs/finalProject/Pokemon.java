package edu.apcs.finalProject;

import java.util.HashMap;

public class Pokemon {
    private String name;
    private String type;
    private String catchType;
    private String status;
    private int level;
    private int currentHealth;
    private int maxHealth;
    private double damageMultiplier;
    private double defenseMultiplier;
    private Attack[] attacks;
    private HashMap<String, String> weaknessesAndStrengths = new HashMap<String, String>() {
        {
            put("fire", "grass");
            put("grass", "water");
            put("water", "fire");
            put("electric", "water");
            put("psychic", "ghost");
            put("ghost", "psychic");
        }
    };

    public Pokemon(String name, String type, int level, int currentHealth, int maxHealth, Attack[] attacks) {
        this.name = name;
        this.type = type;
        catchType = "normal";
        status = "healthy";
        levelUp(level);
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        damageMultiplier = 1;
        defenseMultiplier = 1;
        this.attacks = attacks;
    }

    public Pokemon(String name, String type, String catchType, int level, int currentHealth, int maxHealth,
            Attack[] attacks) {
        this.name = name;
        this.type = type;
        this.catchType = catchType;
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
        catchType = "normal";
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

        if (weakTo(attackName.getType())) {
            damage *= 2;
        } else if (strongTo(attackName.getType())) {
            damage /= 2;
        }

        opponent.takeDamage(damage);
    }

    private boolean strongTo(String type) {
        return weaknessesAndStrengths.get(this.type) == type;
    }

    public boolean weakTo(String type) {
        return weaknessesAndStrengths.get(type) == this.type;
    }

    public void takeDamage(int damage) {
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
        if ((currentHealth += amount) > maxHealth) {
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

    public String getCatchType() {
        return catchType;
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
