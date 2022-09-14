package com.projects.minesweeper;

public class Mine {
    private boolean exploded;
    private boolean flagged;

    public Mine() {
        exploded = false;
        flagged = false;
    }

    public boolean getExposionStatus() {
        return exploded;
    }

    public boolean getFlagStatus() {
        return flagged;
    }

    public void flag(boolean input) {
        flagged = input;
    }

    public void explode() {
        exploded = true;
    }
}
