/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

import java.util.*;

/**
 * Class creates Card Deck for program. 
 * Class contains methods to handle deck.
 */
public class Deck {

    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    /**
    * Method adds 52 French playing cards to deck.
    * Calling method again will add new 52 cards.
    * After that deck will consist of 104 cards and every card
    * will have one duplicate.
    * Calling over and over again will work same.
    */
    public void createDeck() {
        String suit = "spades";
        for (int i = 1; i < 5; i++) {
            if (i == 2) {
                suit = "clubs";
            } else if (i == 3) {
                suit = "diamonds";
            } else if (i == 4) {
                suit = "hearts";
            }
            for (int j = 1; j < 14; j++) {
                if (j == 1) {
                    deck.add(new Card("A", suit, 1));
                } else if (j < 11) {
                    deck.add(new Card("" + j, suit, j));
                } else if (j == 11) {
                    deck.add(new Card("J", suit, 10));
                } else if (j == 12) {
                    deck.add(new Card("Q", suit, 10));
                } else if (j == 13) {
                    deck.add(new Card("K", suit, 10));
                }

            }
        }
    }
    /**
     * Method gets wanted card from deck list using position.
     * @param i 
     * @return wanted card
     */
    public Card getCard(int i) {
        return deck.get(i);
    }

    public List getDeckList() {
        return deck;
    }
    
    /**
     * Method prints deck
     */
    public void printDeck() {
        for (Card c : deck) {
            System.out.println(c);
        }
    }

}
