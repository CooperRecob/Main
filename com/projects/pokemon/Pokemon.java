package com.projects.pokemon;

import javax.swing.*;
import com.projects.pokemonMapGen.FileIO;

public class Pokemon {

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
        frame.setResizable(true);

        // create the character
        JLabel character = new JLabel(new ImageIcon("com/projects/pokemon/images/character.png"));
        character.setBounds(2 * 32, 2 * 32, 32, 32);
        frame.add(character);

        JLabel[][] tiles = new JLabel[15][15];

        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                int x = character.getX();
                int y = character.getY();

                // check for collision with lggs and set a 5% chance for an encounter
                if (map[y / 32][x / 32].equals("lggs")) {
                    if (Math.random() < 0.15) {
                        System.out.println("Encounter!");
                        encounter();
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

    static int playerHealth = 120;
    static int enemyHealth = 130;
    static boolean enemyDead = false;
    static int potion = 3;

    public static void encounter() {

        // change the window to a battle screen
        JFrame battleFrame = new JFrame("Battle");
        battleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleFrame.setSize(16 * 32, 16 * 32);
        battleFrame.setLocationRelativeTo(null);
        battleFrame.setLayout(null);
        battleFrame.setResizable(true);

        // add buttons on the bottom of the screen for the player to choose an action
        JButton attack = new JButton("Attack");
        attack.setLocation(96, 9 * 32);
        attack.setSize(128, 64);
        battleFrame.add(attack);

        JButton bag = new JButton("Bag");
        bag.setLocation(16 * 32 - (96 + 128), 9 * 32);
        bag.setSize(128, 64);
        battleFrame.add(bag);

        JButton pokemon = new JButton("Pokemon");
        pokemon.setLocation(96, 12 * 32);
        pokemon.setSize(128, 64);
        pokemon.setEnabled(false);
        battleFrame.add(pokemon);

        JButton run = new JButton("Run");
        run.setLocation(16 * 32 - (96 + 128), 12 * 32);
        run.setSize(128, 64);
        battleFrame.add(run);

        // add the enemy sprite
        JLabel enemy = new JLabel(new ImageIcon("com/projects/pokemon/images/charizard.png"));
        enemy.setBounds(8 * 32, -64, 32 * 8, 32 * 8);
        battleFrame.add(enemy);

        // add the player sprite
        JLabel player = new JLabel(new ImageIcon("com/projects/pokemon/images/blastoise.png"));
        player.setBounds(0, 1 * 32, 32 * 8, 32 * 8);
        battleFrame.add(player);

        // add the health bars
        JProgressBar playerHealthBar = new JProgressBar(0, 100);
        playerHealthBar.setValue(120);
        // make it say 120/120
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setString(playerHealth + "/120");
        playerHealthBar.setBounds(32, 16, 6 * 32, 32);
        battleFrame.add(playerHealthBar);

        JProgressBar enemyHealthBar = new JProgressBar(0, 100);
        enemyHealthBar.setValue(130);
        enemyHealthBar.setStringPainted(true);
        enemyHealthBar.setString(enemyHealth + "/130");
        enemyHealthBar.setBounds(8 * 32, 7 * 32, 6 * 32, 32);
        battleFrame.add(enemyHealthBar);

        // attack code
        attack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enemyHealth -= 20;
                if (enemyHealth <= 0) {
                    enemyHealth = 0;
                    enemyDead = true;
                    enemyHealthBar.setValue(enemyHealth);
                    enemyHealthBar.setString(enemyHealth + "/130");
                }
                if (!enemyDead) {
                    enemyHealthBar.setValue(enemyHealth);
                    enemyHealthBar.setString(enemyHealth + "/130");

                    attack.setEnabled(false);
                    bag.setEnabled(false);
                    run.setEnabled(false);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            playerHealth -= 10;
                            playerHealthBar.setValue(playerHealth);
                            playerHealthBar.setString(playerHealth + "/120");
                        }
                    }, 500);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            attack.setEnabled(true);
                            bag.setEnabled(true);
                            run.setEnabled(true);
                        }
                    }, 1000);
                } else {
                    attack.setEnabled(false);
                    bag.setEnabled(false);
                    run.setEnabled(false);
                    playerHealth = 120;
                    enemyHealth = 130;
                    enemyDead = false;

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            battleFrame.dispose();
                        }
                    }, 1000);
                }
            }
        });

        // bag code
        bag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (potion > 0) {
                    playerHealth += 50;
                    if (playerHealth > 120) {
                        playerHealth = 120;
                    }
                    playerHealthBar.setValue(playerHealth);
                    playerHealthBar.setString(playerHealth + "/120");
                    potion--;

                    attack.setEnabled(false);
                    bag.setEnabled(false);
                    run.setEnabled(false);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            playerHealth -= 10;
                            playerHealthBar.setValue(playerHealth);
                            playerHealthBar.setString(playerHealth + "/120");
                        }
                    }, 500);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            attack.setEnabled(true);
                            bag.setEnabled(true);
                            run.setEnabled(true);
                        }
                    }, 1000);
                }
            }
        });

        // run code
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new java.util.Timer().schedule(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        battleFrame.dispose();
                    }
                }, 1000);
            }
        });

        battleFrame.setVisible(true);
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
