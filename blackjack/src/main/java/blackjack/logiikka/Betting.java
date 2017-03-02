/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.logiikka;

import blackjack.data.*;
import java.util.*;

/**
 * Class offers methods for betting in game.
 *
 * @author joju
 */
public class Betting {

    private int bet;
    private double insurance;
    /**
     * Constructor initializes betting object and sets bet to zero.
     */
    public Betting() {
        this.bet = 0;
        this.insurance = 0;
    }

    public int getBet() {
        return this.bet;
    }
    
    public double getInsurance() {
        return this.insurance;
    }

    /**
     * Method sets bet to given parameter if it is bigger than zero else sets it to zero.
     *
     * @param b wanted amount
     */
    public void setBet(int b) {
        if (b > 0) {
            bet = b;
        } else {
            bet = 0;
        }
    }
    
    /**
     * Method sets insurance value depending on current bet value.
     */
    public void setInsurance() {
        insurance = (double) bet/2;
    }

    /**
     * Method increases bet by one.
     */
    public void betOneMore() {
        bet += 1;
    }

    /**
     * Method decreases bet by one.
     */
    public void betOneLess() {
        if (bet == 0) {
            return;
        }
        bet -= 1;
    }

    /**
     * Method increases bet by given parameter.
     *
     * @param amount increases bet as much amount is
     */
    public void bet(int amount) {
        bet += amount;
    }

    /**
     * Method doubles current bet.
     */
    public void doubleBet() {
        bet += bet;
    }

}
