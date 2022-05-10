package edu.apcs.finalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Item> bag = new ArrayList<>();
    private static ArrayList<Pokemon> team = new ArrayList<>();
    private static ArrayList<String> badges = new ArrayList<>();
    private static int purse = 100;

    public static void main(String[] args) {
        bag.add(new Item());
        System.out.println("Welcome to the Pokemon Game!");
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("Hello " + name + "!");
        System.out.println("What pokemon do you want to start with?");
        System.out.println("1. Pikachu");
        System.out.println("2. Squirtle");
        System.out.println("3. Charmander");
        int pokemonChoice = input.nextInt();
        if (pokemonChoice == 1) {
            team.add(new Pokemon(1, 60, new Attack[] { new Attack("Thunder Shock", "normal", 40),
                    new Attack("Quick Attack", "normal", 40) }));
        } else if (pokemonChoice == 2) {
            team.add(new Pokemon("Squirtle", "water", 1, 60, 60,
                    new Attack[] { new Attack("Bite", "normal", 40), new Attack("Water Gun", "normal", 40) }));
        } else if (pokemonChoice == 3) {
            team.add(new Pokemon("Charmander", "fire", 1, 60, 60,
                    new Attack[] { new Attack("Scratch", "normal", 40), new Attack("Ember", "normal", 40) }));
        }
        Trainer user = new Trainer(name, team);
        System.out.println("Your team is: ");
        for (Pokemon pokemon : team) {
            System.out.println(pokemon.getName());
        }
        while (!user.isOutOfPokemon()) {
            System.out.println("What do you want to do?");
            System.out.println("1. Battle a gym leader");
            System.out.println("2. Battle a trainer");
            System.out.println("3. Go into the wild");
            System.out.println("4. Go to the store");
            System.out.println("5. Check your stats");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("Which gym leader do you want to battle?");
                System.out.println("1. Brock");
                System.out.println("2. Misty");
                System.out.println("3. Lt. Surge");
                int gymLeaderChoice = input.nextInt();
                GymLeader gymLeader = new GymLeader("Brock", new ArrayList<Pokemon>(), "Brock's Token of Admiration");
                gymLeader.addPokemon(new Pokemon("Geodude", "rock", 1, 60, 60, new Attack[] {
                        new Attack("Rock Throw", "normal", 40), new Attack("Rock Slide", "normal", 40) }));
                gymLeader.addPokemon(new Pokemon("Onix", "rock", 1, 60, 60, new Attack[] {
                        new Attack("Rock Throw", "normal", 40), new Attack("Rock Slide", "normal", 40) }));
                if (gymLeaderChoice == 2) {
                } else if (gymLeaderChoice == 3) {
                }
                if (battle(user, gymLeader)) {
                    System.out.println("You got " + gymLeader.getName() + "'s badge!");
                    badges.add(gymLeader.getBadge());
                }
            } else if (choice == 2) {
                System.out.println("Which trainer do you want to battle?");
                System.out.println("1. James");
                System.out.println("2. John");
                System.out.println("3. Bug Catcher");
                int trainerChoice = input.nextInt();
                Trainer trainer = new Trainer("James", new ArrayList<Pokemon>());
                trainer.addPokemon(new Pokemon("Pikachu", "electric", 1, 60, 60, new Attack[] {
                        new Attack("Thunder Shock", "normal", 40), new Attack("Quick Attack", "normal", 40) }));
                if (trainerChoice == 2) {
                    trainer = new Trainer("John", new ArrayList<Pokemon>());
                    trainer.addPokemon(new Pokemon("Squirtle", "water", 1, 60, 60,
                            new Attack[] { new Attack("Bite", "normal", 40), new Attack("Water Gun", "normal", 40) }));
                } else if (trainerChoice == 3) {
                    trainer = new Trainer("Bug Catcher", new ArrayList<Pokemon>());
                    trainer.addPokemon(new Pokemon("Metapod", "bug", 1, 60, 60, new Attack[] {
                            new Attack("Bug Bite", "poison", 10), new Attack("Horn Attack", "normal", 40) }));
                }
                if (battle(user, trainer)) {
                    purse += 100;
                }
            } else if (choice == 3) {
                System.out.println("You go into the wild!");
                System.out.println("What pokemon do you want to attack with?");
                for (int i = 0; i < user.getTeam().size(); i++) {
                    System.out.println((i + 1) + ". " + user.getTeam().get(i).getName());
                }
                int pokemonChoice2 = input.nextInt();
                Pokemon[] wildPokemonList = new Pokemon[] {
                        new Pokemon("Pikachu", "electric", 1, 60, 60,
                                new Attack[] { new Attack("Thunder Shock", "normal", 40),
                                        new Attack("Quick Attack", "normal", 40) }),
                        new Pokemon("Squirtle", "water", 1, 60, 60,
                                new Attack[] { new Attack("Bite", "normal", 40),
                                        new Attack("Water Gun", "normal", 40) }),
                        new Pokemon("Charmander", "fire", 1, 60, 60, new Attack[] { new Attack("Scratch", "normal", 40),
                                new Attack("Ember", "normal", 40) }) };
                int rand = (int) (Math.random() * wildPokemonList.length);
                Trainer wildPokemon = new Trainer(wildPokemonList[rand].getName(), new ArrayList<Pokemon>());
                wildPokemon.addPokemon(wildPokemonList[rand]);
                boolean itemInUse = false;
                int poisonCounter = 0;
                while (!wildPokemon.isOutOfPokemon() && !user.isOutOfPokemon()) {
                    System.out.println("What do you want to do?");
                    System.out.println("1. Attack");
                    System.out.println("2. Switch Pokemon");
                    System.out.println("3. Use item");
                    int choice2 = input.nextInt();
                    if (choice2 == 1) {
                        Pokemon userPokemon = user.getTeam().get(pokemonChoice2 - 1);
                        System.out.println("Which pokemon do you want to attack?");
                        for (int i = 0; i < wildPokemon.getTeam().size(); i++) {
                            System.out.println((i + 1) + ". " + wildPokemon.getTeam().get(i).getName());
                        }
                        int enemyPokemonChoice2 = input.nextInt();
                        Pokemon enemyPokemon = wildPokemon.getTeam().get(enemyPokemonChoice2 - 1);
                        System.out.println("What attack do you want to use?");
                        for (int i = 0; i < userPokemon.getAttacks().length; i++) {
                            System.out.println((i + 1) + ". " + userPokemon.getAttacks()[i].getName());
                        }
                        int attackChoice = input.nextInt();
                        if (Math.random() > .05) {
                            userPokemon.attack(userPokemon.getAttacks()[attackChoice - 1], enemyPokemon);
                            System.out.println(userPokemon.getName() + " used "
                                    + userPokemon.getAttacks()[attackChoice - 1].getName() + "!");
                            System.out.println("The enemy " + enemyPokemon.getName() + " has "
                                    + enemyPokemon.getCurrentHealth() + " health left.");
                        } else {
                            System.out.println("The attack missed!");
                        }
                        if (enemyPokemon.getStatus().equals("poisoned")) {
                            poisonCounter++;
                            enemyPokemon.takeDamage(5);
                            if (poisonCounter == 10) {
                                enemyPokemon.setStatus("Healthy");
                                poisonCounter = 0;
                            }
                        }
                        if (enemyPokemon.getCurrentHealth() <= 0) {
                            System.out.println("You won the battle!");
                            break;
                        } else {
                            int randomAttack = (int) (Math.random() * enemyPokemon.getAttacks().length);
                            if (Math.random() > .05) {
                                enemyPokemon.attack(enemyPokemon.getAttacks()[randomAttack], userPokemon);
                                System.out.println(enemyPokemon.getName() + " used "
                                        + enemyPokemon.getAttacks()[randomAttack].getName() + "!");
                                System.out.println(
                                        "Your " + userPokemon.getName() + " has " + userPokemon.getCurrentHealth()
                                                + " health left.");
                            } else {
                                System.out.println("The attack missed!");
                            }
                            if (userPokemon.getStatus().equals("poisoned")) {
                                poisonCounter++;
                                userPokemon.takeDamage(5);
                                if (poisonCounter == 10) {
                                    userPokemon.setStatus("Healthy");
                                    poisonCounter = 0;
                                }
                            }
                        }
                        if (userPokemon.getCurrentHealth() <= 0) {
                            System.out.println("You lost the battle!");
                            break;
                        }
                    } else if (choice2 == 2) {
                        System.out.println("Which pokemon do you want to switch to?");
                        for (int i = 0; i < user.getTeam().size(); i++) {
                            System.out.println((i + 1) + ". " + user.getTeam().get(i).getName());
                        }
                        pokemonChoice2 = input.nextInt();
                    } else if (choice2 == 3) {
                        itemInUse = true;
                        System.out.println("Which item do you want to use?");
                        for (int i = 1; i < bag.size(); i++) {
                            System.out.println(i + ". " + bag.get(i).getName());
                        }
                        int itemChoice = input.nextInt();
                        if (bag.get(itemChoice) != null && itemChoice > 0) {
                            if(bag.get(itemChoice).getName().equals("Pokeball")) {
                                if(Math.random() > 1 - bag.get(itemChoice).getCatchPercentage() && wildPokemon.getTeam().get(0).getCurrentHealth() < wildPokemon.getTeam().get(0).getMaxHealth() / 5) {
                                    System.out.println("You caught the pokemon!");
                                    user.addPokemon(wildPokemon.getTeam().get(0));
                                    bag.remove(itemChoice);
                                    break;
                                } else {
                                    System.out.println("You failed to catch the pokemon!");
                                }
                            }
                            user.useItem(bag.get(itemChoice), team.get(pokemonChoice2 - 1));
                            bag.remove(itemChoice);
                        } else {
                            System.out.println("You don't have that item!");
                        }
                    }
                    if (itemInUse) {
                        user.useItem(bag.get(0), team.get(pokemonChoice2 - 1));
                        itemInUse = false;
                    }
                }
            } else if (choice == 4) {
                System.out.println("You go to the store!");
                System.out.println("What do you want to buy?");
                System.out.println("1. Pokeball");
                System.out.println("2. Health Potion");
                System.out.println("3. Attack Potion");
                System.out.println("4. Defense Potion");
                int storeChoice = input.nextInt();
                if (storeChoice == 1) {
                    System.out.println("How many do you want to buy?");
                    int amount = input.nextInt();
                    if (purse >= amount * 10) {
                        purse -= amount * 10;
                        for (int i = 0; i < amount; i++) {
                            bag.add(new Item("Pokeball", 0.9));
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                } else if (storeChoice == 2) {
                    System.out.println("How many do you want to buy?");
                    int amount = input.nextInt();
                    if (purse >= amount * 20) {
                        purse -= amount * 20;
                        for (int i = 0; i < amount; i++) {
                            bag.add(new Item("Health Potion", 50, 0, 0));
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                } else if (storeChoice == 3) {
                    System.out.println("How many do you want to buy?");
                    int amount = input.nextInt();
                    if (purse >= amount * 20) {
                        purse -= amount * 20;
                        for (int i = 0; i < amount; i++) {
                            bag.add(new Item("Attack Potion", 0, .5, 0));
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                } else if (storeChoice == 4) {
                    System.out.println("How many do you want to buy?");
                    int amount = input.nextInt();
                    if (purse >= amount * 20) {
                        purse -= amount * 20;
                        for (int i = 0; i < amount; i++) {
                            bag.add(new Item("Defense Potion", 0, 0, .5));
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }
                }
            } else if (choice == 5) {
                System.out.println(user);
                System.out.println("You have " + purse + " dollars.");
                System.out.println("Bag: ");
                for (int i = 1; i < bag.size(); i++) {
                    System.out.println(bag.get(i).getName());
                }
                for (String badge : badges) {
                    System.out.println(badge);
                }
            }
        }
        input.close();
    }

    public static boolean battle(Trainer user, Trainer trainer) {
        System.out.println("You attacked " + trainer.getName() + "!");
        System.out.println("What pokemon do you want to attack with?");
        for (int i = 0; i < user.getTeam().size(); i++) {
            System.out.println((i + 1) + ". " + user.getTeam().get(i).getName());
        }
        int pokemonChoice = input.nextInt();
        boolean itemInUse = false;
        int poisonCounter = 0;
        while (!trainer.isOutOfPokemon() && !user.isOutOfPokemon()) {
            System.out.println("What do you want to do?");
            System.out.println("1. Attack");
            System.out.println("2. Switch Pokemon");
            System.out.println("3. Use item");
            int choice2 = input.nextInt();
            if (choice2 == 1) {
                Pokemon userPokemon = user.getTeam().get(pokemonChoice - 1);
                System.out.println("Which pokemon do you want to attack?");
                for (int i = 0; i < trainer.getTeam().size(); i++) {
                    System.out.println((i + 1) + ". " + trainer.getTeam().get(i).getName());
                }
                int enemyPokemonChoice = input.nextInt();
                Pokemon enemyPokemon = trainer.getTeam().get(enemyPokemonChoice - 1);
                System.out.println("What attack do you want to use?");
                for (int i = 0; i < userPokemon.getAttacks().length; i++) {
                    System.out.println((i + 1) + ". " + userPokemon.getAttacks()[i].getName());
                }
                int attackChoice = input.nextInt();
                if (Math.random() > .05) {
                    userPokemon.attack(userPokemon.getAttacks()[attackChoice - 1], enemyPokemon);
                    System.out.println(userPokemon.getName() + " used "
                            + userPokemon.getAttacks()[attackChoice - 1].getName() + "!");
                } else {
                    System.out.println("The attack missed!");
                }
                if (enemyPokemon.getStatus().equals("poisoned")) {
                    poisonCounter++;
                    enemyPokemon.takeDamage(5);
                    if (poisonCounter == 10) {
                        enemyPokemon.setStatus("Healthy");
                        poisonCounter = 0;
                    }
                }
                if (enemyPokemon.getCurrentHealth() <= 0) {
                    System.out.println("You won the battle!");
                    break;
                } else {
                    System.out.println("The enemy has " + enemyPokemon.getCurrentHealth() + " health left.");
                    int randomAttack = (int) (Math.random() * enemyPokemon.getAttacks().length);
                    if (Math.random() > .05) {
                        enemyPokemon.attack(enemyPokemon.getAttacks()[randomAttack], userPokemon);
                        System.out.println(enemyPokemon.getName() + " used "
                                + enemyPokemon.getAttacks()[randomAttack].getName() + "!");
                        System.out.println(
                                userPokemon.getName() + " has " + userPokemon.getCurrentHealth() + " health left.");
                    } else {
                        System.out.println("The attack missed!");
                    }
                    if (userPokemon.getStatus().equals("poisoned")) {
                        poisonCounter++;
                        userPokemon.takeDamage(5);
                        if (poisonCounter == 10) {
                            userPokemon.setStatus("Healthy");
                            poisonCounter = 0;
                        }
                    }
                }
            } else if (choice2 == 2) {
                System.out.println("Which pokemon do you want to switch to?");
                for (int i = 0; i < user.getTeam().size(); i++) {
                    System.out.println((i + 1) + ". " + user.getTeam().get(i).getName());
                }
                pokemonChoice = input.nextInt();
            } else if (choice2 == 3) {
                itemInUse = true;
                System.out.println("Which item do you want to use?");
                for (int i = 1; i < bag.size(); i++) {
                    System.out.println(i + ". " + bag.get(i).getName());
                }
                int itemChoice = input.nextInt();
                if (bag.get(itemChoice) != null && itemChoice > 0) {
                    user.useItem(bag.get(itemChoice), team.get(pokemonChoice - 1));
                    bag.remove(itemChoice);
                } else {
                    System.out.println("You don't have that item!");
                }
                if (itemInUse) {
                    user.useItem(bag.get(0), team.get(pokemonChoice - 1));
                    itemInUse = false;
                }
            }
        }
        if (user.isOutOfPokemon()) {
            return false;
        } else {
            return true;
        }
    }
}
