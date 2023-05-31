package edu.apcs.helpingQadry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        // jframe to display ness.png
        // move the image around with arrow keys
        // make the label  visible and make his size 20px by 20px and make it scaled down so te entire picture is visible
        // make the label move 10px at a time

        JFrame frame = new JFrame("Ness");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        
        ImageIcon icon = new ImageIcon("C:/vscode/edu/apcs/helpingQadry/Ness.png");
        //scale the image
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 20, 20);
        frame.add(label);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                int x = label.getX();
                int y = label.getY();
                if (e.getKeyCode() == 37) {
                    label.setLocation(x - 10, y);
                } else if (e.getKeyCode() == 38) {
                    label.setLocation(x, y - 10);
                } else if (e.getKeyCode() == 39) {
                    label.setLocation(x + 10, y);
                } else if (e.getKeyCode() == 40) {
                    label.setLocation(x, y + 10);
                }
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
    }
}
