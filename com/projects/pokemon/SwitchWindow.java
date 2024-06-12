package com.projects.pokemon;

import javax.swing.*;

public class SwitchWindow {
    public static void switchPokemon() {
        JFrame frame = new JFrame("Switch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(16 * 32, 16 * 32);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
    }
}
