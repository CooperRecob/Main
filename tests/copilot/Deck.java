package tests.copilot;

public class Deck {
//shuffle method
    public void shuffle() {
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
//hit method
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
//stay method
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
    
}
