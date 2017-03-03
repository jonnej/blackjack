/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.guilogiikka;

import blackjack.data.Player;
import blackjack.logiikka.Betting;
import blackjack.logiikka.Dealer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class has methods for GUI.
 *
 * @author joju
 */
public class UicDealing {

    private int position;
    
    /**
     * Class constructor initializes needed attributes. 
     */
    public UicDealing() {
        position = 0;
    }
    /**
     * Methods sets position attribute to zero.
     */
    public void setPositionZero() {
        position = 0;
    }
    /**
     * Method return position.
     * @return current position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Method clears hands, sets position counter to zero and shuffles deck 3
     * times. Used before hand starts
     *
     * @param p1 user player
     * @param p2 casino player
     * @param d used dealer object
     * @param b used betting object
     */
    public void startBetting(Player p1, Player p2, Dealer d, Betting b) {
        p1.setInsurance(false);
        setPositionZero();
        p1.getHand().clearDealtCardsAndHandValueToZero();
        p2.getHand().clearDealtCardsAndHandValueToZero();
        d.shuffleDeckNTimes(3);
    }

    /**
     * Method adds card image to given JPanel.
     *
     * @param p given player
     * @param jp given player's JPanel
     * @param d used dealer object
     */
    public void addCardImage(Player p, JPanel jp, Dealer d) {
        JLabel jlabel = new JLabel();
        ImageIcon ic = dealCard(p, d);
        jlabel.setIcon(ic);
        jlabel.setVisible(true);
        jp.add(jlabel);
    }

    /**
     * Method adds card to given player object. Both player and dealer. Returns
     * dealt card image icon used to show what has been dealt.
     *
     * @param p player dealt card
     * @param d dealer object dealing cards
     * @see blackjack.data.Player#getHand() 
     * @see blackjack.data.Hand#addCard(Card)
     * @see blackjack.logiikka.Dealer#dealCard(int)
     * @see blackjack.data.Card#getImageIcon()
     * @return dealt card's image icon
     */
    public ImageIcon dealCard(Player p, Dealer d) {
        p.getHand().addCard(d.dealCard(position));
        position++;
        return d.dealCard(position - 1).getImageIcon();
    }

    /**
     * Method returns given player's smallest hand value. Used by both user and
     * casino player objects.
     *
     * @param p given player
     * @see blackjack.data.Hand#getHandValue()
     * @return player's hand value
     */
    public int getHandValue(Player p) {
        return p.getHand().getHandValue();
    }

    /**
     * Method returns hand value with biggest value. Needed because Ace has
     * value of 1 and 11.
     *
     * @param p given player
     * @see blackjack.data.Hand#getHighestValidHand()
     * @return player's biggest hand value
     */
    public int getBiggestValidHandValue(Player p) {
        return p.getHand().getHighestValidHand();
    }

    /**
     * Method used to show current hand values to player. Showing both values
     * when ace in hand and bigger value less than 22
     *
     * @param p given player
     * @see blackjack.data.Player#getHand() 
     * @see blackjack.data.Hand#getHandValue()
     * @see blackjack.data.Hand#getHandValueWithAce()
     * @return hand value using string
     */
    public String printHandValue(Player p) {
        if (p.getHand().getHandValue() != p.getHand().getHandValueWithAce() && p.getHand().getHandValueWithAce() < 22) {
            return p.getHand().getHandValue() + "/" + p.getHand().getHandValueWithAce();
        }
        return "" + p.getHand().getHandValue();
    }

}