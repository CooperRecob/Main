package edu.apcs.pokemonProject;

public class Item {
    private String name;
    private int healAmount;
    private double attackPercentage;
    private double defensePercentage;
    private double catchPercentage;

    public Item(String name, int healAmount, double attackPercentage, double defensePercentage) {
        this.name = name;
        this.healAmount = healAmount;
        this.attackPercentage = attackPercentage;
        this.defensePercentage = defensePercentage;
    }

    public Item(String name, double catchPercentage) {
        this.name = name;
        this.catchPercentage = catchPercentage;
    }

    public Item() {
        this.name = "";
        this.healAmount = 0;
        this.attackPercentage = 1;
        this.defensePercentage = 1;
        this.catchPercentage = 1;
    }

    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public double getAttackPercentage() {
        return attackPercentage;
    }

    public double getDefensePercentage() {
        return defensePercentage;
    }

    public double getCatchPercentage() {
        return catchPercentage;
    }
}
