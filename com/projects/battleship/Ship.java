package edu.project.battleship;

public class Ship {
    private int x;
    private int y;
    private boolean hit;

    public Ship(int x, int y) {
        this.x = x;
        this.y = y;
        hit = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
