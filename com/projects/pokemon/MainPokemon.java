package com.projects.pokemon;

import javax.swing.*;
import com.projects.pokemonMapGen.FileIO;

public class MainPokemon {

    // read the map from file
    static String[][][][] mapArray = {
            { FileIO.loadMap("com/projects/pokemon/maps/map4"), FileIO.loadMap("com/projects/pokemon/maps/map5"),
                    FileIO.loadMap("com/projects/pokemon/maps/map6") },
            { FileIO.loadMap("com/projects/pokemon/maps/map"), FileIO.loadMap("com/projects/pokemon/maps/map2"),
                    FileIO.loadMap("com/projects/pokemon/maps/map3") },
            { FileIO.loadMap("com/projects/pokemon/maps/map7"), FileIO.loadMap("com/projects/pokemon/maps/map8"),
                    FileIO.loadMap("com/projects/pokemon/maps/map9") }

    };

    static String[][] map = mapArray[1][1];

    static int mapArrayX = 1;
    static int mapArrayY = 1;

    static JFrame frame = new JFrame("Pokemon");

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(16 * 32, 16 * 32);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);

        // create the character
        JLabel character = new JLabel(new ImageIcon("com/projects/pokemon/images/character.png"));
        character.setBounds(2 * 32, 2 * 32, 32, 32);
        frame.add(character);

        JLabel[][] tiles = new JLabel[15][15];

        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                int x = character.getX();
                int y = character.getY();

                // check for collision with lggs and set a 15% chance for an encounter
                if (map[y / 32][x / 32].equals("lggs")) {
                    if (Math.random() < 0.15) {
                        System.out.println("Encounter!");
                        Encounter.encounter();
                    }
                }

                // movement code
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
                    if (x == 0) {
                        character.setLocation(14 * 32, y);
                        map = mapArray[mapArrayX][mapArrayY - 1];
                        mapArrayY--;

                        updateTiles(tiles);
                    } else if (!checkCollision((x - 32) / 32, y / 32)) {
                        character.setLocation(x - 32, y);
                    }
                } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
                    if (x == 14 * 32) {
                        character.setLocation(0, y);
                        map = mapArray[mapArrayX][mapArrayY + 1];
                        mapArrayY++;

                        updateTiles(tiles);
                    } else if (!checkCollision((x + 32) / 32, y / 32)) {
                        character.setLocation(x + 32, y);
                    }
                } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
                    if (y == 0) {
                        character.setLocation(x, 14 * 32);
                        map = mapArray[mapArrayX - 1][mapArrayY];
                        mapArrayX--;

                        updateTiles(tiles);
                    } else if (!checkCollision(x / 32, (y - 32) / 32)) {
                        character.setLocation(x, y - 32);
                    }
                } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
                    if (y == 14 * 32) {
                        character.setLocation(x, 0);
                        map = mapArray[mapArrayX + 1][mapArrayY];
                        mapArrayX++;

                        updateTiles(tiles);
                    } else if (!checkCollision(x / 32, (y + 32) / 32)) {
                        character.setLocation(x, y + 32);
                    }
                }
            }
        });

        // create the map
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                tiles[row][col] = new JLabel(
                        new ImageIcon("com/projects/pokemon/images/" + map[row][col] + ".png"));
                tiles[row][col].setBounds(col * 32, row * 32, 32, 32);
                frame.add(tiles[row][col]);
            }
        }

        frame.setVisible(true);
    }

    public static void updateTiles(JLabel[][] tiles) {
        for (int j = 0; j < 15; j++) {
            for (int k = 0; k < 15; k++) {
                tiles[j][k].setIcon(new ImageIcon("com/projects/pokemon/images/" + map[j][k] + ".png"));
            }
        }
    }

    public static boolean checkCollision(int x, int y) {
        if (map[y][x].equals("logs")) {
            return true;
        }
        return false;
    }
}
