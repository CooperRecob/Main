package com.projects.pokemon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Encounter {
    static Pokemon player = new Pokemon("Blastoise", 120, new String[] { "Water Gun", "Hydro Pump", "Surf" },
            new int[] { 20, 40, 30 });
    static Pokemon enemy = new Pokemon("Charziard", 130, new String[] { "Flamethrower", "Fire Blast", "Ember" },
            new int[] { 10, 30, 20 });
    static String playerName = player.getName();
    static String enemyName = enemy.getName();

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

        JButton bag = new JButton("Bag");
        bag.setLocation(16 * 32 - (96 + 128), 9 * 32);
        bag.setSize(128, 64);
        battleFrame.add(bag);

        JButton pokemon = new JButton("Pokemon");
        pokemon.setLocation(96, 12 * 32);
        pokemon.setSize(128, 64);
        battleFrame.add(pokemon);

        JButton run = new JButton("Run");
        run.setLocation(16 * 32 - (96 + 128), 12 * 32);
        run.setSize(128, 64);
        battleFrame.add(run);

        // add the enemy sprite
        JLabel enemySprite = new JLabel(new ImageIcon("com/projects/pokemon/images/" + enemyName + ".png"));
        enemySprite.setBounds(8 * 32, -64, 32 * 8, 32 * 8);
        battleFrame.add(enemySprite);

        // add the player sprite
        JLabel playerSprite = new JLabel(new ImageIcon("com/projects/pokemon/images/" + playerName + ".png"));
        playerSprite.setBounds(0, 1 * 32, 32 * 8, 32 * 8);
        battleFrame.add(playerSprite);

        // add the health bars
        JProgressBar playerHealthBar = new JProgressBar(0, 100);
        playerHealthBar.setValue(120);
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setString(playerName + " " + player.getHealth() + "/120");
        playerHealthBar.setBounds(32, 16, 6 * 32, 32);
        battleFrame.add(playerHealthBar);

        JProgressBar enemyHealthBar = new JProgressBar(0, 100);
        enemyHealthBar.setValue(130);
        enemyHealthBar.setStringPainted(true);
        enemyHealthBar.setString(enemyName + " " + enemy.getHealth() + "/130");
        enemyHealthBar.setBounds(8 * 32, 7 * 32, 6 * 32, 32);
        battleFrame.add(enemyHealthBar);

        // add the "note" text right below enemy sprite
        JLabel note = new JLabel("You encountered a wild " + enemyName + "!");
        note.setBounds(8 * 32, 8 * 32, 8 * 32, 32);
        battleFrame.add(note);

        // add the background
        JLabel background = new JLabel(new ImageIcon("com/projects/pokemon/images/background.png"));
        background.setBounds(0, 0, 16 * 32, 16 * 32);
        battleFrame.add(background);

        // attack code
        attack.addActionListener(new java.awt.event.ActionListener() {
            /*
             * public void actionPerformed(java.awt.event.ActionEvent evt) {
             * 
             * note.setText("Blastoise used Water Gun!");
             * enemyHealth -= 20;
             * if (enemyHealth <= 0) {
             * enemyHealth = 0;
             * enemyDead = true;
             * enemyHealthBar.setValue(enemyHealth);
             * enemyHealthBar.setString("Charziard " + enemyHealth + "/130");
             * }
             * if (!enemyDead) {
             * enemyHealthBar.setValue(enemyHealth);
             * enemyHealthBar.setString("Charziard " + enemyHealth + "/130");
             * 
             * attack.setEnabled(false);
             * bag.setEnabled(false);
             * run.setEnabled(false);
             * 
             * new java.util.Timer().schedule(new java.util.TimerTask() {
             * 
             * @Override
             * public void run() {
             * note.setText("Charziard used Flamethrower!");
             * playerHealth -= 10;
             * playerHealthBar.setValue(playerHealth);
             * playerHealthBar.setString("Blastoise " + playerHealth + "/120");
             * }
             * }, 500);
             * 
             * new java.util.Timer().schedule(new java.util.TimerTask() {
             * 
             * @Override
             * public void run() {
             * note.setText("");
             * attack.setEnabled(true);
             * bag.setEnabled(true);
             * run.setEnabled(true);
             * }
             * }, 1000);
             * } else {
             * attack.setEnabled(false);
             * bag.setEnabled(false);
             * run.setEnabled(false);
             * playerHealth = 120;
             * enemyHealth = 130;
             * enemyDead = false;
             * 
             * new java.util.Timer().schedule(new java.util.TimerTask() {
             * 
             * @Override
             * public void run() {
             * battleFrame.dispose();
             * }
             * }, 1000);
             * }
             * }
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttackWindow.attack(player);
            }
        });

        // bag code
        bag.addActionListener(new java.awt.event.ActionListener() {
            /*
             * public void actionPerformed(java.awt.event.ActionEvent evt) {
             * if (potion > 0) {
             * note.setText("Blastoise used Potion! Healed 50 HP!");
             * playerHealth += 50;
             * if (playerHealth > 120) {
             * playerHealth = 120;
             * }
             * playerHealthBar.setValue(playerHealth);
             * playerHealthBar.setString("Blastoise " + playerHealth + "/120");
             * potion--;
             * bag.setText("Bag " + potion + "/3");
             * 
             * attack.setEnabled(false);
             * bag.setEnabled(false);
             * run.setEnabled(false);
             * 
             * new java.util.Timer().schedule(new java.util.TimerTask() {
             * 
             * @Override
             * public void run() {
             * note.setText("Charziard used Flamethrower!");
             * playerHealth -= 10;
             * playerHealthBar.setValue(playerHealth);
             * playerHealthBar.setString("Blastoise " + playerHealth + "/120");
             * }
             * }, 500);
             * 
             * new java.util.Timer().schedule(new java.util.TimerTask() {
             * 
             * @Override
             * public void run() {
             * note.setText("");
             * attack.setEnabled(true);
             * bag.setEnabled(true);
             * run.setEnabled(true);
             * }
             * }, 1000);
             * } else {
             * note.setText("You have no more potions!");
             * }
             * }
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagWindow.bag();
            }
        });

        // pokemon code
        pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwitchWindow.switchPokemon();
            }
        });

        // run code
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                note.setText("You ran away!");
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
