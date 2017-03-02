package blackjack.data;

import java.util.*;

/**
 * Class makes Player objects for blackjack program. Class is used to create
 * both player playing game and "dealer", which players are playing against.
 *
 * @author joju
 */
public class Player {

    private String name;
    private double money;
    private Hand hand;
    private boolean insurance;

    /**
     * Constructor initializes Player object and it's attributes.
     *
     * @param name user gives name
     * @param money user gives starting money
     */
    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.hand = new Hand();
        this.insurance = false;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public Hand getHand() {
        return hand;
    }
    
    public boolean getInsurance() {
        return insurance;
    }
    
    public void setInsurance(boolean b) {
        insurance = b;
    }

    /**
     * Method adds money to players money balance.
     *
     * @param winAmount depends on result of game
     */
    public void addMoney(double winAmount) {
        if (winAmount >= 0) {
            money += winAmount;
        }
    }

    /**
     * Method removes money from players money balance.
     *
     * @param betAmount user input
     */
    public void removeMoney(double betAmount) {
        if (money >= betAmount && betAmount > 0) {
            money -= betAmount;
        }
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
