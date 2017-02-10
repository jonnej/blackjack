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
 * @author joju
 */
public class Betting {

    private int bet;

    public Betting() {
        this.bet = 0;
    }

    public int getBet() {
        return this.bet;
    }
    
    public void setBet(int b) {
        if (b > 0) {
            bet = b;
        } else {
            bet = 0;
        }
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

}
