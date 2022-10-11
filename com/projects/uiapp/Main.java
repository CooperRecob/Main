package com.projects.uiapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My First Swing App");
        frame.setVisible(true);

        JLabel label = new JLabel("Hello World");
        frame.add(label);
    }
}
