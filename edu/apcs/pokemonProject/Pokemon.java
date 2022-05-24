package edu.apcs.pokemonProject;

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
        type = "electric";
        catchType = "normal";
        status = "healthy";
        levelUp(level);
        this.currentHealth = currentHealth;
        maxHealth = 60;
        damageMultiplier = 1;
        defenseMultiplier = 1;
        this.attacks = attacks;
    }

    public void attack(Attack attack, Pokemon opponent) {
        int damage = (int) (attack.getDamage() * damageMultiplier);

        if (strongTo(attack.getType(), opponent.getType())) {
            System.out.println("It's super effective!");
            damage *= 2;
        } else if (weakTo(attack.getType(), opponent.getType())) {
            System.out.println("It's not very effective...");
            damage /= 2;
        }

        opponent.takeDamage(damage);
    }

    private boolean strongTo(String attackingType, String defendingType ) {
        return attackingType.equals("fire") && defendingType.equals("grass") ||
                attackingType.equals("water") && defendingType.equals("fire") ||
                attackingType.equals("grass") && defendingType.equals("water") ||
                attackingType.equals("electric") && defendingType.equals("water") ||
                attackingType.equals("water") && defendingType.equals("electric") ||
                attackingType.equals("electric") && defendingType.equals("grass") ||
                attackingType.equals("grass") && defendingType.equals("electric");
    }

    private boolean weakTo(String attackingType, String defendingType) {
        return attackingType.equals("grass") && defendingType.equals("fire") ||
                attackingType.equals("fire") && defendingType.equals("water") ||
                attackingType.equals("water") && defendingType.equals("grass") ||
                attackingType.equals("electric") && defendingType.equals("grass") ||
                attackingType.equals("grass") && defendingType.equals("electric");
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
