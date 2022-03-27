package tests.copilot;

public class Blackjack {
    //create blackjack game
    public static void main(String[] args) {
        //create deck
        Deck deck = new Deck();
        //shuffle deck
        deck.shuffle();
        //create player
        Player player = new Player();
        //create dealer
        Dealer dealer = new Dealer();
        //deal cards
        player.deal(deck);
        dealer.deal(deck);
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        player.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        dealer.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        player.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        dealer.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        player.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        dealer.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        player.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        dealer.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        player.hitOrStay();
        //print cards
        System.out.println(player);
        System.out.println(dealer);
        //hit or stay
        dealer.hitOrStay();
        //print cards
        System.out.println(player);
}
}
