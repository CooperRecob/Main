package com.projects.uiapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        // Create a button that makes a line of text appear
        JButton button = new JButton("Click me");
        button.addActionListener(e -> {
            JLabel label = new JLabel("Hello World");
            frame.add(label);
            frame.revalidate();
        });
        button.setBounds(100, 100, 100, 100);

        // Add the button to the frame
        frame.add(button);

        // Set the frame's size and make it visible
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
