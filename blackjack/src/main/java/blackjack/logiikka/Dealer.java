package blackjack.logiikka;

import blackjack.data.*;
import java.util.*;

/**
 *
 * @author joju
 */
public class Dealer {

    private Deck deck;
    private String name;

    public Dealer(String name) {
        this.name = name;
        this.deck = new Deck();
        deck.createDeck();
    }
    public Deck getDeck() {
        return deck;
    }
    public String getName() {
        return name;
    }

    public Card dealCard(int i) {
        return deck.getCard(i);

    }

    public void shuffleDeckNTimes(int n) {
        for (int i = 0; i < n; i++) {
        Collections.shuffle(deck.getDeckList());
        }
    }

    public void printDealersDeck() {
        deck.printDeck();
    }
    
    

}
