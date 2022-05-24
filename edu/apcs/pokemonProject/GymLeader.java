package edu.apcs.pokemonProject;

import java.util.ArrayList;

public class GymLeader extends Trainer {
    private String badge;

    public GymLeader(String name, ArrayList<Pokemon> team, String badge) {
        super(name, team);
        this.badge = badge;
    }

    public String getBadge() {
        return badge;
    }
}
