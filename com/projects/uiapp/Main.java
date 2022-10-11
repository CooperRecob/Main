package com.projects.uiapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My First Swing App");
        frame.setVisible(true);

        JLabel label = new JLabel("Hello World");
        frame.add(label);

        JButton button = new JButton("Click Me");
        frame.add(button);

        JTextField textField = new JTextField("Type Here");
        frame.add(textField);

        JCheckBox checkBox = new JCheckBox("Check Me");
        frame.add(checkBox);

        JRadioButton radioButton = new JRadioButton("Radio Me");
        frame.add(radioButton);

        JTable table = new JTable();
        frame.add(table);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("Open");
        menu.add(menuItem);

        JPopupMenu popupMenu = new JPopupMenu();
        frame.add(popupMenu);

        JMenuItem popupMenuItem = new JMenuItem("Open");
        popupMenu.add(popupMenuItem);

        JToolBar toolBar = new JToolBar();
        frame.add(toolBar);

        JButton toolBarButton = new JButton("Click Me");
        toolBar.add(toolBarButton);
    }
}
