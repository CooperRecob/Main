package com.projects.pokemon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Encounter {
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
        battleFrame.setResizable(false);

        // add buttons on the bottom of the screen for the player to choose an action
        JButton attack = new JButton("Attack");
        attack.setLocation(96, 9 * 32);
        attack.setSize(128, 64);
        battleFrame.add(attack);

        JButton bag = new JButton("Bag 3/3");
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
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setString("Blastoise " + playerHealth + "/120");
        playerHealthBar.setBounds(32, 16, 6 * 32, 32);
        battleFrame.add(playerHealthBar);

        JProgressBar enemyHealthBar = new JProgressBar(0, 100);
        enemyHealthBar.setValue(130);
        enemyHealthBar.setStringPainted(true);
        enemyHealthBar.setString("Charziard " + enemyHealth + "/130");
        enemyHealthBar.setBounds(8 * 32, 7 * 32, 6 * 32, 32);
        battleFrame.add(enemyHealthBar);

        // add the "used attack" text right below charizard
        JLabel usedAttack = new JLabel("You encountered a wild Charziard!");
        usedAttack.setBounds(8 * 32, 8 * 32, 8 * 32, 32);
        battleFrame.add(usedAttack);

        // add the background
        JLabel background = new JLabel(new ImageIcon("com/projects/pokemon/images/background.png"));
        background.setBounds(0, 0, 16 * 32, 16 * 32);
        battleFrame.add(background);

        // attack code
        attack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedAttack.setText("Blastoise used Water Gun!");
                enemyHealth -= 20;
                if (enemyHealth <= 0) {
                    enemyHealth = 0;
                    enemyDead = true;
                    enemyHealthBar.setValue(enemyHealth);
                    enemyHealthBar.setString("Charziard " + enemyHealth + "/130");
                }
                if (!enemyDead) {
                    enemyHealthBar.setValue(enemyHealth);
                    enemyHealthBar.setString("Charziard " + enemyHealth + "/130");

                    attack.setEnabled(false);
                    bag.setEnabled(false);
                    run.setEnabled(false);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            usedAttack.setText("Charziard used Flamethrower!");
                            playerHealth -= 10;
                            playerHealthBar.setValue(playerHealth);
                            playerHealthBar.setString("Blastoise " + playerHealth + "/120");
                        }
                    }, 500);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            usedAttack.setText("");
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
                    usedAttack.setText("Blastoise used Potion! Healed 50 HP!");
                    playerHealth += 50;
                    if (playerHealth > 120) {
                        playerHealth = 120;
                    }
                    playerHealthBar.setValue(playerHealth);
                    playerHealthBar.setString("Blastoise " + playerHealth + "/120");
                    potion--;
                    bag.setText("Bag " + potion + "/3");

                    attack.setEnabled(false);
                    bag.setEnabled(false);
                    run.setEnabled(false);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            usedAttack.setText("Charziard used Flamethrower!");
                            playerHealth -= 10;
                            playerHealthBar.setValue(playerHealth);
                            playerHealthBar.setString("Blastoise " + playerHealth + "/120");
                        }
                    }, 500);

                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            usedAttack.setText("");
                            attack.setEnabled(true);
                            bag.setEnabled(true);
                            run.setEnabled(true);
                        }
                    }, 1000);
                } else {
                    usedAttack.setText("You have no more potions!");
                }
            }
        });

        // run code
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedAttack.setText("You ran away!");
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
}
