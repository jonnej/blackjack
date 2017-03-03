/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

/**
 * Class creates Card Deck for program. Class contains methods to handle deck.
 */
public class Deck {

    private List<Card> deck;
    private String[] suit = {"spades", "clubs", "diamonds", "hearts"};
    private String[] name = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * Constructor creates Deck object and initializes ArrayList for keeping
     * cards.
     */
    public Deck() {
        this.deck = new ArrayList<>();
    }

    /**
     * Method adds 52 French playing cards to deck. Calling method again will
     * add new 52 cards. After that deck will consist of 104 cards and every
     * card will have one duplicate. Calling over and over again will do the
     * same. Method also resized card images to wanted size.
     */
    public void createDeck() {
        for (String s : suit) {
            int value = 1;
            for (String n : name) {
                String path = "card-images/" + n + "_of_" + s + ".png";
                InputStream is = getClass().getClassLoader().getResourceAsStream(path);
                BufferedImage bf = null;
                try {
                    bf = ImageIO.read(is);
                } catch (IOException ex) {
                    Logger.getLogger(Deck.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Can't create deck");
                }
                ImageIcon ic = new ImageIcon(bf);
                ImageIcon reSized = resizeImageIcon(ic);
                deck.add(new Card(n, s, value, reSized));
                if (value < 10) {
                    value++;
                }
            }
        }
    }

    /**
     * Method scales given card's image icon to better size.
     *
     * @param ic image icon to resize
     * @see blackjack.data.Card#getImageIcon()
     * @return card's image icon resized
     */
    public ImageIcon resizeImageIcon(ImageIcon ic) {
        Image image = ic.getImage(); // transform it 
        Image newimg = image.getScaledInstance(70, 102, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        ic = new ImageIcon(newimg);  // transform it back
        return ic;
    }

    /**
     * Method gets wanted card from deck list using position.
     *
     * @param i position of top card of deck
     * @return wanted card
     */
    public Card getCard(int i) {
        return deck.get(i);
    }

    public List getDeckList() {
        return deck;
    }
}
