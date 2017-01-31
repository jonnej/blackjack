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
public class Casino {
    private int handValue;
    
    public Casino() {
        this.handValue = 0;
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
    
    
    
    
}
