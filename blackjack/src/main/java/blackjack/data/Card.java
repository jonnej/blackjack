/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

import javax.swing.ImageIcon;

/**
 * Class makes Card object for blackjack program.
 */
public class Card {

    private String name;
    private String suit;
    private int value;
    private ImageIcon ic;

    /**
     * Constructor initilizes Card object and it's attributes.
     *
     * @param name card's name
     * @param suit card's suit
     * @param value card's value
     * @param ic card's image
     */
    public Card(String name, String suit, int value, ImageIcon ic) {
        this.name = name;
        this.suit = suit;
        this.value = value;
        this.ic = ic;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public ImageIcon getImageIcon() {
        return ic;
    }

    @Override
    public String toString() {
        return name + " of " + suit;
    }

}
