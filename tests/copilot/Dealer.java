package tests.copilot;

public class Dealer {
    //create hitorstay method
    public void hitOrStay() {
        //create random number
        int random = (int) (Math.random() * 2);
        //if random number is 0
        if (random == 0) {
            //hit
            hit();
        }
        //if random number is 1
        else if (random == 1) {
            //stay
            stay();
        }
    }

    //create hit method
    public void hit() {
        //create random number
        int random = (int) (Math.random() * 2);
        //if random number is 0
        if (random == 0) {
            //hit
            hit();
        }
        //if random number is 1
        else if (random == 1) {
            //stay
            stay();
        }
    }

    //create stay method
    public void stay() {
        //create random number
        int random = (int) (Math.random() * 2);
        //if random number is 0
        if (random == 0) {
            //hit
            hit();
        }
        //if random number is 1
        else if (random == 1) {
            //stay
            stay();
        }
    }
    //deal method with deck parameter
    public void deal(Deck deck) {
        //create random number
        int random = (int) (Math.random() * 2);
        //if random number is 0
        if (random == 0) {
            //hit
            hit();
        }
        //if random number is 1
        else if (random == 1) {
            //stay
            stay();
        }
    }
    
}
