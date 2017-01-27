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
    private int sum;
    
    public Casino() {
        this.sum = 0;
    }
    
    public int getSum() {
        return sum;
    }
    
    public void addToSum(int i) {
        sum += i;
    }
    
    
    
    
}
