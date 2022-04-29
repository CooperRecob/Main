package edu.apcs.unit9.overwritingMethods;

public class CoCPlayer extends Person {
    int lvl;
    String username;

    public CoCPlayer(int age, String name, int lvl, String username) {
        super(age, name);
        this.lvl = lvl;
        this.username = username;
    }

    public void beCool() {
        System.out.println("Hoo Rah I am a cool player who play COC!!!");
    }

    public void playCoC(int hours) {
        System.out.println("I am playing COC for " + hours + " hours");
    }

    public String toString() {
        return super.toString() + " and I am a CoC player";
    }
}
