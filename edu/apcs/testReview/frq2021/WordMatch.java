package edu.apcs.testReview.frq2021;

public class WordMatch{
    private String secret;

    public WordMatch(String word){
        secret = word;
    }

    public int scoreGuess(String guess){
        int score = 0;
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                score++;
            }
        }
        return (int) (score * Math.pow(guess.length(), 2));
    }

    public String findBetterGuess(String guess1, String guess2) {
        int score1 = scoreGuess(guess1);
        int score2 = scoreGuess(guess2);

        if(score1 > score2){
            return guess1;
        } else if (score1 < score2) {
            return guess2;
        } else {
            if(guess1.compareTo(guess2) > 0){
                return guess1;
            } else {
                return guess2;
            }
        }
    }
}