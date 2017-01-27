/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

/**
 *
 * @author joju
 */
public class Card {
    private String name;
    private String suit;
    
    public Card(String name, String suit) {
        this.name = name;
        this.suit = suit;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return name + " " + suit;
    }
    
}
