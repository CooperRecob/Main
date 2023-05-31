package com.projects.pokemonMapGen;

import java.awt.Color;

import javax.swing.*;

public class Main {
    static String[][] map = new String[15][15];
    static String selectedType = "shgs";
    public static void main(String[] args) {
        // this jframe will be a pokemon map creator that will allow you to make a map
        // and save it to a file
        // make a 15x15 board of buttons that when clicked once they will place the tile
        // and when clicked again they will be null
        // make the buttons the same size
        // make a button that will switch the type of tile that will be placed
        // make a save button that will save the map to a file
        // make a load button that will load a map from a file
        // make a button that will generate a random map with general pokemon map rules
        /*
         * Key:
         * Short grass:shgs
         * Long Grass:lggs
         * Tree:logs
         * Path: path
         */

        JFrame frame = new JFrame("Pokemon Map Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JButton[][] buttons = new JButton[15][15];

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                buttons[x][y] = new JButton();
                buttons[x][y].setBounds(x * 40, y * 40, 40, 40);
                panel.add(buttons[x][y]);
            }
        }

        JButton lGrass = new JButton("Long Grass");
        lGrass.setBounds(600, 100, 150, 50);
        panel.add(lGrass);

        JButton sGrass = new JButton("Short Grass");
        sGrass.setBounds(600, 160, 150, 50);
        panel.add(sGrass);

        JButton path = new JButton("Path");
        path.setBounds(600, 220, 150, 50);
        panel.add(path);

        JButton tree = new JButton("Tree");
        tree.setBounds(600, 280, 150, 50);
        panel.add(tree);

        JButton save = new JButton("Save");
        save.setBounds(600, 340, 150, 50);
        panel.add(save);

        JButton load = new JButton("Load");
        load.setBounds(600, 400, 150, 50);
        panel.add(load);

        JButton random = new JButton("Random");
        random.setBounds(600, 460, 150, 50);
        panel.add(random);

        lGrass.addActionListener(e -> {
            selectedType = "lggs";
        });

        sGrass.addActionListener(e -> {
            selectedType = "shgs";
        });

        path.addActionListener(e -> {
            selectedType = "path";
        });

        tree.addActionListener(e -> {
            selectedType = "logs";
        });

        // when a button is clicked it will place the selected type of tile
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                int finalX = x;
                int finalY = y;
                buttons[x][y].addActionListener(e -> {
                    if (map[finalX][finalY] == null) {
                        map[finalX][finalY] = selectedType;
                        //switch case
                        switch (selectedType) {
                            case "lggs":
                                buttons[finalX][finalY].setBackground(Color.GREEN.darker());
                                break;
                            case "shgs":
                                buttons[finalX][finalY].setBackground(Color.GREEN);
                                break;
                            case "path":
                                buttons[finalX][finalY].setBackground(Color.GRAY);
                                break;
                            case "logs":
                                buttons[finalX][finalY].setBackground(Color.BLACK);
                                break;
                        }
                    } else {
                        map[finalX][finalY] = null;
                        buttons[finalX][finalY].setBackground(null);
                    }
                });
            }
        }

        save.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog("Enter the name of the file you want to save to");
            FileIO.saveMap(map, fileName);
        });

        load.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog("Enter the name of the file you want to load");
            map = FileIO.loadMap(fileName);
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    if (map[x][y] != null) {
                        //switch case
                        switch (map[x][y]) {
                            case "lggs":
                                buttons[x][y].setBackground(Color.GREEN.darker());
                                break;
                            case "shgs":
                                buttons[x][y].setBackground(Color.GREEN);
                                break;
                            case "path":
                                buttons[x][y].setBackground(Color.GRAY);
                                break;
                            case "logs":
                                buttons[x][y].setBackground(Color.BLACK);
                                break;
                        }
                    } else {
                        buttons[x][y].setBackground(null);
                    }
                }
            }
        });

        random.addActionListener(e -> {
            map = MapGen.generateMap();
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    if (map[x][y] != null) {
                        //switch case
                        switch (map[x][y]) {
                            case "lggs":
                                buttons[x][y].setBackground(Color.GREEN.darker());
                                break;
                            case "shgs":
                                buttons[x][y].setBackground(Color.GREEN);
                                break;
                            case "path":
                                buttons[x][y].setBackground(Color.GRAY);
                                break;
                            case "logs":
                                buttons[x][y].setBackground(Color.BLACK);
                                break;
                        }
                    } else {
                        buttons[x][y].setBackground(null);
                    }
                }
            }
        });
    }
}
