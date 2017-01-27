
package blackjack.logiikka;

import blackjack.data.*;

/**
 *
 * @author joju
 */
public class Dealer {
    private Deck deck;
    
    public Dealer() {
        Deck d = new Deck();
        d.createDeck();
        deck = d;
    }
    
    public Card dealCard(int i) {
        return deck.getTopCard(i);
        
    }
    
    
}
