package blackjack.logiikka;

import blackjack.data.*;
import java.io.IOException;
import java.util.*;

/**
 * Class offers dealer object and methods for dealing hands in blackjack game.
 *
 * @author joju
 */
public class Dealer {

    private Deck deck;
    private String name;

    /**
     * Constructor initializes dealer's name and empty deck for dealer.
     *
     * @param name given name
     */
    public Dealer(String name) {
        this.name = name;
        this.deck = new Deck();

    }

    public Deck getDeck() {
        return deck;
    }

    public String getName() {
        return name;
    }

    /**
     * Method calls method for deck, which adds 52 cards to dealers deck.
     * @throws java.io.IOException if encountering problem
     */
    public void createDeck() throws IOException {
        deck.createDeck();
    }

    /**
     * Method returns size of deck.
     *
     * @return size of dealers deck
     */
    public int deckSize() {
        return deck.getDeckList().size();
    }

    /**
     * Method returns wanted card from position i.
     *
     * @param i "top" card of deck
     * @see blackjack.data.Deck#getCard(int)
     * @return card from deck, position i
     */
    public Card dealCard(int i) {
        return deck.getCard(i);

    }

    /**
     * Method shuffles deck n times using Collections.shuffle method.
     *
     * @param n input how many times deck is shuffled
     */
    public void shuffleDeckNTimes(int n) {
        for (int i = 0; i < n; i++) {
            Collections.shuffle(deck.getDeckList());
        }
    }
}
