package edu.apcs.unit9.overwritingMethods;

public class Cooper extends CoCPlayer {
    private String momsName;
    private int momsAge;

    public Cooper(int age, String name, int momsAge, String momsName) {
        super(15, "Cooper", 89, "CooperRecob");
        this.momsAge = momsAge;
        this.momsName = momsName;
    }

    public void playCoC(int hours) {
        System.out.println("I am playing COC for " + hours + " hours");
        System.out.println("I am also playing with my mom " + momsName + " who is " + momsAge + " years old");
    }
}
