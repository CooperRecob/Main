package com.projects.chess;

public class Peice {
    private boolean team;
    private String name;
    private int peiceNum;

    public Peice(boolean team, String name, int peiceNum) {
        this.team = team;
        this.name = name;
        this.peiceNum = peiceNum;
    }

    public int getPeiceNum() {
        return peiceNum;
    }

    public String getName() {
        return name;
    }

    public boolean getTeam() {
        return team;
    }
}
