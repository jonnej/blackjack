/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

import java.util.*;

/**
 *
 * @author joju
 */
public class Casino {

    private int handValue;
    private List<Card> dealtCards;

    public Casino() {
        this.handValue = 0;
        this.dealtCards = new ArrayList();
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValueZero() {
        this.handValue = 0;
    }

    public void addToHandValue(int i) {
        handValue += i;
    }

    public void addCard(Card c) {
        dealtCards.add(c);
        handValue += c.getValue();
    }

    public void printDealtCards() {
        for (Card c : dealtCards) {
            System.out.println(c);
        }
    }

    public void clearDealtCardsAndHandValueToZero() {
        dealtCards.clear();
        handValue = 0;
    }

}
