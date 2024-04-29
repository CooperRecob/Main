package com.projects.pokemon;

import javax.swing.*;

import com.projects.pokemonMapGen.FileIO;

public class Main {

    // read the map from file

    static String[][][][] mapArray = {
            { FileIO.loadMap("com/projects/pokemon/maps/map4"), FileIO.loadMap("com/projects/pokemon/maps/map5"), FileIO.loadMap("com/projects/pokemon/maps/map6") },
            { FileIO.loadMap("com/projects/pokemon/maps/map"), FileIO.loadMap("com/projects/pokemon/maps/map2"), FileIO.loadMap("com/projects/pokemon/maps/map3") },
            { FileIO.loadMap("com/projects/pokemon/maps/map7"), FileIO.loadMap("com/projects/pokemon/maps/map8"), FileIO.loadMap("com/projects/pokemon/maps/map9") }

    };

    static String[][] map = mapArray[1][1];

    static int mapArrayX = 1;
    static int mapArrayY = 1;

    static JFrame frame = new JFrame("Pokemon");

    public static void main(String[] args) {
        // reads small game areas from file and adds them to a 2d array containing all
        // game areas
        // an area is 15x15 and the large map is a 3x3 of these areas
        // each area is a 2d array of strings
        // each string represents a tile
        // each tile is 32x32 pixels

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(16 * 32, 16 * 32);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(true);

        // create the character
        JLabel character = new JLabel(new ImageIcon("com/projects/pokemon/images/character.png"));
        character.setBounds(2 * 32, 2 * 32, 32, 32);
        frame.add(character);

        // move the character 32 pixels at a time
        // character can't move through logs but can move through shgs, tlgs, and path
        // once the character moves off the screen the map will change to the next map
        // and the character will be moved to the opposite side of the screen
        JLabel[][] tiles = new JLabel[15][15];

        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                int x = character.getX();
                int y = character.getY();

                // movement code
                // if character is on the left edge and trys to move left then move to the right
                // edge
                // if character is on the right edge and trys to move right then move to the
                // left edge
                // if character is on the top edge and trys to move up then move to the bottom
                // edge
                // if character is on the bottom edge and trys to move down then move to the top
                // edge
                // no moving into logs

                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
                    if (x == 0) {
                        character.setLocation(14 * 32, y);
                        map = mapArray[mapArrayX][mapArrayY - 1];
                        mapArrayY--;

                        // update the tiles use j, k
                        for (int j = 0; j < 15; j++) {
                            for (int k = 0; k < 15; k++) {
                                tiles[j][k].setIcon(
                                        new ImageIcon("com/projects/pokemon/images/" + map[j][k] + ".png"));
                            }
                        }

                        frame.repaint();

                    } else if (!checkCollision((x - 32) / 32, y / 32)) {
                        character.setLocation(x - 32, y);
                    }
                } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
                    if (x == 14 * 32) {
                        character.setLocation(0, y);
                        map = mapArray[mapArrayX][mapArrayY + 1];
                        mapArrayY++;

                        // update the tiles use j, k
                        for (int j = 0; j < 15; j++) {
                            for (int k = 0; k < 15; k++) {
                                tiles[j][k].setIcon(
                                        new ImageIcon("com/projects/pokemon/images/" + map[j][k] + ".png"));
                            }
                        }

                    } else if (!checkCollision((x + 32) / 32, y / 32)) {
                        character.setLocation(x + 32, y);
                    }
                } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
                    if (y == 0) {
                        character.setLocation(x, 14 * 32);
                        map = mapArray[mapArrayX - 1][mapArrayY];
                        mapArrayX--;

                        // update the tiles use j, k
                        for (int j = 0; j < 15; j++) {
                            for (int k = 0; k < 15; k++) {
                                tiles[j][k].setIcon(
                                        new ImageIcon("com/projects/pokemon/images/" + map[j][k] + ".png"));
                            }
                        }
                    } else if (!checkCollision(x / 32, (y - 32) / 32)) {
                        character.setLocation(x, y - 32);
                    }
                } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
                    if (y == 14 * 32) {
                        character.setLocation(x, 0);
                        map = mapArray[mapArrayX + 1][mapArrayY];
                        mapArrayX++;

                        // update the tiles use j, k
                        for (int j = 0; j < 15; j++) {
                            for (int k = 0; k < 15; k++) {
                                tiles[j][k].setIcon(
                                        new ImageIcon("com/projects/pokemon/images/" + map[j][k] + ".png"));
                            }
                        }
                    } else if (!checkCollision(x / 32, (y + 32) / 32)) {
                        character.setLocation(x, y + 32);
                    }
                }

                System.out.println("x: " + character.getX() + " y: " + character.getY());
            }
        });

        // create the using a 15x15 grid of tiles
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

    public static boolean checkCollision(int x, int y) {
        // make sure the player cant move into a tree
        // this will be put in the key listener move checks
        if (map[y][x].equals("logs")) {
            return true;
        }
        return false;
    }
}
