/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import blackjack.data.*;
import blackjack.logiikka.*;
import java.util.Collections;

/**
 *
 * @author joju
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Dealer dealer = new Dealer("jonne");
       dealer.shuffleDeck();
       dealer.getDeck();
    }
    
}
