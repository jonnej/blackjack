/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.logiikka;

import blackjack.data.*;
import java.util.*;

public class Betting {

    private int bet;

    public Betting() {
        this.bet = 0;
    }

    public int getBet() {
        return this.bet;
    }

    public void setBet(int b) {
        this.bet = b;
    }
    
    public void betOneMore() {
        bet += 1;
    }
    
    public void betOneLess() {
        if (bet == 0) {
            return;
        }
        bet -= 1;
    }
    
    

}
