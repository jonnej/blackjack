package blackjack.data;

import java.util.*;

public class Player {

    private String name;
    private double money;
    private int handValue;
    private List<Card> dealtCards;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.handValue = 0;
        this.dealtCards = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
    
    public List getDealtCards() {
        return dealtCards;
    }

    public void addMoney(int winAmount) {
        if (winAmount > 0) {
            money += winAmount;
        }
    }

    public void removeMoney(int betAmount) {
        if (betAmount > 0 & money >= betAmount) {
            money -= betAmount;
        }
    }

    public int getHandValue() {
        return handValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addCard(Card c) {
        dealtCards.add(c);
        handValue += c.getValue();
    }

    public void printDealtCards() {
        for (Card c : dealtCards) {
            System.out.println(c);
        }
    }

    public void clearDealtCardsAndHandValueToZero() {
        dealtCards.clear();
        handValue = 0;
    }

    @Override
    public String toString() {
        return this.name + ", rahaa " + this.money;
    }

}
