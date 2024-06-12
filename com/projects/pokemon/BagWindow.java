package com.projects.pokemon;

import javax.swing.*;

public class BagWindow {
    public static void bag() {
        JFrame frame = new JFrame("Bag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(16 * 32, 16 * 32);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
    }
}
