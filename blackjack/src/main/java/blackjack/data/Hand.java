/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

import java.util.*;

/**
 * Class is used to contain dealt cards for players
 *
 * @author joju
 */
public class Hand {

    private List<Card> dealtCards;
    private int handValue;
    private int handValueWithAce;

    /**
     * Constructor initializes Hand object and it's attributes.
     */
    public Hand() {
        this.dealtCards = new ArrayList();
        this.handValue = 0;
        this.handValueWithAce = 0;
    }

    public List getDealtCards() {
        return dealtCards;
    }

    public int getHandValue() {
        return handValue;
    }

    public int getHandValueWithAce() {
        return handValueWithAce;
    }

    /**
     * Method adds card to hand's dealtCards list and sums cards value to
     * handValue and handValueWithAce.
     *
     * @param c card dealt to player in game
     */
    public void addCard(Card c) {
        dealtCards.add(c);
        handValue += c.getValue();
        if (handValueWithAce + c.getValue() > 21) {
            handValueWithAce = handValue;
        } else if (c.getName().equals("A") && handValueWithAce < 11) {
            handValueWithAce += 11;
        } else {
            handValueWithAce += c.getValue();
        }
    }

    /**
     * Method returns biggest valid hand value using Math.max method.
     *
     * @return highest hand value of two choices
     */
    public int getHighestValidHand() {
        int h1 = handValue;
        int h2 = handValueWithAce;

        return Math.max(h1, h2);
    }

    /**
     * Method clears hand's dealtCards list and sets handValue to zero.
     */
    public void clearDealtCardsAndHandValueToZero() {
        dealtCards.clear();
        handValue = 0;
        handValueWithAce = 0;
    }
}
