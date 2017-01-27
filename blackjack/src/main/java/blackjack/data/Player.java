/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

public class Player {
    private String name;
    private double money;
    private int cardValueTotal;
    
    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.cardValueTotal = 0;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
    
    public int getCardValueTotal() {
        return cardValueTotal;
    }
    
    public void addToSum(int i) {
        cardValueTotal += i;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    

    @Override
    public String toString() {
        return this.name + ", rahaa " + this.money;
    }
    
    
}
