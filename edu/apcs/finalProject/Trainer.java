package edu.apcs.finalProject;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> team;

    public Trainer(String name, ArrayList<Pokemon> team) {
        this.name = name;
        this.team = team;
    }

    public boolean isOutOfPokemon() {
        for (Pokemon pokemon : team) {
            if(pokemon.getCurrentHealth() > 0) {
                return false;
            }
        }
        return true;
    }

    public void useItem(Item item, Pokemon pokemon) {
        pokemon.heal(item.getHealAmount());
        pokemon.setDamageMultiplier(item.getAttackPercentage());
        pokemon.setDefenseMultiplier(item.getDefensePercentage());
    }

    public String getName() {
        return name;
    }

    public ArrayList<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Pokemon> team) {
        this.team = team;
    }

    public void addPokemon(Pokemon pokemon) {
        team.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        team.remove(pokemon);
    }

    public String toString() {
        String output = name + ":";
        for (Pokemon pokemon : team) {
            output += "\n" + pokemon.toString();
        }
        return output;
    }
}
