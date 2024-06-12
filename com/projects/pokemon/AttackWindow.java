package com.projects.pokemon;

import javax.swing.*;

public class AttackWindow {
    public static void attack(Pokemon player) {
        JFrame attackFrame = new JFrame("Attack");
        attackFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        attackFrame.setSize(16 * 32, 16 * 32);
        attackFrame.setLocationRelativeTo(null);
        attackFrame.setLayout(null);
        attackFrame.setResizable(false);

        // do a foreach and use getMoves on the player object to get the attacks
        for (String attack : player.getMoves()) {
            JButton attackButton = new JButton(attack);
            attackButton.setSize(128, 64);
            attackFrame.add(attackButton);
        }
    }
}
